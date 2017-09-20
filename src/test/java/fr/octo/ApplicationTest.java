package fr.octo;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ApplicationTest {

    private Application application = new Application();

    @Test
    public void sayBonjour() {
        // Given
        String expected = "Bonjour";

        // When
        String result = application.sayBonjour();

        // Then
        assertThat(result).isEqualTo(expected);
    }

}