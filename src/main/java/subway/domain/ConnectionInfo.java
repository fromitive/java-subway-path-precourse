package subway.domain;

public class ConnectionInfo {
    public static ConnectionInfo ZERO = ConnectionInfo.from(0, 0);
    int km;
    int time;

    private ConnectionInfo(int km, int time) {
        this.km = km;
        this.time = time;
    }

    public static ConnectionInfo from(int km, int time) {
        return new ConnectionInfo(km, time);
    }

    public int getTime() {
        return time;
    }

    public int getKM() {
        return km;
    }

    public ConnectionInfo add(ConnectionInfo other) {
        return new ConnectionInfo(this.km + other.km, this.time + other.time);
    }

    public String toString() {
        // [INFO] ---
        // [INFO] 총 거리: 4km
        // [INFO] 총 소요 시간: 11분
        // [INFO] ---
        return String.format("[INFO] ---\n[INFO] 총 거리 : %dkm\n[INFO] 총 소요 시간 : %d분\n[INFO] ---", km, time);
    }
}
