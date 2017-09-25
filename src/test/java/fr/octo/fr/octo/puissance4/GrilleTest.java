package fr.octo.fr.octo.puissance4;

import fr.octo.puissance4.Grille;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

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
		g.ajouterJeton(0, Grille.J1);
		assertEquals(Grille.J1, g.getCellValue(0,0));
	}

	@Test
	public void JouerDeuxJetonsDifferentsMemeColonne() {
		Grille g = new Grille();
		g.ajouterJeton(0, Grille.J1);
		g.ajouterJeton(0, Grille.J2);
		assertEquals(Grille.J1, g.getCellValue(0,0));
		assertEquals(Grille.J2, g.getCellValue(0,1));
	}

	@Test
	public void JouerSeptJetonsMemeColonne () {
		Grille g = new Grille();
		for (int i= 0; i < 6; i++) {
			assertEquals(true, g.ajouterJeton(2, Grille.J1));
		}
		assertEquals(false, g.ajouterJeton(2, Grille.J1));

	}

	@Test
	public void ViderLaGrille () {
		Grille g = new Grille();

		for (int i= 0; i < 6; i++) {
			g.ajouterJeton(0,Grille.J1);
			g.ajouterJeton(1,Grille.J2);
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
		g.ajouterJeton(0, Grille.J2);
		String expectedResult =
				".......\n" +
						".......\n" +
						".......\n" +
						".......\n" +
						".......\n" +
						Grille.J2 + "......\n";

		assertEquals(expectedResult, g.toString());
	}

	@Test
	public void AfficherGrilleAvecQuatreJetons () {
		Grille g = new Grille();

		g.ajouterJeton(3, Grille.J1);
		g.ajouterJeton(4, Grille.J2);
		g.ajouterJeton(4, Grille.J1);
		g.ajouterJeton(5, Grille.J2);

		String expectedResult =
				".......\n" +
				".......\n" +
				".......\n" +
				".......\n" +
				"...." + Grille.J1 + "..\n" +
				"..." + Grille.J1 + Grille.J2 + Grille.J2 + ".\n";
		assertEquals(expectedResult, g.toString());
	}
}
