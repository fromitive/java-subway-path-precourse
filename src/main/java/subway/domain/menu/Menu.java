package subway.domain.menu;

import java.util.List;
import java.util.ArrayList;

import java.util.stream.Collectors;

import subway.domain.error.MenuSelectError;

public class Menu {
    private String title;
    private List<Choice> choice = new ArrayList<>();

    private Menu(String title) {
        this.title = title;
    }

    public static Menu from(String title) {
        return new Menu(title);
    }

    public void addChoice(Choice choose) {
        choice.add(choose);

    }

    public void select(String symbol) {
        choice.stream().filter(choose -> choose.isSelected(symbol))
                .findFirst().orElseThrow(() -> new MenuSelectError(symbol)).execute();
    }

    public String titleName() {
        return title;
    }

    public List<String> getChoiceName() {
        return choice.stream().map(Choice::getName).collect(Collectors.toUnmodifiableList());
    }
}
