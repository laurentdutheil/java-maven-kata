package fr.octo.puissance4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ApplicationTest {


    private Application application;

    @Mock
    private Vue vue;

    @Mock
    private Arbitre arbitre;

    @Before
    public void setUp() throws Exception {
        application = new Application(vue, arbitre);
    }



    @Test
    public void DoitAfficherGrilleAuDebut()
    {
        given(arbitre.getGrille()).willReturn(new Grille());
        String resultatAttendu =
                ".......\n" +
                ".......\n" +
                ".......\n" +
                ".......\n" +
                ".......\n" +
                ".......\n";
        given(arbitre.getEtatPartie()).willReturn(Arbitre.PARTIEGAGNEE);


        application.start();

        verify(vue).print(resultatAttendu);



    }

    @Test
    public void DoitAfficherAQuiLeTour()
    {
        given(arbitre.getGrille()).willReturn(new Grille());
        given(arbitre.aQuiLeTour()).willReturn(Arbitre.JOUEUR_JAUNE);
        given(arbitre.getEtatPartie()).willReturn(Arbitre.PARTIEGAGNEE);

        application.start();
        verify(vue).print(Arbitre.JOUEUR_JAUNE);

    }

    @Test
    public void DoitAfficherLaGrilleAvecBonCoup()
    {
        given(arbitre.getGrille()).willReturn(new Grille());
        given(arbitre.aQuiLeTour()).willReturn(Arbitre.JOUEUR_JAUNE);
        given(arbitre.getEtatPartie()).willReturn(Arbitre.PARTIEENCOURS)
        .willReturn(Arbitre.PARTIEGAGNEE);
        given(vue.read()).willReturn("1");
        application.start();
        String resultatAttendu =
                ".......\n" +
                ".......\n" +
                ".......\n" +
                ".......\n" +
                ".......\n" +
                "."+Arbitre.JOUEUR_JAUNE+".....\n";




       verify(vue).print(resultatAttendu);
    }

    @Test
    public void DoitAfficherGagnant()
    {
     // given

        given(vue.read()).willReturn("1")
        .willReturn("2")
        .willReturn("1")
        .willReturn("2")
        .willReturn("1")
        .willReturn("2")
        .willReturn("1");

        application.start();

        verify(vue).print(Arbitre.PARTIEGAGNEE);

    }
    @Test
    public void DoitAfficherNull()
    {

    }
}
