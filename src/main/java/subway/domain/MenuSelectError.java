package subway.domain;

public class MenuSelectError extends CommonArgumentError {
    private static final String MENU_NOT_FOUND = "존재하지 않는 선택지 입니다. [%s]";
    public MenuSelectError(String symbol) {
        super(String.format(MENU_NOT_FOUND,symbol));
    }
}
