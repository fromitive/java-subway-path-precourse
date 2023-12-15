package subway.domain;

public class StationNotFoundError extends CommonArgumentError {
    private static final String STATION_NOT_FOUND = "존재하지 않는 역이름 입니다. [%s]";

    public StationNotFoundError(String name) {
        super(String.format(STATION_NOT_FOUND, name));
    }
}
