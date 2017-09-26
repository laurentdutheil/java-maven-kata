package fr.octo.puissance4;

import fr.octo.Application;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ApplicationTest {

    private Grille grille;
    private Analyseur analyseur;
    private Arbitre arbitre;
    private TestableApplication application;

    class TestableApplication extends Application {

        private String message;

        public TestableApplication(Arbitre arbitre) {
            super(arbitre);
        }

        @Override
        public void print(String message) {
            this.message = message;
            System.out.println(this.message);
        }

        public String getMessage() {
            return this.message;
        }
    }

    @Before
    public void setUp() throws Exception {
        grille = new Grille();
        analyseur = new Analyseur(grille);
        arbitre = new Arbitre(analyseur);
        application = new TestableApplication(arbitre);
    }

    @Test
    public void AffichageGrille() {
        arbitre.jouer(3);
        application.afficheGrille();
        assertThat(application.getMessage()).isEqualTo( ".......\n" +
                                                ".......\n" +
                                                ".......\n" +
                                                ".......\n" +
                                                ".......\n" +
                                                "...o...\n");
    }

    @Test
    public void AffichageTour(){
        arbitre.jouer(3);
        arbitre.jouer(3);
        application.afficheTour();
        assertThat(application.getMessage()).isEqualTo(Arbitre.Tour.jaune.toString());
    }

    @Test
    public void LireNumeroColonne() {

        application.getNumeroColonne();
    }
}
