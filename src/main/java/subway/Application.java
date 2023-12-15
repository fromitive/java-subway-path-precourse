package subway;

import java.util.Scanner;

import subway.view.InputView;
import subway.view.OutputView;
import subway.view.ConsoleInputView;
import subway.view.ConsoleOutputView;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final OutputView output = new ConsoleOutputView();
        final InputView input = ConsoleInputView.from(scanner);

        final ServiceController service = ServiceController.from(output, input);
        service.start();
    }
}
