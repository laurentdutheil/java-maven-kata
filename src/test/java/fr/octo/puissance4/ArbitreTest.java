package fr.octo.puissance4;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ArbitreTest {
    private Arbitre arbitre;

    @Before
    public void setUp() throws Exception {
       arbitre  = new Arbitre();
    }




    @Test
    public void ArbitreDoitCommencerLaPartieParLeJaune() {
        assertEquals(Arbitre.JOUEUR_JAUNE, arbitre.aQuiLeTour());
    }


    @Test
    public void ArbitreDoitChangerDeJoueur() {
        arbitre.joue(3);
        assertEquals(Arbitre.JOUEUR_ROUGE, arbitre.aQuiLeTour());
    }

    @Test
    public void ArbitreEntreCoupJoueurCourant() {
        arbitre.joue(3);
        arbitre.joue(3);
        Grille grille = arbitre.getGrille();
        assertEquals(Arbitre.JOUEUR_JAUNE, grille.getCellValue(3,0));
        assertEquals(Arbitre.JOUEUR_ROUGE, grille.getCellValue(3, 1));
    }
     @Test
     public void ArbitreDoitDonnerEtatEnCours()
     {

         arbitre.joue(3);
         arbitre.joue(3);
         arbitre.joue(3);

         assertEquals(Arbitre.PARTIEENCOURS, arbitre.getEtatPartie());

     }


     @Test
     public void ArbitreDoitDonnerEtatGagner()
     {
         arbitre.joue(3);
         arbitre.joue(4);
         arbitre.joue(3);
         arbitre.joue(4);
         arbitre.joue(3);
         arbitre.joue(4);
         arbitre.joue(3);

         assertEquals(Arbitre.PARTIEGAGNEE, arbitre.getEtatPartie());

     }
     @Test
     public void ArbitreDoitDonnerEtatNull()
     {

         // 1 2 1 1 2 1 1
         // 2 1 1 2 1 1 2
         // 1 2 2 2 1 2 1
         // 1 1 1 2 2 2 1
         // 2 1 2 1 1 1 2
         // 1 2 1 1 2 2 1

         Grille g = arbitre.getGrille();


         g.jouer(0, Arbitre.JOUEUR_JAUNE);
         g.jouer(0, Arbitre.JOUEUR_ROUGE);
         g.jouer(0, Arbitre.JOUEUR_JAUNE);
         g.jouer(0, Arbitre.JOUEUR_JAUNE);
         g.jouer(0, Arbitre.JOUEUR_ROUGE);
         g.jouer(0, Arbitre.JOUEUR_JAUNE);

         g.jouer(1, Arbitre.JOUEUR_ROUGE);
         g.jouer(1, Arbitre.JOUEUR_JAUNE);
         g.jouer(1, Arbitre.JOUEUR_JAUNE);
         g.jouer(1, Arbitre.JOUEUR_ROUGE);
         g.jouer(1, Arbitre.JOUEUR_JAUNE);
         g.jouer(1, Arbitre.JOUEUR_ROUGE);

         g.jouer(2, Arbitre.JOUEUR_JAUNE);
         g.jouer(2, Arbitre.JOUEUR_ROUGE);
         g.jouer(2, Arbitre.JOUEUR_JAUNE);
         g.jouer(2, Arbitre.JOUEUR_ROUGE);
         g.jouer(2, Arbitre.JOUEUR_JAUNE);
         g.jouer(2, Arbitre.JOUEUR_JAUNE);

         g.jouer(3, Arbitre.JOUEUR_JAUNE);
         g.jouer(3, Arbitre.JOUEUR_JAUNE);
         g.jouer(3, Arbitre.JOUEUR_ROUGE);
         g.jouer(3, Arbitre.JOUEUR_ROUGE);
         g.jouer(3, Arbitre.JOUEUR_ROUGE);
         g.jouer(3, Arbitre.JOUEUR_JAUNE);

         g.jouer(4, Arbitre.JOUEUR_ROUGE);
         g.jouer(4, Arbitre.JOUEUR_JAUNE);
         g.jouer(4, Arbitre.JOUEUR_ROUGE);
         g.jouer(4, Arbitre.JOUEUR_JAUNE);
         g.jouer(4, Arbitre.JOUEUR_JAUNE);
         g.jouer(4, Arbitre.JOUEUR_ROUGE);

         g.jouer(5, Arbitre.JOUEUR_ROUGE);
         g.jouer(5, Arbitre.JOUEUR_JAUNE);
         g.jouer(5, Arbitre.JOUEUR_ROUGE);
         g.jouer(5, Arbitre.JOUEUR_ROUGE);
         g.jouer(5, Arbitre.JOUEUR_JAUNE);
         g.jouer(5, Arbitre.JOUEUR_JAUNE);

         g.jouer(6, Arbitre.JOUEUR_JAUNE);
         g.jouer(6, Arbitre.JOUEUR_ROUGE);
         g.jouer(6, Arbitre.JOUEUR_JAUNE);
         g.jouer(6, Arbitre.JOUEUR_JAUNE);
         g.jouer(6, Arbitre.JOUEUR_ROUGE);

         arbitre.joue(6);


         assertEquals(Arbitre.PARTIENULLE,arbitre.getEtatPartie());

      // When

      //then

     }


     @Test
     public void ArbitreDoitDonnerLeVainqueur()
     {
         arbitre.joue(3);
         arbitre.joue(4);
         arbitre.joue(3);
         arbitre.joue(4);
         arbitre.joue(3);
         arbitre.joue(4);
         arbitre.joue(3);

         assertEquals(Arbitre.JOUEUR_JAUNE, arbitre.getVainqueur());
     }
}

