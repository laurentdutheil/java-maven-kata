package fr.octo.puissance4;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ApplicationTest {

    private TestableApplication application;

    @Before
    public void setUp() throws Exception {
        application = new TestableApplication();
    }



    private class TestableApplication extends Application {
        private List<String> messages = new ArrayList<String>();

        public TestableApplication() {
            super();
        }

        @Override
        public void print(String message) {
            messages.add(message);
        }

        public List<String> getMessagesList() {
            return messages;
        }

        public String getDernierMessage() {
            return messages.get(messages.size() - 1);
        }
    }

    @Test
    public void DoitAfficherGrilleAuDebut()
    {
        String resultatAttendu =
                ".......\n" +
                ".......\n" +
                ".......\n" +
                ".......\n" +
                ".......\n" +
                ".......\n";
        application.start();

        assertEquals( application.getDernierMessage(), resultatAttendu);

    }

    @Test
    public void DoitAfficherAQuiLeTour()
    {
        application.start();
        assertEquals(Arbitre.JOUEUR_JAUNE, application.getDernierMessage());

    }
}
