package fr.octo.puissance4;

public class Grille {
	public static final int COLONNE = 7;
	public static final int LIGNE = 6;

	public static final String J1 = "O";
	public static final String J2 = "*";

	private String[][] jetons;

	public Grille() {
		jetons = new String[COLONNE][LIGNE];
	}

	public boolean isCellEmpty(int c, int l) {
		return jetons[c][l] == null;
	}

	public boolean ajouterJeton(int c, String joueur) {
		boolean success = false;
		for (int l = 0; l < LIGNE; l++) {
			if (isCellEmpty(c,l)) {
				jetons[c][l] = joueur;
				success = true;
				break;

			}
		}
		return success;
	}

	public String getCellValue(int c, int l) {
		return jetons[c][l];
	}

	private String getCellValueAsString(int c, int l) {
		return (jetons[c][l] == null ? "." : jetons[c][l]);
	}

	public void vider() {
		jetons = new String[COLONNE][LIGNE];
	}


	@Override
	public String toString() {

		String result = "";
		for (int l=LIGNE-1;l>=0;l--){
			for (int c=0;c<COLONNE;c++) {
				result += getCellValueAsString(c,l);
			}
			result += "\n";
		}

		return result;
	}

}
