package subway;

import java.util.Scanner;

import subway.domain.Action;
import subway.domain.Choice;
import subway.domain.ConnectionInfo;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Menu;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.service.DistanceFirstPathService;
import subway.service.MenuService;
import subway.service.PathService;
import subway.service.TimeFirstService;
import subway.view.InputView;
import subway.view.OutputView;
import subway.view.ConsoleInputView;
import subway.view.ConsoleOutputView;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final Action noting = () -> System.out.println("미구현");
        StationRepository.addStation(new Station("교대역"));
        StationRepository.addStation(new Station("강남역"));
        StationRepository.addStation(new Station("역삼역"));
        StationRepository.addStation(new Station("남부터미널역"));
        StationRepository.addStation(new Station("양재역"));
        StationRepository.addStation(new Station("양재시민의숲역"));
        StationRepository.addStation(new Station("매봉역"));
        Line line_2 = new Line("2호선");
        line_2.addConnection(StationRepository.searchByName("교대역"),
                StationRepository.searchByName("강남역"),
                ConnectionInfo.from(2, 3));
        line_2.addConnection(StationRepository.searchByName("강남역"),
                StationRepository.searchByName("역삼역"),
                ConnectionInfo.from(2, 3));
        Line line_3 = new Line("3호선");
        line_3.addConnection(StationRepository.searchByName("교대역"),
                StationRepository.searchByName("남부터미널역"),
                ConnectionInfo.from(3, 2));
        line_3.addConnection(StationRepository.searchByName("남부터미널역"),
                StationRepository.searchByName("양재역"),
                ConnectionInfo.from(6, 5));
        line_3.addConnection(StationRepository.searchByName("양재역"),
                StationRepository.searchByName("매봉역"),
                ConnectionInfo.from(1, 1));
        Line line_new_bundang = new Line("신분당선");
        line_new_bundang.addConnection(StationRepository.searchByName("강남역"),
                StationRepository.searchByName("양재역"),
                ConnectionInfo.from(2, 8));
        line_new_bundang.addConnection(StationRepository.searchByName("양재역"),
                StationRepository.searchByName("양재시민의숲역"),
                ConnectionInfo.from(10, 3));

        LineRepository.addLine(line_2);
        LineRepository.addLine(line_3);
        LineRepository.addLine(line_new_bundang);

        InputView input = ConsoleInputView.from(scanner);
        OutputView output = new ConsoleOutputView();
        Menu menu1 = Menu.from("메인 메뉴");
        Menu menu2 = Menu.from("경로 조회");
        MenuService menuService = new MenuService(menu1, input, output);
        MenuService menuService2 = new MenuService(menu2, input, output);
        PathService distanceFirstService = DistanceFirstPathService.from(output, input);
        PathService timeFirstService = TimeFirstService.from(output, input);

        menuService.addChoice(Choice.from("1", "경로 조회", () -> menuService2.start()));
        menuService.addChoice(Choice.from("Q", "나가기", noting));

        menuService2.addChoice(Choice.from("1", "최단 거리", () -> distanceFirstService.start()));
        menuService2.addChoice(Choice.from("2", "최소 시간", () -> timeFirstService.start()));
        menuService2.addChoice(Choice.from("B", "돌아가기", () -> menuService.start()));
        menuService.start();
    }
}
