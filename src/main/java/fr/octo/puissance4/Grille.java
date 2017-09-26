package fr.octo.puissance4;

public class Grille {
	public static final int COLONNE = 7;
	public static final int LIGNE = 6;

	public static final String J1 = "O";
	public static final String J2 = "*";

	private String[][] cells;

	public Grille() {
		cells = new String[COLONNE][LIGNE];
	}

	public boolean isCellEmpty(int c, int l) {
		return cells[c][l] == null;
	}

	public boolean addToken(int c, String token) {
		boolean success = false;
		for (int l = 0; l < LIGNE; l++) {
			if (isCellEmpty(c,l)) {
				cells[c][l] = token;
				success = true;
				break;
			}
		}
		return success;
	}

	public String getCellValue(int c, int l) {
		return cells[c][l];
	}

	private String getCellValueAsString(int c, int l) {
		return (cells[c][l] == null ? "." : cells[c][l]);
	}

	public void vider() {
		cells = new String[COLONNE][LIGNE];
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
