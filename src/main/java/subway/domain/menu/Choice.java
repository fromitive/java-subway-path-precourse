package subway.domain.menu;

public class Choice {
    private String symbol;
    private String name;
    private Action action;

    public Choice(String symbol, String name, Action action) {
        this.symbol = symbol;
        this.name = name;
        this.action = action;
    }

    public static Choice from(String symbol, String name, Action action) {
        return new Choice(symbol, name, action);
    }

    public void execute() {
        action.execute();
    }

    public String getName() {
        return String.format("%s. %s", symbol, name);
    }

    public boolean isSelected(String symbol) {
        return this.symbol.equals(symbol);
    }
}
