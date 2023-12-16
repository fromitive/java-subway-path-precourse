package subway.view;

import java.util.List;

import subway.domain.ConnectionInfo;
import subway.domain.Station;
import subway.domain.menu.Menu;

public interface OutputView {
    void printMenu(Menu menu);

    void selectFunction();

    void printLine();

    void printString(String message);

    void printDistanceResult(ConnectionInfo resultInfo, List<Station> path);

    void printInputStation(String stationName);

}
