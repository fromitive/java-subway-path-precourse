package subway.view;

import java.util.List;

import subway.domain.ConnectionInfo;
import subway.domain.Menu;
import subway.domain.Station;

public class ConsoleOutputView implements OutputView {

    @Override
    public void printDistanceResult(ConnectionInfo resultInfo, List<Station> path) {
        System.out.println(resultInfo);
        path.stream().forEach(System.out::println);
    }

    @Override
    public void printInputStation(String stationName) {
        System.out.printf("## %s을 입력하세요", stationName).println();

    }

    @Override
    public void printMenu(Menu menu) {
        System.out.printf("## %s", menu.titleName()).println();
        menu.getChoiceName().stream().forEach(System.out::println);
        System.out.println();
    }

    @Override
    public void selectFunction() {
        System.out.println("## 원하는 기능을 선택하세요.");
    }

    @Override
    public void printLine() {
        System.out.println("");
    }

    @Override
    public void printString(String message) {
        System.out.println(message);
    }
}
