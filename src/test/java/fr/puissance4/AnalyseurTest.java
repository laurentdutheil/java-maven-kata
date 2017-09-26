package fr.puissance4;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnalyseurTest {

    Grille grille = new Grille();


    @Test
    public void should_win_when_four_jeton_in_one_line() throws MaxJetonsException {
        // given
        grille.initGrille();
        Analyseur analyseur = new Analyseur(grille);

        // When
        grille.insertJeton(1, Grille.getJeton1());
        grille.insertJeton(2, Grille.getJeton1());
        grille.insertJeton(3, Grille.getJeton1());
        grille.insertJeton(5, Grille.getJeton1());
        grille.insertJeton(6, Grille.getJeton2());

        grille.insertJeton(3, Grille.getJeton1());
        grille.insertJeton(4, Grille.getJeton1());
        grille.insertJeton(5, Grille.getJeton1());
        grille.insertJeton(6, Grille.getJeton1());

        grille.toString();


        analyseur.wine_when_four_jetons_in_line();
        //then
        assertEquals(analyseur.getEtat(), Analyseur.Etat.WIN);

    }

    @Test
    public void should_win_when_four_jeton_in_one_column() throws MaxJetonsException {
        // given
        grille.initGrille();
        Analyseur analyseur = new Analyseur(grille);


        // When
        grille.insertJeton(1, Grille.getJeton1());
        grille.insertJeton(1, Grille.getJeton1());
        grille.insertJeton(1, Grille.getJeton1());
        grille.insertJeton(1, Grille.getJeton2());


        grille.insertJeton(4, Grille.getJeton1());
        grille.insertJeton(4, Grille.getJeton2());
        grille.insertJeton(4, Grille.getJeton1());
        grille.insertJeton(4, Grille.getJeton1());
        grille.insertJeton(4, Grille.getJeton1());
        grille.insertJeton(4, Grille.getJeton1());

        grille.toString();
        analyseur.wine_when_four_jetons_in_column();


        //then
        assertEquals(analyseur.getEtat(), Analyseur.Etat.WIN);


    }
    @Test
    public void should_win_with_four_jeton_diag_up()
    {
     // given
        grille.initGrille();
        Analyseur analyseur = new Analyseur(grille);

     // When
        grille.insertJetonByLineAndColumn(1,3,Grille.getJeton1());
        grille.insertJetonByLineAndColumn(2,2,Grille.getJeton1());
        grille.insertJetonByLineAndColumn(3,1,Grille.getJeton1());
        grille.insertJetonByLineAndColumn(4,0,Grille.getJeton1());
        grille.toString();
        analyseur.wine_when_four_jetons_in_diag_up();
     //then
        assertEquals(analyseur.getEtat(), Analyseur.Etat.WIN);

    }
}
