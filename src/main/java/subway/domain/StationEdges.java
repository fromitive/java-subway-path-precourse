package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StationEdges {
    List<StationEdge> edges = new ArrayList<>();

    public void addEdge(Station from, Station to, ConnectionInfo info) {
        edges.add(StationEdge.from(from, to, info));
    }

    public static StationEdges empty() {
        return new StationEdges();
    }

    public List<StationEdge> getEdges(){
        return Collections.unmodifiableList(edges);
    }
}
