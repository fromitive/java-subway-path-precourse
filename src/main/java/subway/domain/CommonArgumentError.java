package subway.domain;

public class CommonArgumentError extends IllegalArgumentException {
    public CommonArgumentError(String message) {
        super(String.format("[ERROR] %s", message));
    }
}
