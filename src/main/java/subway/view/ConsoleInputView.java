package subway.view;

import java.util.Scanner;

public class ConsoleInputView implements InputView{
    private final Scanner scanner;

    private ConsoleInputView(Scanner scanner){
        this.scanner = scanner;
    }

    public static ConsoleInputView from(Scanner scanner) {
        return new ConsoleInputView(scanner);
    }

    @Override
    public String read() {
        return scanner.nextLine();
    }
    
}
