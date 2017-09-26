package fr.octo.puissance4;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ArbitreTest {

	private Arbitre arbitre;
	private Grille grille;

	@Before
	public void setUp() throws Exception {
		grille = new Grille();
		arbitre = new Arbitre(grille);

	}

	@Test
	public void AQuelJoueurDeJouer() {

		assertEquals( Grille.JOUEUR_1, arbitre.donneJoueurQuiDoitJouer() );
	}

	@Test
	public void JouerUnJeton() {
		arbitre.jouerUnJeton(3);
		assertEquals(Grille.JOUEUR_1, grille.getCellValue(3, 0));
	}

	@Test
	public void JouerTroisJetons() {

		arbitre.jouerUnJeton(2);
		arbitre.jouerUnJeton(2);
		arbitre.jouerUnJeton(2);

		assertEquals(Grille.JOUEUR_1, grille.getCellValue(2, 0));
		assertEquals(Grille.JOUEUR_2, grille.getCellValue(2, 1));
		assertEquals(Grille.JOUEUR_1, grille.getCellValue(2, 2));
	}

	@Test
	public void JouerPourFaireGagnerUnJoueur() {

		// 1
		// 1
		// 1
		// 1 2 - 2 - 2
		arbitre.jouerUnJeton(0);
		arbitre.jouerUnJeton(1);
		arbitre.jouerUnJeton(0);
		arbitre.jouerUnJeton(3);
		arbitre.jouerUnJeton(0);
		arbitre.jouerUnJeton(5);
		arbitre.jouerUnJeton(0);

		assertTrue(arbitre.partieGagnee());
	}

	@Test
	public void QuelEstLeJoueurGagnant() {

		// 1
		// 1 1
		// 1 2 2 2 2
		arbitre.jouerUnJeton(0);
		arbitre.jouerUnJeton(1);
		arbitre.jouerUnJeton(0);
		arbitre.jouerUnJeton(2);
		arbitre.jouerUnJeton(0);
		arbitre.jouerUnJeton(3);
		arbitre.jouerUnJeton(1);
		arbitre.jouerUnJeton(4);

		assertEquals( Grille.JOUEUR_2, arbitre.joueurGagnant() );
	}

	@Test
	public void JouerUnePartieNulle() {

		// 2 2 2 1 2 2 2
		// 1 1 1 2 1 1 1
		// 2 2 2 1 2 2 2
		// 1 1 1 2 1 1 1
		// 2 2 2 1 2 2 2
		// 1 1 1 2 1 1 1
		arbitre.jouerUnJeton(0);
		arbitre.jouerUnJeton(0);
		arbitre.jouerUnJeton(0);
		arbitre.jouerUnJeton(0);
		arbitre.jouerUnJeton(0);
		arbitre.jouerUnJeton(0);

		arbitre.jouerUnJeton(1);
		arbitre.jouerUnJeton(1);
		arbitre.jouerUnJeton(1);
		arbitre.jouerUnJeton(1);
		arbitre.jouerUnJeton(1);
		arbitre.jouerUnJeton(1);

		arbitre.jouerUnJeton(2);
		arbitre.jouerUnJeton(2);
		arbitre.jouerUnJeton(2);
		arbitre.jouerUnJeton(2);
		arbitre.jouerUnJeton(2);
		arbitre.jouerUnJeton(2);

		arbitre.jouerUnJeton(4);
		arbitre.jouerUnJeton(4);
		arbitre.jouerUnJeton(4);
		arbitre.jouerUnJeton(4);
		arbitre.jouerUnJeton(4);
		arbitre.jouerUnJeton(4);

		arbitre.jouerUnJeton(5);
		arbitre.jouerUnJeton(5);
		arbitre.jouerUnJeton(5);
		arbitre.jouerUnJeton(5);
		arbitre.jouerUnJeton(5);
		arbitre.jouerUnJeton(5);

		arbitre.jouerUnJeton(6);
		arbitre.jouerUnJeton(6);
		arbitre.jouerUnJeton(6);
		arbitre.jouerUnJeton(6);
		arbitre.jouerUnJeton(6);

		arbitre.jouerUnJeton(3);
		arbitre.jouerUnJeton(3);
		arbitre.jouerUnJeton(3);
		arbitre.jouerUnJeton(3);
		arbitre.jouerUnJeton(3);
		arbitre.jouerUnJeton(3);

		arbitre.jouerUnJeton(6);

		assertEquals(true, arbitre.partieNulle() );
	}

	@Test
	public void VerifierSiLaPartieEstEnCours() {
		arbitre.jouerUnJeton(2);
		arbitre.jouerUnJeton(3);
		arbitre.jouerUnJeton(4);
		arbitre.jouerUnJeton(1);
		arbitre.jouerUnJeton(2);

		assertTrue(arbitre.partieEnCours());
	}

}
