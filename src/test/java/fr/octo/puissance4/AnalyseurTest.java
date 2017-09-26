package fr.octo.puissance4;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class AnalyseurTest {
    private Grille grille;
    private Analyseur analyseur;

    @Before
    public void setUp() throws Exception {
        grille = new Grille();
        analyseur = new Analyseur(grille);
    }

    @Test
    public void VerifieSiGagnantEnLigneHorizontale() {

        grille.jouer(0, Grille.JOUEUR_1);
        grille.jouer(1, Grille.JOUEUR_1);
        grille.jouer(2, Grille.JOUEUR_1);
        grille.jouer(3, Grille.JOUEUR_1);

        assertTrue(analyseur.partieGagnee());
    }

    @Test
    public void VerifieSiGagnantEnColonne() {

        grille.jouer(2, Grille.JOUEUR_1);
        grille.jouer(2, Grille.JOUEUR_1);
        grille.jouer(2, Grille.JOUEUR_1);
        grille.jouer(2, Grille.JOUEUR_1);

        assertTrue(analyseur.partieGagnee());
    }

    @Test
    public void VerifieSiGagnantEnDiagonaleDescendante() {

        // 1
        // 2 1
        // 2 2 1
        // 2 1 2 1
        grille.jouer(1, Grille.JOUEUR_2);
        grille.jouer(1, Grille.JOUEUR_2);
        grille.jouer(1, Grille.JOUEUR_2);
        grille.jouer(1, Grille.JOUEUR_1);

        grille.jouer(2, Grille.JOUEUR_1);
        grille.jouer(2, Grille.JOUEUR_2);
        grille.jouer(2, Grille.JOUEUR_1);

        grille.jouer(3, Grille.JOUEUR_2);
        grille.jouer(3, Grille.JOUEUR_1);

        grille.jouer(4, Grille.JOUEUR_1);

        assertTrue(analyseur.partieGagnee());
    }

    @Test
    public void VerifieSiGagnantEnDiagonaleAscendante() {
        //       2
        //     2 1
        //   2 1 2
        // 2 1 2 1
        grille.jouer(0, Grille.JOUEUR_2);

        grille.jouer(1, Grille.JOUEUR_1);
        grille.jouer(1, Grille.JOUEUR_2);

        grille.jouer(2, Grille.JOUEUR_2);
        grille.jouer(2, Grille.JOUEUR_1);
        grille.jouer(2, Grille.JOUEUR_2);

        grille.jouer(3, Grille.JOUEUR_1);
        grille.jouer(3, Grille.JOUEUR_2);
        grille.jouer(3, Grille.JOUEUR_1);
        grille.jouer(3, Grille.JOUEUR_2);

        assertTrue(analyseur.partieGagnee());
    }

    @Test
    public void VerifieSiPartieNulle() {

        // 1 2 1 1 2 1 1
        // 2 1 1 2 1 1 2
        // 1 2 2 2 1 2 1
        // 1 1 1 2 2 2 1
        // 2 1 2 1 1 1 2
        // 1 2 1 1 2 2 1
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
        grille.jouer(6, Grille.JOUEUR_1);

        assertTrue(analyseur.partieNulle());

    }


}

