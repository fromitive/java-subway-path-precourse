package subway.service;

import subway.domain.StationEdge;
import subway.view.InputView;
import subway.view.OutputView;

public class TimeFirstService extends PathService {
    private TimeFirstService(OutputView output, InputView input) {
        super(output, input);
    }

    public static TimeFirstService from(OutputView output, InputView input) {
        return new TimeFirstService(output, input);
    }

    @Override
    protected double setWeight(StationEdge edge) {
        return edge.getInfo().getTime();
    }
}
