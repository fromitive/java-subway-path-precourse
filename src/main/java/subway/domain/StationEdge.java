package subway.domain;

public class StationEdge {
    Station left;
    Station right;
    ConnectionInfo info;

    private StationEdge(Station left, Station right, ConnectionInfo info) {
        this.left = left;
        this.right = right;
        this.info = info;
    }

    public static StationEdge from(Station left, Station right, ConnectionInfo info) {
        return new StationEdge(left, right, info);
    }

    public Station getLeft() {
        return left;
    }

    public Station getRight() {
        return right;
    }

    public ConnectionInfo getInfo() {
        return info;
    }

}
