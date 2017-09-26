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

        grille.jouer(0, Arbitre.JOUEUR_JAUNE);
        grille.jouer(1, Arbitre.JOUEUR_JAUNE);
        grille.jouer(2, Arbitre.JOUEUR_JAUNE);
        grille.jouer(3, Arbitre.JOUEUR_JAUNE);

        assertTrue(analyseur.partieGagnee());
    }

    @Test
    public void VerifieSiGagnantEnColonne() {

        grille.jouer(2, Arbitre.JOUEUR_JAUNE);
        grille.jouer(2, Arbitre.JOUEUR_JAUNE);
        grille.jouer(2, Arbitre.JOUEUR_JAUNE);
        grille.jouer(2, Arbitre.JOUEUR_JAUNE);

        assertTrue(analyseur.partieGagnee());
    }

    @Test
    public void VerifieSiGagnantEnDiagonaleDescendante() {

        // 1
        // 2 1
        // 2 2 1
        // 2 1 2 1
        grille.jouer(1, Arbitre.JOUEUR_ROUGE);
        grille.jouer(1, Arbitre.JOUEUR_ROUGE);
        grille.jouer(1, Arbitre.JOUEUR_ROUGE);
        grille.jouer(1, Arbitre.JOUEUR_JAUNE);

        grille.jouer(2, Arbitre.JOUEUR_JAUNE);
        grille.jouer(2, Arbitre.JOUEUR_ROUGE);
        grille.jouer(2, Arbitre.JOUEUR_JAUNE);

        grille.jouer(3, Arbitre.JOUEUR_ROUGE);
        grille.jouer(3, Arbitre.JOUEUR_JAUNE);

        grille.jouer(4, Arbitre.JOUEUR_JAUNE);

        assertTrue(analyseur.partieGagnee());
    }

    @Test
    public void VerifieSiGagnantEnDiagonaleAscendante() {
        //       2
        //     2 1
        //   2 1 2
        // 2 1 2 1
        grille.jouer(0, Arbitre.JOUEUR_ROUGE);

        grille.jouer(1, Arbitre.JOUEUR_JAUNE);
        grille.jouer(1, Arbitre.JOUEUR_ROUGE);

        grille.jouer(2, Arbitre.JOUEUR_ROUGE);
        grille.jouer(2, Arbitre.JOUEUR_JAUNE);
        grille.jouer(2, Arbitre.JOUEUR_ROUGE);

        grille.jouer(3, Arbitre.JOUEUR_JAUNE);
        grille.jouer(3, Arbitre.JOUEUR_ROUGE);
        grille.jouer(3, Arbitre.JOUEUR_JAUNE);
        grille.jouer(3, Arbitre.JOUEUR_ROUGE);

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
        grille.jouer(0, Arbitre.JOUEUR_JAUNE);
        grille.jouer(0, Arbitre.JOUEUR_ROUGE);
        grille.jouer(0, Arbitre.JOUEUR_JAUNE);
        grille.jouer(0, Arbitre.JOUEUR_JAUNE);
        grille.jouer(0, Arbitre.JOUEUR_ROUGE);
        grille.jouer(0, Arbitre.JOUEUR_JAUNE);

        grille.jouer(1, Arbitre.JOUEUR_ROUGE);
        grille.jouer(1, Arbitre.JOUEUR_JAUNE);
        grille.jouer(1, Arbitre.JOUEUR_JAUNE);
        grille.jouer(1, Arbitre.JOUEUR_ROUGE);
        grille.jouer(1, Arbitre.JOUEUR_JAUNE);
        grille.jouer(1, Arbitre.JOUEUR_ROUGE);

        grille.jouer(2, Arbitre.JOUEUR_JAUNE);
        grille.jouer(2, Arbitre.JOUEUR_ROUGE);
        grille.jouer(2, Arbitre.JOUEUR_JAUNE);
        grille.jouer(2, Arbitre.JOUEUR_ROUGE);
        grille.jouer(2, Arbitre.JOUEUR_JAUNE);
        grille.jouer(2, Arbitre.JOUEUR_JAUNE);

        grille.jouer(3, Arbitre.JOUEUR_JAUNE);
        grille.jouer(3, Arbitre.JOUEUR_JAUNE);
        grille.jouer(3, Arbitre.JOUEUR_ROUGE);
        grille.jouer(3, Arbitre.JOUEUR_ROUGE);
        grille.jouer(3, Arbitre.JOUEUR_ROUGE);
        grille.jouer(3, Arbitre.JOUEUR_JAUNE);

        grille.jouer(4, Arbitre.JOUEUR_ROUGE);
        grille.jouer(4, Arbitre.JOUEUR_JAUNE);
        grille.jouer(4, Arbitre.JOUEUR_ROUGE);
        grille.jouer(4, Arbitre.JOUEUR_JAUNE);
        grille.jouer(4, Arbitre.JOUEUR_JAUNE);
        grille.jouer(4, Arbitre.JOUEUR_ROUGE);

        grille.jouer(5, Arbitre.JOUEUR_ROUGE);
        grille.jouer(5, Arbitre.JOUEUR_JAUNE);
        grille.jouer(5, Arbitre.JOUEUR_ROUGE);
        grille.jouer(5, Arbitre.JOUEUR_ROUGE);
        grille.jouer(5, Arbitre.JOUEUR_JAUNE);
        grille.jouer(5, Arbitre.JOUEUR_JAUNE);

        grille.jouer(6, Arbitre.JOUEUR_JAUNE);
        grille.jouer(6, Arbitre.JOUEUR_ROUGE);
        grille.jouer(6, Arbitre.JOUEUR_JAUNE);
        grille.jouer(6, Arbitre.JOUEUR_JAUNE);
        grille.jouer(6, Arbitre.JOUEUR_ROUGE);
        grille.jouer(6, Arbitre.JOUEUR_JAUNE);

        assertTrue(analyseur.partieNulle());

    }


}

