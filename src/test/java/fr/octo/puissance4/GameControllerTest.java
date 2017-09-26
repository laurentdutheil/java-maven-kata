package fr.octo.puissance4;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class GameControllerTest {
	
	@Test
	public void VerifieSiGagnantEnLigneHorizontale(){
		
		Grille g1 = new Grille();
		g1.jouer(0,Grille.JOUEUR_1);
		g1.jouer(1,Grille.JOUEUR_1);
		g1.jouer(2,Grille.JOUEUR_1);
		g1.jouer(3,Grille.JOUEUR_1);

		Grille g2 = new Grille();
		g2.jouer(2,Grille.JOUEUR_1);
		g2.jouer(3,Grille.JOUEUR_2);
		g2.jouer(4,Grille.JOUEUR_1);
		g2.jouer(5,Grille.JOUEUR_2);
		g2.jouer(2,Grille.JOUEUR_2);
		g2.jouer(3,Grille.JOUEUR_2);
		g2.jouer(4,Grille.JOUEUR_2);
		g2.jouer(5,Grille.JOUEUR_2);

		GameController gameController1 = new GameController(g1);
		GameController gameController2 = new GameController(g2);

		assertTrue( gameController1.estGagnant() );
		assertTrue( gameController2.estGagnant() );
	}

	@Test
	public void VerifieSiGagnantEnColonne(){

		Grille g1 = new Grille();
		g1.jouer(2,Grille.JOUEUR_1);
		g1.jouer(2,Grille.JOUEUR_1);
		g1.jouer(2,Grille.JOUEUR_1);
		g1.jouer(2,Grille.JOUEUR_1);

		GameController gameController = new GameController(g1);

		assertTrue( gameController.estGagnant() );

	}

	@Test
	public void VerifieSiGagnantEnDiagonale(){

		// 1
		// 2 1
		// 2 2 1
		// 2 1 2 1
		Grille g1 = new Grille();
		g1.jouer(1,Grille.JOUEUR_2);
		g1.jouer(1,Grille.JOUEUR_2);
		g1.jouer(1,Grille.JOUEUR_2);
		g1.jouer(1,Grille.JOUEUR_1);

		g1.jouer(2,Grille.JOUEUR_1);
		g1.jouer(2,Grille.JOUEUR_2);
		g1.jouer(2,Grille.JOUEUR_1);

		g1.jouer(3,Grille.JOUEUR_2);
		g1.jouer(3,Grille.JOUEUR_1);

		g1.jouer(4,Grille.JOUEUR_1);


		//       2
		//   1 2 1
		//   2 1 2
		// 2 1 2 1
		Grille g2 = new Grille();
		g2.jouer(0, Grille.JOUEUR_2);

		g2.jouer(1, Grille.JOUEUR_1);
		g2.jouer(1, Grille.JOUEUR_2);
		g2.jouer(1, Grille.JOUEUR_1);

		g2.jouer(2,Grille.JOUEUR_2);
		g2.jouer(2,Grille.JOUEUR_1);
		g2.jouer(2,Grille.JOUEUR_2);

		g2.jouer(3,Grille.JOUEUR_1);
		g2.jouer(3,Grille.JOUEUR_2);
		g2.jouer(3,Grille.JOUEUR_1);
		g2.jouer(3,Grille.JOUEUR_2);

		GameController gameController1 = new GameController(g1);
		GameController gameController2 = new GameController(g2);

		assertTrue( gameController1.estGagnant() );
		assertTrue( gameController2.estGagnant() );

	}

	@Test
	public void VerifieSiPartieNulle() {

		// 1 2 1 1 2 1 1
		// 2 1 1 2 1 1 2
		// 1 2 2 2 1 2 1
		// 1 1 1 2 2 2 1
		// 2 1 2 1 1 1 2
		// 1 2 1 1 2 2 1
		Grille g1 = new Grille();
		g1.jouer(0, Grille.JOUEUR_1);
		g1.jouer(0, Grille.JOUEUR_2);
		g1.jouer(0, Grille.JOUEUR_1);
		g1.jouer(0, Grille.JOUEUR_1);
		g1.jouer(0, Grille.JOUEUR_2);
		g1.jouer(0, Grille.JOUEUR_1);

		g1.jouer(1, Grille.JOUEUR_2);
		g1.jouer(1, Grille.JOUEUR_1);
		g1.jouer(1, Grille.JOUEUR_1);
		g1.jouer(1, Grille.JOUEUR_2);
		g1.jouer(1, Grille.JOUEUR_1);
		g1.jouer(1, Grille.JOUEUR_2);

		g1.jouer(2, Grille.JOUEUR_1);
		g1.jouer(2, Grille.JOUEUR_2);
		g1.jouer(2, Grille.JOUEUR_1);
		g1.jouer(2, Grille.JOUEUR_2);
		g1.jouer(2, Grille.JOUEUR_1);
		g1.jouer(2, Grille.JOUEUR_1);

		g1.jouer(3, Grille.JOUEUR_1);
		g1.jouer(3, Grille.JOUEUR_1);
		g1.jouer(3, Grille.JOUEUR_2);
		g1.jouer(3, Grille.JOUEUR_2);
		g1.jouer(3, Grille.JOUEUR_2);
		g1.jouer(3, Grille.JOUEUR_1);

		g1.jouer(4, Grille.JOUEUR_2);
		g1.jouer(4, Grille.JOUEUR_1);
		g1.jouer(4, Grille.JOUEUR_2);
		g1.jouer(4, Grille.JOUEUR_1);
		g1.jouer(4, Grille.JOUEUR_1);
		g1.jouer(4, Grille.JOUEUR_2);

		g1.jouer(5, Grille.JOUEUR_2);
		g1.jouer(5, Grille.JOUEUR_1);
		g1.jouer(5, Grille.JOUEUR_2);
		g1.jouer(5, Grille.JOUEUR_2);
		g1.jouer(5, Grille.JOUEUR_1);
		g1.jouer(5, Grille.JOUEUR_1);

		g1.jouer(6, Grille.JOUEUR_1);
		g1.jouer(6, Grille.JOUEUR_2);
		g1.jouer(6, Grille.JOUEUR_1);
		g1.jouer(6, Grille.JOUEUR_1);
		g1.jouer(6, Grille.JOUEUR_2);
		g1.jouer(6, Grille.JOUEUR_1);

		GameController gameController1 = new GameController(g1);

		assertTrue( gameController1.partieNulle() );

	}



}

