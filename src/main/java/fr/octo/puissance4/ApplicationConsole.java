package fr.octo.puissance4;

import java.util.Scanner;

public class ApplicationConsole {

	private Grille grille;
	private Arbitre arbitre;

	public ApplicationConsole() {

	}

	public void demarrerPartie() {

		grille = new Grille();
		arbitre = new Arbitre(grille);
		print(grille.toString());

	}

	public void print(String message) {
		System.out.println(message);
	}

	public String read() {

		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}

	public void afficherInvitationPourJouer() {

		String nomDuJoueur;
		String message;

		nomDuJoueur = arbitre.donneJoueurQuiDoitJouer().equals("J") ? "jaune" : "rouge";
		message = nomDuJoueur + " colonne [1-7] : ";
		print(message);
	}

	public String lireColonneAJouer() {
		String colonneAJouer = read();
		arbitre.jouerUnJeton(Integer.parseInt(colonneAJouer));
		return colonneAJouer;
	}
}
