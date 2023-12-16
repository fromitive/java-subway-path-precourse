package subway.domain.error;

public class CommonArgumentError extends IllegalArgumentException {
    public CommonArgumentError(String message) {
        super(String.format("[ERROR] %s", message));
    }
}
