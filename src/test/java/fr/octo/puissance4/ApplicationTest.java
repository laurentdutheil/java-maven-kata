package fr.octo.puissance4;

import fr.octo.Application;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ApplicationTest {

    private Grille grille;
    private Analyseur analyseur;
    private Application application;
    @Mock
    private  Vue vue;
    @Mock
    private Arbitre arbitre;




    @Before
    public void setUp() throws Exception {
        grille = new Grille();
        analyseur = new Analyseur(grille);
        application = new Application(arbitre, vue);
    }

    @Test
    public void etatTour() {
        //given

        //when
        given(vue.lireMessage()).willReturn("4");


        application.commencerPartie();

        //assertion
        String expectedDebutPartie =
                ".......\n" +
                        ".......\n" +
                        ".......\n" +
                        ".......\n" +
                        ".......\n" +
                        ".......\n" +
                        "jaune colonne [1,7] : ";
        verify(vue).afficherMessage(expectedDebutPartie);

        String expectedResult =
                        ".......\n" +
                        ".......\n" +
                        ".......\n" +
                        ".......\n" +
                        ".......\n" +
                        "...o...\n" +
                                "rouge colonne [1,7] : ";
        verify(vue).afficherMessage(expectedResult);
    }

    @Test
    public void afficheVainqueur()
    {


        //when
        given(arbitre.getVainqueur().toString()).willReturn("jaune");


        //assert
        String expectedResult = "jaune a gagné";

        verify(vue).afficherMessage(expectedResult);

    }



}