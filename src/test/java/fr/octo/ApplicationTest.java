package fr.octo;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ApplicationTest {

    private Application application = new Application();

    @Test
    public void sayCiao() {
        // Given
        String expected = "Ciao";

        // When
        String result;
        result = application.sayCiao();

        // Then
        assertThat(result).isEqualTo(expected);
    }

}