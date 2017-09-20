package fr.octo;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ApplicationTest {

    private Application application = new Application();

    @Test
    public void sayYouHou() {
        // Given
        String expected = "youHou";

        // When
        String result = application.sayByebye();

        // Then
        assertThat(result).isEqualTo(expected);
    }


}