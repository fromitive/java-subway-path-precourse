package subway.service;

import java.util.List;
import java.util.stream.IntStream;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

import subway.domain.ConnectionInfo;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationEdge;
import subway.domain.StationRepository;
import subway.view.InputView;
import subway.view.OutputView;

public abstract class PathService {
    private WeightedMultigraph<Station, DefaultWeightedEdge> graph = new WeightedMultigraph(DefaultWeightedEdge.class);
    private OutputView output;
    private InputView input;

    private void init() {
        StationRepository.stations().stream()
                .forEach(station -> graph.addVertex(station));
        LineRepository.lines().stream()
                .forEach(line -> line.getStationEdges().stream()
                        .forEach(edge -> graph.setEdgeWeight(graph.addEdge(edge.getLeft(), edge.getRight()),
                                setWeight(edge))));
    }

    protected PathService(OutputView output, InputView input) {
        this.output = output;
        this.input = input;
    }

    private List<Station> showDistance(Station start, Station end) {
        init();
        DijkstraShortestPath<Station, DefaultWeightedEdge> dijkstraShortestPath = new DijkstraShortestPath<>(graph);
        return dijkstraShortestPath.getPath(start, end).getVertexList();
    }

    private ConnectionInfo sumConnectionInfo(List<Station> stations) {
        return IntStream.range(0, stations.size() - 1)
                .mapToObj(index -> stations.get(index).getConnectionInfo(stations.get(index + 1)))
                .reduce(ConnectionInfo.ZERO, ConnectionInfo::add);
    }

    public void start() {
        Station start = getStationFromInput("출발역");
        Station end = getStationFromInput("도착역");

        if (start.equals(end)) {
            throw new IllegalArgumentException("[ERROR] 같은역 안대요");
        }
        
        List<Station> path = showDistance(start, end);
        ConnectionInfo connectionInfo = sumConnectionInfo(path);
        output.printDistanceResult(connectionInfo, path);
    }

    private Station getStationFromInput(String stationName) {
        output.printInputStation(stationName);
        String name = input.read();
        output.printLine();
        Station station = StationRepository.searchByName(name);
        return station;
    }

    protected abstract double setWeight(StationEdge edge);
}
