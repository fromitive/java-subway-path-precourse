package subway.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class LineTest {
    @Test
    void 호선_등록_테스트() {
        // given
        Station station1 = new Station("교대역");
        Station station2 = new Station("강남역");
        Station station3 = new Station("역삼역");

        Line line2 = new Line("2호선");

        line2.addConnection(station1, station2, ConnectionInfo.from(2, 3));
        line2.addConnection(station2, station3, ConnectionInfo.from(2, 3));
        int time = station2.getConnectionInfo(station3).getTime();

        assertThat(time).isEqualTo(3);

    }
}
