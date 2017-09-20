package fr.octo;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ApplicationTest {

    private Application application = new Application();

    @Test
    public void sayMoikka() {
        // Given
        String expected = "Moikka";

        // When
        String result = application.sayMoikka();

        // Then
        assertThat(result).isEqualTo(expected);
    }

}