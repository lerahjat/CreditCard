package pl.mglabinski.creditcard;

import org.junit.jupiter.api.Test;

import java.time.Instant;

import static org.assertj.core.api.Assertions.*;

public class AssertJTest {

    @Test
    void testSomeAssertJ() {
        var message = "Hello world";
        assertThat(message).contains("Hello");

        assertThat(Instant.now()).isAfter("2015");
    }

}
