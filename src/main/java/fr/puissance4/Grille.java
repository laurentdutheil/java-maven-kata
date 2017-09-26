package fr.puissance4;

import java.util.Arrays;

public class Grille {


    public static int getNBLIGNE() {
        return NBLIGNE;
    }

    public static int getNBCOLONNE() {
        return NBCOLONNE;
    }

    private static final int NBLIGNE = 6;
    private static final int NBCOLONNE = 7;

    public static String getJeton1() {
        return jeton1;
    }

    public static String getJeton2() {
        return jeton2;
    }

    private static final String jeton1 = "*";
    private static final String jeton2 = "o";


    private String[][] matrice = new String[NBLIGNE][NBCOLONNE];

    public String[][] getMatrice() {
        return matrice;
    }

    public void setMatrice(String[][] matrice) {
        this.matrice = matrice;
    }


    public void initGrille() {

        int i, j;
        for (i = 0; i < NBLIGNE; i++) {
            for (j = 0; j < NBCOLONNE; j++) {
                matrice[i][j] = ".";
            }

        }
        //  affichage();
    }


    public void affichage() {
        for (int i = 0; i < matrice.length; i++) {
            for (int j = 0; j < matrice[i].length; j++) {
                System.out.print(matrice[i][j]);
            }
            System.out.println();
        }
    }


    public void insertJetonByLineAndColumn(int i, int j, String jeton) {
        matrice[i][j] = jeton;

    }

    public int getNumberLineToInsert(int j) {
        int i = 0;
        while (i < NBLIGNE) {
            if (matrice[i][j] != ".") {
                i++;
            } else break;
        }
        return i;

    }

    public void insertJeton(int j, String jeton) throws MaxJetonsException {

            int i = getNumberLineToInsert(j);
            if (i != NBLIGNE) matrice[i][j] = jeton;
            else throw new MaxJetonsException("Pas possible, max atteint");



    }

    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < NBLIGNE; i++) {
            for (int j = 0; j < NBCOLONNE; j++) {
                result += matrice[i][j];
            }
            result += "\n";
        }
        System.out.println(result.toString());
        return result.toString();
    }


}
