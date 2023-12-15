package subway.domain;

import java.io.PrintStream;
import java.io.ByteArrayOutputStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;




public class MenuTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void 메뉴_등록(){
        String expectedOutPut = "Hello World!";
        Menu menu = Menu.from("제목");
        menu.addChoice(Choice.from("1","메뉴명",() -> System.out.println(expectedOutPut)));
        menu.select("1");
        assertThat(outputStreamCaptor.toString()).contains(expectedOutPut);
    }

    @Test
    void 메뉴_실패(){
        String expectedOutPut = "Hello World!";
        Menu menu = Menu.from("제목");
        menu.addChoice(Choice.from("1","메뉴명",() -> System.out.println(expectedOutPut)));
        assertThatThrownBy(()-> menu.select("some"));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }
}
