package fr.octo.puissance4;

public class Grille {
    public static final int COLONNE = 7;
    public static final int LIGNE = 6;

    public static final String JOUEUR_1 = "J";
    public static final String JOUEUR_2 = "R";

    private String[][] plateauDuJeu;

    public Grille() {
        plateauDuJeu = new String[COLONNE][LIGNE];
    }

    public boolean isCellEmpty(int c, int l) {
        return plateauDuJeu[c][l] == null;
    }

    public boolean jouer(int c, String joueur) {
        boolean success = false;
        for (int l = 0; l < LIGNE; l++) {
            if (isCellEmpty(c, l)) {
                plateauDuJeu[c][l] = joueur;
                success = true;
                break;

            }
        }
        return success;
    }

    public String getCellValue(int c, int l) {
        try {
            return plateauDuJeu[c][l];
        } catch (ArrayIndexOutOfBoundsException e) {
            return null;
        }

    }

    private String getCellValueAsString(int c, int l) {
        return (plateauDuJeu[c][l] == null ? "." : plateauDuJeu[c][l]);
    }

    public void vider() {
        plateauDuJeu = new String[COLONNE][LIGNE];
    }


    @Override
    public String toString() {

        String result = "";
        for (int l = LIGNE - 1; l >= 0; l--) {
            for (int c = 0; c < COLONNE; c++) {
                result += getCellValueAsString(c, l);
            }
            result += "\n";
        }

        return result;
    }

    public String[][] getPlateauDuJeu() {
        return plateauDuJeu;
    }

    public boolean plateauDuJeuEstRempli() {
        boolean rempli = true;
        for (int c = 0; c < COLONNE && rempli; c++) {
            for (int l = 0; l < LIGNE && rempli; l++) {
                if (plateauDuJeu[c][l] == null) {
                    rempli = false;
                }
            }
        }

        return rempli;
    }
}
