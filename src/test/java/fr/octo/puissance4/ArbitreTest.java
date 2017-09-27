package fr.octo.puissance4;


import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ArbitreTest {
    private Arbitre dédé;

    @Before
    public void setUp() throws Exception {
        Grille grille = new Grille();
        dédé = new Arbitre(grille, new Analyseur(grille));
    }

    @Test
    public void joueurEnCoursAuPremierTourEstJaune() {
        String joueurEnCours;
        joueurEnCours = dédé.obtenirJoueurEnCours();

        assertEquals(joueurEnCours, Arbitre.JOUEUR_JAUNE);
    }

    @Test
    public void joueurEnCoursAuSecondTourEstRouge() {
        dédé.jouer(0);

        String joueurEnCours;
        joueurEnCours = dédé.obtenirJoueurEnCours();

        assertEquals(joueurEnCours, Arbitre.JOUEUR_ROUGE);
    }

    @Test
    public void jouerSurColonnePleineRetourneErreur() {
        dédé.jouer(1);
        dédé.jouer(1);
        dédé.jouer(1);
        dédé.jouer(1);
        dédé.jouer(1);
        dédé.jouer(1);

        String joueurEnCours = dédé.obtenirJoueurEnCours();
        assertEquals(joueurEnCours, Arbitre.JOUEUR_JAUNE);

        dédé.jouer(1);

        joueurEnCours = dédé.obtenirJoueurEnCours();
        assertEquals(joueurEnCours, Arbitre.JOUEUR_JAUNE);
    }

    @Test
    public void statutPartieEnCours() {
        assertEquals(EtatPartie.EN_COURS, dédé.obtenirEtatPartie());
    }

    @Test
    public void statutPartieGagnee() {
        /*
         .......
         .......
         .......
         .......
         .***...
         .oooo..
         */
        dédé.jouer(1);
        dédé.jouer(1);
        dédé.jouer(2);
        dédé.jouer(2);
        dédé.jouer(3);
        dédé.jouer(3);
        dédé.jouer(4);
        assertEquals(EtatPartie.GAGNEE, dédé.obtenirEtatPartie());
    }

    @Test
    public void statutPartieNulle() {
        /*
        **o*oo*
        oo**o*o
        *o*o***
        oo*o*oo
        **o*o**
        o*oo*oo
         */
        dédé.jouer(0);
        dédé.jouer(0);
        dédé.jouer(0);
        dédé.jouer(0);
        dédé.jouer(0);
        dédé.jouer(0);

        dédé.jouer(6);
        dédé.jouer(6);
        dédé.jouer(6);
        dédé.jouer(6);
        dédé.jouer(6);
        dédé.jouer(6);

        dédé.jouer(2);
        dédé.jouer(1);
        dédé.jouer(2);
        dédé.jouer(1);
        dédé.jouer(1);
        dédé.jouer(2);
        dédé.jouer(1);
        dédé.jouer(2);
        dédé.jouer(1);
        dédé.jouer(2);
        dédé.jouer(2);
        dédé.jouer(1);

        dédé.jouer(3);
        dédé.jouer(3);
        dédé.jouer(3);
        dédé.jouer(4);
        dédé.jouer(3);
        dédé.jouer(3);
        dédé.jouer(4);
        dédé.jouer(4);

        dédé.jouer(5);
        dédé.jouer(5);
        dédé.jouer(5);
        dédé.jouer(4);
        dédé.jouer(4);
        dédé.jouer(5);
        dédé.jouer(4);
        dédé.jouer(5);
        dédé.jouer(5);
        dédé.jouer(3);

        assertEquals(EtatPartie.NULLE, dédé.obtenirEtatPartie());
    }

    @Test
    public void partieGagneeParJaune() {
        /*
         .......
         .......
         .......
         .......
         .***...
         .oooo..
         */
        dédé.jouer(1);
        dédé.jouer(1);
        dédé.jouer(2);
        dédé.jouer(2);
        dédé.jouer(3);
        dédé.jouer(3);
        dédé.jouer(4);

        Optional<String> vainqueurOpt = dédé.obtenirVainqueur();
        assertTrue(vainqueurOpt.isPresent());
        assertEquals(Arbitre.JOUEUR_JAUNE, vainqueurOpt.get());
    }

    @Test
    public void partieGagneeParRouge() {
        /*
         .......
         .......
         .......
         .......
         .***...
         .oooo..
         */
        dédé.jouer(6);
        dédé.jouer(1);
        dédé.jouer(1);
        dédé.jouer(2);
        dédé.jouer(2);
        dédé.jouer(3);
        dédé.jouer(3);
        dédé.jouer(4);

        Optional<String> vainqueurOpt = dédé.obtenirVainqueur();
        assertTrue(vainqueurOpt.isPresent());
        assertEquals(Arbitre.JOUEUR_ROUGE, vainqueurOpt.get());
    }
}
