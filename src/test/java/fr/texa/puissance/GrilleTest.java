package fr.texa.puissance;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GrilleTest {

    @Test
    public void should_verify_that_grille_not_null() {
       Grille grille = new Grille();
       assertThat(grille.toString()).isEqualTo(
                                    ".......\n" +
                                    ".......\n" +
                                    ".......\n" +
                                    ".......\n" +
                                    ".......\n" +
                                    ".......\n");
    }

   @Test
   public void should_return_the_state_of_the_cell() {
        Grille grille = new Grille();
        grille.place(0, 'o');
        assertThat(grille.toString()).isEqualTo(".......\n.......\n" +
               ".......\n.......\n.......\no......\n");
   }

   @Test
   public void should_verify_place_token() {
        Grille grille = new Grille();
        grille.place(0, 'o');
        grille.place(0, '*');
        grille.place(0, 'o');
        grille.place(0, '*');
        grille.place(0, '*');
        grille.place(0, 'o');
       assertThat(grille.toString()).isEqualTo("o......\n*......\n" +
               "*......\no......\n*......\no......\n");
    }

    @Test
    public void should_verify_place_token_in_different_rows() {
        Grille grille = new Grille();
        grille.place(0, 'o');
        grille.place(2, '*');
        grille.place(2, 'o');
        grille.place(0, '*');
        grille.place(5, '*');
        grille.place(0, 'o');
        assertThat(grille.toString()).isEqualTo(".......\n.......\n" +
                ".......\no......\n*.o....\no.*..*.\n");
    }
}
