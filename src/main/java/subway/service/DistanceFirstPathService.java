package subway.service;

import subway.domain.StationEdge;
import subway.view.InputView;
import subway.view.OutputView;

public class DistanceFirstPathService extends PathService {

    private DistanceFirstPathService(OutputView output, InputView input) {
        super(output, input);
    }

    public static DistanceFirstPathService from(OutputView output, InputView input) {
        return new DistanceFirstPathService(output, input);
    }

    @Override
    protected double setWeight(StationEdge edge) {
        return edge.getInfo().getKM();
    }

}
