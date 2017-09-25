package fr.octo;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ArithmeticTest {

    @Test
    public void should_test() {
        assertThat(4).isEqualTo(2+2);
    }
}