package fr.octo.puissance4;

public class Analyseur {

    private Grille grille;

    public Analyseur(Grille g) {
        grille = g;
    }

    public boolean partieGagnee() {

        boolean gagnant = false;
        for (int indexLigne = 0; indexLigne < Grille.LIGNE && !gagnant; indexLigne++) {

            for (int indexColonne = 0; indexColonne < Grille.COLONNE && !gagnant; indexColonne++) {
                gagnant = verifie4ALaSuiteLigne(indexLigne, indexColonne)
                        || verifie4ALaSuiteColonne(indexLigne, indexColonne)
                        || verifie4ALaSuiteDiagonaleAscendante(indexLigne, indexColonne)
                        || verifie4ALaSuiteDiagonaleDescendante(indexLigne, indexColonne);
            }

        }

        return gagnant;
    }

    private boolean verifie4ALaSuiteDiagonaleDescendante(int indexLigne, int indexColonne) {
        return verifie4ALaSuite(indexColonne, indexLigne, 1, -1, 1);
    }

    private boolean verifie4ALaSuiteDiagonaleAscendante(int indexLigne, int indexColonne) {
        return verifie4ALaSuite(indexColonne, indexLigne, 1, 1, 1);
    }

    private boolean verifie4ALaSuiteColonne(int indexLigne, int indexColonne) {
        return verifie4ALaSuite(indexColonne, indexLigne, 0, 1, 1);
    }

    private boolean verifie4ALaSuiteLigne(int indexLigne, int indexColonne) {
        return verifie4ALaSuite(indexColonne, indexLigne, 1, 0, 1);
    }


    private boolean verifie4ALaSuite(int indexColonne, int indexLigne, int decalageColonne, int decalageLigne, int nombreJetonsAlignes) {
        int indexColonneVoisine = indexColonne + decalageColonne;
        int indexLigneVoisine = indexLigne + decalageLigne;

        String caseCourante = grille.getCellValue(indexColonne, indexLigne);
        String caseVoisine = grille.getCellValue(indexColonneVoisine, indexLigneVoisine);

        if (caseCourante != null && caseCourante.equals(caseVoisine)) {
            nombreJetonsAlignes++;
            if (nombreJetonsAlignes != 4) {
                return verifie4ALaSuite(indexColonneVoisine, indexLigneVoisine, decalageColonne, decalageLigne, nombreJetonsAlignes);
            }
            return true;
        }

        return false;
    }


    public boolean partieNulle() {
        return grille.plateauDuJeuEstRempli() && !partieGagnee();
    }

    public Grille getGrille() {return this.grille;}
}
