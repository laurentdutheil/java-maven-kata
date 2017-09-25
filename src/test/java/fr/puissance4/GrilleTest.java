package fr.puissance4;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class GrilleTest {

    private Grille grille = new Grille();

    @Test
    public void Grille_Should_Be_empty_when_Created() {
        // given

        // When
        grille.intitGrille();

        int i, j;
        for (i = 0; i < Grille.getNBLIGNE(); i++) {
            for (j = 0; j < Grille.getNBCOLONNE(); j++) {
                assertEquals(grille.getMatrice()[i][j], ".");

            }

            //assert

        }
    }

    @Test
    public void should_give_number_line_where_free()
    {
     // given
        assertEquals(grille.getNumberLineToInsert(3),4);

     // When

     //then

    }

    @Test
    public void should_be_able_To_add_jeton(int j, String jeton) throws MaxJetonsException {

        // When
        grille.insertjeton(2, "*");

        assertEquals(grille.getMatrice()[grille.getNumberLineToInsert(j)][j], jeton);

    }

}
