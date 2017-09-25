package fr.puissance4;

public class Grille {


    public static int getNBLIGNE() {
        return NBLIGNE;
    }

    public static int getNBCOLONNE() {
        return NBCOLONNE;
    }

    private static final int NBLIGNE = 6;
    private static final int NBCOLONNE = 7;
    private String[][] matrice = new String[NBLIGNE][NBCOLONNE];

    public String[][] getMatrice() {
        return matrice;
    }

    public void setMatrice(String[][] matrice) {
        this.matrice = matrice;
    }


    public void intitGrille() {

        int i, j;
        for (i = 0; i < NBLIGNE; i++) {
            for (j = 0; j < NBCOLONNE; j++) {
                matrice[i][j] = ".";
            }

        }
    }

    public void insertjeton(int j, String jeton) throws MaxJetonsException {
        int i = getNumberLineToInsert(j);
        if (i!=NBLIGNE) matrice[i][j] = jeton;
        else throw new MaxJetonsException("Pas possible");


    }

    public int getNumberLineToInsert(int j){
        int i = 0;
        while (i < NBLIGNE) {
            if (matrice[i][j] != ".") {
                i++;
            }
        }
        return i;
    }

}
