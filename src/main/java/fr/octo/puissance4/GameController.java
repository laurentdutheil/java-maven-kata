package fr.octo.puissance4;

public class GameController {

	private Grille grille;

	public GameController(Grille g) {

		grille = g;
	}

	public boolean estGagnant() {

		boolean gagnant = false;
		for (int l = 0; l < Grille.LIGNE && !gagnant; l++) {

			for (int c = 0; c < Grille.COLONNE && !gagnant; c++){
				gagnant = verifie4ALaSuite(c, l, 1, 0, 1);
				gagnant = gagnant || verifie4ALaSuite(c, l, 0, 1, 1);
				gagnant = gagnant || verifie4ALaSuite(c, l, 1, 1, 1);
				gagnant = gagnant || verifie4ALaSuite(c, l, 1, -1, 1);
			}

		}

		return gagnant;
	}


	private boolean verifie4ALaSuite(int col, int ligne, int offsetCol, int offsetLigne, int compteur) {

		String cellValue = grille.getCellValue(col, ligne);

		String nextCellValue = grille.getCellValue(col + offsetCol, ligne + offsetLigne);

		if ( cellValue != null && cellValue.equals(nextCellValue)) {
			compteur++;
			if (compteur == 4) {
				return true;
			} else {
				return verifie4ALaSuite(col + offsetCol, ligne + offsetLigne, offsetCol, offsetLigne, compteur);
			}
		}

		return false;

	}
}
