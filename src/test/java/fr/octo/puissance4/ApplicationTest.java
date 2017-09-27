package fr.octo.puissance4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ApplicationTest {
    @Mock
    private Vue vue;

    @Mock
    private Arbitre arbitre;

    @Mock
    private Grille grille;

    private Application application;

    @Before
    public void setUp() throws Exception {
        application = new Application(vue, arbitre, grille);

        given(grille.toString()).willReturn(
                ".......\n" +
                        ".......\n" +
                        ".......\n" +
                        ".......\n" +
                        "..***..\n" +
                        "..OOOO.\n");
        given(arbitre.obtenirJoueurEnCours()).willReturn("JAUNE");
    }

    @Test
    public void gagnerPartieDevraitAfficherJoueurEtGrilleGagnants() {

        // given
        given(vue.lire())
                .willReturn("3");
        given(arbitre.obtenirEtatPartie())
                .willReturn(EtatPartie.GAGNEE);

        // when
        application.fairePartie();

        // then
        String output =
                ".......\n" +
                        ".......\n" +
                        ".......\n" +
                        ".......\n" +
                        "..***..\n" +
                        "..OOOO.\n" +
                        Arbitre.JOUEUR_JAUNE + " a gagne";

        verify(vue).imprimer(output);
    }

    @Test
    public void partieNulleDevraitAfficherGrilleCompleteEtPartieNulle() {
        // given
        given(arbitre.obtenirEtatPartie())
                .willReturn(EtatPartie.NULLE);

        // when
        application.fairePartie();

        // then
        String output =
                ".......\n" +
                        ".......\n" +
                        ".......\n" +
                        ".......\n" +
                        ".......\n" +
                        ".......\n" +
                        "partie nulle";

        verify(vue).imprimer(output);
    }
}
