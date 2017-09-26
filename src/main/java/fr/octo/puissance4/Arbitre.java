package fr.octo.puissance4;

public class Arbitre {

	private final Grille grille;
	private final Analyseur analyseur;
	private String joueurEnCours;

	public Arbitre(Grille grilleCourante) {
		grille  = grilleCourante;
		analyseur = new Analyseur(grille);
		joueurEnCours = Grille.JOUEUR_1;
	}

	public String donneJoueurQuiDoitJouer(){
		return joueurEnCours;
	}

	public void jouerUnJeton(int colonne) {

		grille.jouer(colonne,joueurEnCours);
		joueurEnCours = joueurEnCours.equals(Grille.JOUEUR_1) ? Grille.JOUEUR_2 : Grille.JOUEUR_1;
	}

	public boolean partieGagnee() {
		return analyseur.partieGagnee();
	}

	public String joueurGagnant() {
		return joueurEnCours.equals(Grille.JOUEUR_1) ? Grille.JOUEUR_2 : Grille.JOUEUR_1;
	}

	public boolean partieNulle() {
		return analyseur.partieNulle();
	}

	public boolean partieEnCours() {
		return !partieGagnee() && !partieNulle();
	}
}
