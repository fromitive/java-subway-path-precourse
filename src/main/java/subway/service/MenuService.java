package subway.service;

import subway.domain.Choice;
import subway.domain.Menu;
import subway.view.InputView;
import subway.view.OutputView;

public class MenuService {
    private Menu menu;
    private InputView input;
    private OutputView output;

    public MenuService(Menu menu, InputView input, OutputView output) {
        this.menu = menu;
        this.input = input;
        this.output = output;
    }

    public void addChoice(Choice choice) {
        this.menu.addChoice(choice);
    }

    public void start() {
        untilExecute();
    }

    private void untilExecute() {
        while (true) {
            try {
                output.printMenu(menu);
                output.selectFunction();
                String symbol = input.read();
                output.printLine();
                menu.select(symbol);
                break;
            } catch (IllegalArgumentException e) {
                output.printString(e.getMessage());
                output.printLine();
            }
        }
        
    }
}
