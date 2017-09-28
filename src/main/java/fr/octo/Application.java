package fr.octo;

import fr.octo.puissance4.Arbitre;
import fr.octo.puissance4.Grille;
import fr.octo.puissance4.Vue;

import java.util.Scanner;

public class Application {

    private Arbitre arbitre;
    private Vue vue;

    public Application(Arbitre arbitre, Vue vue) {
        this.arbitre = arbitre;
        this.vue = vue;
    }


    public void commencerPartie() {
        String etatGrille = arbitre.getAnalyseur().getGrille().toString() +
                arbitre.getTour().toString() + " colonne [1,7] : ";

        vue.afficherMessage(etatGrille);

        //while (arbitre.getEtat().equals(Arbitre.Etat.EnCours)) {
            int indice = Integer.valueOf(vue.lireMessage()) - 1;
            arbitre.jouer(indice);

            etatGrille = arbitre.getAnalyseur().getGrille().toString() +
                    arbitre.getTour().toString() + " colonne [1,7] : ";

            vue.afficherMessage(etatGrille);
       // }
    }


    public String lectureSaisie() {
        return vue.lireMessage();
    }
}
