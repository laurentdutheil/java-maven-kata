package fr.puissance4;

import org.junit.jupiter.api.Assertions;

public class Analyseur {

    private Grille grille;

    public Analyseur(Grille grille) {
        this.grille = grille;
        etat = Etat.NULL;
    }



    enum Etat {WIN, NULL};


    public Etat getEtat() {
        return etat;
    }

    private Etat etat;

    public void wine_when_four_jetons_in_line() {
        String carac;
        int compteur = 1;
        for (int i = 0; i < Grille.getNBLIGNE(); i++) {
            for (int j = 0; j < Grille.getNBCOLONNE() - 1 && compteur < 4; j++) {
                carac = grille.getMatrice()[i][j].toString();
                if (carac.equals(Grille.getJeton1()) || carac.equals(Grille.getJeton2())) {
                    if (grille.getMatrice()[i][j + 1].toString().equals(carac)) compteur++;
                    else compteur = 1;
                }
                else compteur=1;
            }
        }
        if (compteur == 4) etat = Etat.WIN;


    }

    public void wine_when_four_jetons_in_column() {

        String carac;
        int compteur = 1;
        for (int i = 0; i < Grille.getNBCOLONNE()-1; i++) {
            for (int j = 0; j < Grille.getNBLIGNE() && compteur < 4; j++) {
                carac = grille.getMatrice()[j][i].toString();
                if (carac.equals(Grille.getJeton1()) || carac.equals(Grille.getJeton2())) {
                    if (grille.getMatrice()[j + 1][i].toString().equals(carac)) compteur++;
                    else compteur = 1;
                } else compteur = 1;
            }
        }
        if (compteur == 4) etat = Etat.WIN;

    }
    public void wine_when_four_jetons_in_diag_up() {
        String carac;
        int compteur = 1;

    }
}
