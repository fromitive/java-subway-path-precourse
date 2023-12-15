package subway.domain;

import java.util.ArrayList;
import java.util.List;

import org.jgrapht.alg.util.Pair;

public class Station {
    private String name;
    private List<Pair<Station, ConnectionInfo>> connectionInfo = new ArrayList<>();

    public Station(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addConnectionInfo(Station connect, ConnectionInfo info) {
        connectionInfo.add(new Pair<>(connect, info));
    }

    public ConnectionInfo getConnectionInfo(Station target) {
        return connectionInfo.stream()
                .filter(pair -> pair.getFirst().equals(target))
                .findAny()
                .get()
                .getSecond();
    }

    public String toString() {
        return String.format("[INFO] %s", name);
    }
    // 추가 기능 구현
}
