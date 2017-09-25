package fr.puissance4;

import org.assertj.core.api.Assertions;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class GrilleTest {

    private Grille grille = new Grille();

    @Test
    public void Grille_Should_Be_empty_when_Created() {
        // given

        // When
        grille.initGrille();


        //assert
        int i, j;
        for (i = 0; i < Grille.getNBLIGNE(); i++) {
            for (j = 0; j < Grille.getNBCOLONNE(); j++) {
                assertEquals(grille.getMatrice()[i][j], ".");

            }

        }
    }

    @Test
    public void should_insert_jeton_by_line_and_column() {
        // given
        grille.initGrille();

        // When
        grille.insertJetonByLineAndColumn(0,1,"o");


        //then
        assertEquals(grille.getMatrice()[0][1],"o");


    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void should_give_colum_where_insert()
    {
     // given
        grille.initGrille();

     // When
        grille.insertJetonByLineAndColumn(0,0,"o");
        grille.insertJetonByLineAndColumn(1,0,"o");



        //then
        assertEquals(grille.getNumberLineToInsert(0),2);

    }

    @Test
    public void should_not_insert_when_not_free() throws MaxJetonsException {
        thrown.expect(MaxJetonsException.class);

     // given
        grille.initGrille();
        grille.insertJeton(0,"o");
        grille.insertJeton(0,"o");
        grille.insertJeton(0,"o");
        grille.insertJeton(0,"o");
        grille.insertJeton(0,"o");
        grille.insertJeton(0,"o");

     // When
        grille.insertJeton(1,"o");

     //then

    }

    @Test
    public void should_be_able_to_be_empted() throws MaxJetonsException {
     // given
        grille.initGrille();
        grille.insertJeton(0,"o");
        grille.insertJeton(0,"o");
        grille.insertJeton(0,"o");
        grille.insertJeton(0,"o");
        grille.insertJeton(0,"o");
        grille.insertJeton(0,"o");

     // When
        grille.initGrille();

     //then
        int i, j;
        for (i = 0; i < Grille.getNBLIGNE(); i++) {
            for (j = 0; j < Grille.getNBCOLONNE(); j++) {
                assertEquals(grille.getMatrice()[i][j], ".");

            }

        }

    }

    @Test
    public void should_be_displayed() throws MaxJetonsException {
     // given
        grille.initGrille();

     // When
        grille.insertJeton(0,"o");
        grille.insertJeton(0,"*");
        grille.insertJeton(0,"*");
        grille.insertJeton(0,"o");
        grille.insertJeton(0,"o");
        grille.insertJeton(0,"*");

     //then
        String expectedResult =
                "o......\n" +
                        "*......\n" +
                        "*......\n" +
                        "o......\n" +
                        "o......\n" +
                        "*......\n";

        assertEquals(expectedResult, grille.toString());

    }


}
