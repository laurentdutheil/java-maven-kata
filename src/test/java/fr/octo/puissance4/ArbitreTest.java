package fr.octo.puissance4;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ArbitreTest {

    private Grille grille;
    private Analyseur analyseur;
    private Arbitre arbitre;

    @Before
    public void setUp() throws Exception {
        grille = new Grille();
        analyseur = new Analyseur(grille);
        arbitre = new Arbitre(analyseur);
    }

    @Test
    public void AQuiDeJouerEnPremier() {

        assertThat(arbitre.getTour()).isEqualTo(Arbitre.Tour.jaune);
    }

    @Test
    public void InsererBonJetonSelonTour() {

        arbitre.jouer(3);
        arbitre.jouer(3);
        String expectedResult =
                        ".......\n" +
                        ".......\n" +
                        ".......\n" +
                        ".......\n" +
                        "...*...\n" +
                        "...o...\n";
        assertEquals(expectedResult, grille.toString());
    }

    @Test
    public void TestSiLaPartieEstGagnee()
    {
        arbitre.jouer(0);
        arbitre.jouer(1);
        arbitre.jouer(0);
        arbitre.jouer(1);
        arbitre.jouer(0);
        arbitre.jouer(1);
        arbitre.jouer(0);

        assertThat(arbitre.getEtat()).isEqualTo(Arbitre.Etat.Gagnee);
    }

    @Test
    public void TestSiLaPArtieEstNulle()
    {
        grille.jouer(0, Grille.JOUEUR_1);
        grille.jouer(0, Grille.JOUEUR_2);
        grille.jouer(0, Grille.JOUEUR_1);
        grille.jouer(0, Grille.JOUEUR_1);
        grille.jouer(0, Grille.JOUEUR_2);
        grille.jouer(0, Grille.JOUEUR_1);

        grille.jouer(1, Grille.JOUEUR_2);
        grille.jouer(1, Grille.JOUEUR_1);
        grille.jouer(1, Grille.JOUEUR_1);
        grille.jouer(1, Grille.JOUEUR_2);
        grille.jouer(1, Grille.JOUEUR_1);
        grille.jouer(1, Grille.JOUEUR_2);

        grille.jouer(2, Grille.JOUEUR_1);
        grille.jouer(2, Grille.JOUEUR_2);
        grille.jouer(2, Grille.JOUEUR_1);
        grille.jouer(2, Grille.JOUEUR_2);
        grille.jouer(2, Grille.JOUEUR_1);
        grille.jouer(2, Grille.JOUEUR_1);

        grille.jouer(3, Grille.JOUEUR_1);
        grille.jouer(3, Grille.JOUEUR_1);
        grille.jouer(3, Grille.JOUEUR_2);
        grille.jouer(3, Grille.JOUEUR_2);
        grille.jouer(3, Grille.JOUEUR_2);
        grille.jouer(3, Grille.JOUEUR_1);

        grille.jouer(4, Grille.JOUEUR_2);
        grille.jouer(4, Grille.JOUEUR_1);
        grille.jouer(4, Grille.JOUEUR_2);
        grille.jouer(4, Grille.JOUEUR_1);
        grille.jouer(4, Grille.JOUEUR_1);
        grille.jouer(4, Grille.JOUEUR_2);

        grille.jouer(5, Grille.JOUEUR_2);
        grille.jouer(5, Grille.JOUEUR_1);
        grille.jouer(5, Grille.JOUEUR_2);
        grille.jouer(5, Grille.JOUEUR_2);
        grille.jouer(5, Grille.JOUEUR_1);
        grille.jouer(5, Grille.JOUEUR_1);

        grille.jouer(6, Grille.JOUEUR_1);
        grille.jouer(6, Grille.JOUEUR_2);
        grille.jouer(6, Grille.JOUEUR_1);
        grille.jouer(6, Grille.JOUEUR_1);
        grille.jouer(6, Grille.JOUEUR_2);
        arbitre.jouer(6);

        assertThat(arbitre.getEtat()).isEqualTo(Arbitre.Etat.Nulle);
    }

    @Test
    public void TestSiLaPartieEstEnCours() {

        arbitre.jouer(1);

        assertThat(arbitre.getEtat()).isEqualTo(Arbitre.Etat.EnCours);
    }

    @Test
    public void DitQuelEstLeVainqueur(){
        arbitre.jouer(0);
        arbitre.jouer(1);
        arbitre.jouer(0);
        arbitre.jouer(1);
        arbitre.jouer(0);
        arbitre.jouer(1);
        arbitre.jouer(0);

        assertThat(arbitre.getVainqueur()).isEqualTo(Arbitre.Tour.jaune);

    }
}
