package fr.octo.puissance4;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GrilleTest {

	private boolean GrilleEstVide(Grille g) {
		boolean isEmpty = true;
		for (int i = 0; i < Grille.COLONNE && isEmpty; i++){
			for (int j = 0; j < Grille.LIGNE && isEmpty; j++) {
				if ( !g.isCellEmpty(i,j)){
					isEmpty = false;
				}
			}
		}

		return isEmpty;
	}

	@Test
	public void NouvelleGrilleEstBienVide () {
		assertEquals(true, GrilleEstVide(new Grille()));
	}

	@Test
	public void JouerUnJeton () {
		Grille g = new Grille();
		g.jouer(0, Arbitre.JOUEUR_JAUNE);
		assertEquals(Arbitre.JOUEUR_JAUNE, g.getCellValue(0,0));
	}

	@Test
	public void JouerDeuxJetonsDifferentsMemeColonne() {
		Grille g = new Grille();
		g.jouer(0, Arbitre.JOUEUR_JAUNE);
		g.jouer(0, Arbitre.JOUEUR_ROUGE);
		assertEquals(Arbitre.JOUEUR_JAUNE, g.getCellValue(0,0));
		assertEquals(Arbitre.JOUEUR_ROUGE, g.getCellValue(0,1));
	}

	@Test
	public void JouerSeptJetonsMemeColonne () {
		Grille g = new Grille();
		for (int i= 0; i < 6; i++) {
			assertEquals(true, g.jouer(2, Arbitre.JOUEUR_JAUNE));
		}
		assertEquals(false, g.jouer(2, Arbitre.JOUEUR_JAUNE));

	}

	@Test
	public void ViderLaGrille () {
		Grille g = new Grille();

		for (int i= 0; i < 6; i++) {
			g.jouer(0, Arbitre.JOUEUR_JAUNE);
			g.jouer(1, Arbitre.JOUEUR_ROUGE);
		}
		g.vider();

		assertEquals(true, GrilleEstVide(g));
	}

	@Test
	public void AfficherGrilleVide () {
		Grille g = new Grille();
		String expectedResult =
				".......\n" +
				".......\n" +
				".......\n" +
				".......\n" +
				".......\n" +
				".......\n";

		assertEquals(expectedResult, g.toString());
	}

	@Test
	public void AfficherGrilleAvecUnJeton () {
		Grille g = new Grille();
		g.jouer(0, Arbitre.JOUEUR_ROUGE);
		String expectedResult =
				".......\n" +
				".......\n" +
				".......\n" +
				".......\n" +
				".......\n" +
				Arbitre.JOUEUR_ROUGE + "......\n";

		assertEquals(expectedResult, g.toString());
	}

	@Test
	public void AfficherGrilleAvecQuatreJetons () {
		Grille g = new Grille();

		g.jouer(3, Arbitre.JOUEUR_JAUNE);
		g.jouer(4, Arbitre.JOUEUR_ROUGE);
		g.jouer(4, Arbitre.JOUEUR_JAUNE);
		g.jouer(5, Arbitre.JOUEUR_ROUGE);

		String expectedResult =
				".......\n" +
				".......\n" +
				".......\n" +
				".......\n" +
				"...." + Arbitre.JOUEUR_JAUNE + "..\n" +
				"..." + Arbitre.JOUEUR_JAUNE + Arbitre.JOUEUR_ROUGE + Arbitre.JOUEUR_ROUGE + ".\n";
		assertEquals(expectedResult, g.toString());
	}

	@Test
	public void PlateauDuJeuEstRempli () {
		// 1 2 1 1 2 1 1
		// 2 1 1 2 1 1 2
		// 1 2 2 2 1 2 1
		// 1 1 1 2 2 2 1
		// 2 1 2 1 1 1 2
		// 1 2 1 1 2 2 1
		Grille g = new Grille();
		g.jouer(0, Arbitre.JOUEUR_JAUNE);
		g.jouer(0, Arbitre.JOUEUR_ROUGE);
		g.jouer(0, Arbitre.JOUEUR_JAUNE);
		g.jouer(0, Arbitre.JOUEUR_JAUNE);
		g.jouer(0, Arbitre.JOUEUR_ROUGE);
		g.jouer(0, Arbitre.JOUEUR_JAUNE);

		g.jouer(1, Arbitre.JOUEUR_ROUGE);
		g.jouer(1, Arbitre.JOUEUR_JAUNE);
		g.jouer(1, Arbitre.JOUEUR_JAUNE);
		g.jouer(1, Arbitre.JOUEUR_ROUGE);
		g.jouer(1, Arbitre.JOUEUR_JAUNE);
		g.jouer(1, Arbitre.JOUEUR_ROUGE);

		g.jouer(2, Arbitre.JOUEUR_JAUNE);
		g.jouer(2, Arbitre.JOUEUR_ROUGE);
		g.jouer(2, Arbitre.JOUEUR_JAUNE);
		g.jouer(2, Arbitre.JOUEUR_ROUGE);
		g.jouer(2, Arbitre.JOUEUR_JAUNE);
		g.jouer(2, Arbitre.JOUEUR_JAUNE);

		g.jouer(3, Arbitre.JOUEUR_JAUNE);
		g.jouer(3, Arbitre.JOUEUR_JAUNE);
		g.jouer(3, Arbitre.JOUEUR_ROUGE);
		g.jouer(3, Arbitre.JOUEUR_ROUGE);
		g.jouer(3, Arbitre.JOUEUR_ROUGE);
		g.jouer(3, Arbitre.JOUEUR_JAUNE);

		g.jouer(4, Arbitre.JOUEUR_ROUGE);
		g.jouer(4, Arbitre.JOUEUR_JAUNE);
		g.jouer(4, Arbitre.JOUEUR_ROUGE);
		g.jouer(4, Arbitre.JOUEUR_JAUNE);
		g.jouer(4, Arbitre.JOUEUR_JAUNE);
		g.jouer(4, Arbitre.JOUEUR_ROUGE);

		g.jouer(5, Arbitre.JOUEUR_ROUGE);
		g.jouer(5, Arbitre.JOUEUR_JAUNE);
		g.jouer(5, Arbitre.JOUEUR_ROUGE);
		g.jouer(5, Arbitre.JOUEUR_ROUGE);
		g.jouer(5, Arbitre.JOUEUR_JAUNE);
		g.jouer(5, Arbitre.JOUEUR_JAUNE);

		g.jouer(6, Arbitre.JOUEUR_JAUNE);
		g.jouer(6, Arbitre.JOUEUR_ROUGE);
		g.jouer(6, Arbitre.JOUEUR_JAUNE);
		g.jouer(6, Arbitre.JOUEUR_JAUNE);
		g.jouer(6, Arbitre.JOUEUR_ROUGE);
		g.jouer(6, Arbitre.JOUEUR_JAUNE);


		assertTrue( g.plateauDuJeuEstRempli() );
	}
}
