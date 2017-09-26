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
		g.jouer(0, Grille.JOUEUR_1);
		assertEquals(Grille.JOUEUR_1, g.getCellValue(0,0));
	}

	@Test
	public void JouerDeuxJetonsDifferentsMemeColonne() {
		Grille g = new Grille();
		g.jouer(0, Grille.JOUEUR_1);
		g.jouer(0, Grille.JOUEUR_2);
		assertEquals(Grille.JOUEUR_1, g.getCellValue(0,0));
		assertEquals(Grille.JOUEUR_2, g.getCellValue(0,1));
	}

	@Test
	public void JouerSeptJetonsMemeColonne () {
		Grille g = new Grille();
		for (int i= 0; i < 6; i++) {
			assertEquals(true, g.jouer(2, Grille.JOUEUR_1));
		}
		assertEquals(false, g.jouer(2, Grille.JOUEUR_1));

	}

	@Test
	public void ViderLaGrille () {
		Grille g = new Grille();

		for (int i= 0; i < 6; i++) {
			g.jouer(0,Grille.JOUEUR_1);
			g.jouer(1,Grille.JOUEUR_2);
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
		g.jouer(0, Grille.JOUEUR_2);
		String expectedResult =
				".......\n" +
				".......\n" +
				".......\n" +
				".......\n" +
				".......\n" +
				Grille.JOUEUR_2 + "......\n";

		assertEquals(expectedResult, g.toString());
	}

	@Test
	public void AfficherGrilleAvecQuatreJetons () {
		Grille g = new Grille();

		g.jouer(3, Grille.JOUEUR_1);
		g.jouer(4, Grille.JOUEUR_2);
		g.jouer(4, Grille.JOUEUR_1);
		g.jouer(5, Grille.JOUEUR_2);

		String expectedResult =
				".......\n" +
				".......\n" +
				".......\n" +
				".......\n" +
				"...." + Grille.JOUEUR_1 + "..\n" +
				"..." + Grille.JOUEUR_1 + Grille.JOUEUR_2 + Grille.JOUEUR_2 + ".\n";
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
		g.jouer(0, Grille.JOUEUR_1);
		g.jouer(0, Grille.JOUEUR_2);
		g.jouer(0, Grille.JOUEUR_1);
		g.jouer(0, Grille.JOUEUR_1);
		g.jouer(0, Grille.JOUEUR_2);
		g.jouer(0, Grille.JOUEUR_1);

		g.jouer(1, Grille.JOUEUR_2);
		g.jouer(1, Grille.JOUEUR_1);
		g.jouer(1, Grille.JOUEUR_1);
		g.jouer(1, Grille.JOUEUR_2);
		g.jouer(1, Grille.JOUEUR_1);
		g.jouer(1, Grille.JOUEUR_2);

		g.jouer(2, Grille.JOUEUR_1);
		g.jouer(2, Grille.JOUEUR_2);
		g.jouer(2, Grille.JOUEUR_1);
		g.jouer(2, Grille.JOUEUR_2);
		g.jouer(2, Grille.JOUEUR_1);
		g.jouer(2, Grille.JOUEUR_1);

		g.jouer(3, Grille.JOUEUR_1);
		g.jouer(3, Grille.JOUEUR_1);
		g.jouer(3, Grille.JOUEUR_2);
		g.jouer(3, Grille.JOUEUR_2);
		g.jouer(3, Grille.JOUEUR_2);
		g.jouer(3, Grille.JOUEUR_1);

		g.jouer(4, Grille.JOUEUR_2);
		g.jouer(4, Grille.JOUEUR_1);
		g.jouer(4, Grille.JOUEUR_2);
		g.jouer(4, Grille.JOUEUR_1);
		g.jouer(4, Grille.JOUEUR_1);
		g.jouer(4, Grille.JOUEUR_2);

		g.jouer(5, Grille.JOUEUR_2);
		g.jouer(5, Grille.JOUEUR_1);
		g.jouer(5, Grille.JOUEUR_2);
		g.jouer(5, Grille.JOUEUR_2);
		g.jouer(5, Grille.JOUEUR_1);
		g.jouer(5, Grille.JOUEUR_1);

		g.jouer(6, Grille.JOUEUR_1);
		g.jouer(6, Grille.JOUEUR_2);
		g.jouer(6, Grille.JOUEUR_1);
		g.jouer(6, Grille.JOUEUR_1);
		g.jouer(6, Grille.JOUEUR_2);
		g.jouer(6, Grille.JOUEUR_1);


		assertTrue( g.plateauDuJeuEstRempli() );
	}
}
