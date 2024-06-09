package pl.mglabinski.creditcard;

import org.junit.jupiter.api.Test;

public class HelloTest {

    @Test
    void helloMyFirstUnitTest() {
        //A /Arrange
        int a = 2;
        int b = 4;
        //A /Act
        var result = a + b;
        //A /Assert
        assert (result == 6);
    }

    @Test
    void helloWorldViaTest() {
        var name = "Milosz";
        var message = String.format("Hello %s", name);

        assert message.equals("Hello Milosz");
    }

    @Test
    void failMyTest() {
        var a = 2;
        var b = 8;

        var result = a + b;

        assert result == 10;
    }
}
