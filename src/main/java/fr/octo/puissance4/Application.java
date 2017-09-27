package fr.octo.puissance4;

import java.util.Optional;

public class Application {
    private Vue vue;
    private Arbitre arbitre;
    private Grille grille;

    public Application(Vue vue, Arbitre arbitre, Grille grille) {
        this.vue = vue;
        this.arbitre = arbitre;
        this.grille = grille;
    }

    public void fairePartie() {
        String grilleAImprimer;

        do {
            grilleAImprimer =
                    grille.toString() +
                    arbitre.obtenirJoueurEnCours() +
                    " colonne [1-7]:";
            vue.imprimer(grilleAImprimer);
            faireJouerUnJoueur();
        } while (arbitre.obtenirEtatPartie().equals(EtatPartie.EN_COURS));

        if (arbitre.obtenirEtatPartie().equals(EtatPartie.GAGNEE)) {
            String grilleAImprimerGagant =
                    grille.toString() +
                    arbitre.obtenirVainqueur().get() +
                    " a gagne";
            vue.imprimer(grilleAImprimerGagant);
        }
    }

    private void faireJouerUnJoueur() {
        int colonneAJouer = Integer.parseInt(vue.lire()) - 1;
        arbitre.jouer(colonneAJouer);
    }
}
