package subway.domain;

import java.util.List;

public class Line {
    private String name;
    private StationEdges stationEdges = StationEdges.empty();

    public Line(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addConnection(Station left, Station right, ConnectionInfo info) {
        left.addConnectionInfo(right, info);
        right.addConnectionInfo(left, info);
        stationEdges.addEdge(left, right, info);
    }

    public List<StationEdge> getStationEdges() {
        return stationEdges.getEdges();
    }
}
