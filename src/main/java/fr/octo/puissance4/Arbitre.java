package fr.octo.puissance4;

public class Arbitre {

    private Analyseur analyseur;

    public Analyseur getAnalyseur() {
        return analyseur;
    }

    public Etat getEtat() {
        return etat;
    }

    public enum Tour {jaune, rouge}

    ;

    private Tour tour;

    public enum Etat {EnCours, Gagnee, Nulle}

    ;

    private Etat etat;

    public Arbitre(Analyseur analyseur) {
        this.analyseur = analyseur;
        tour = Tour.jaune;
        etat = Etat.EnCours;
    }

    public Tour getTour() {
        return tour;
    }

    private void setTour(Tour tour) {
        this.tour = tour;
    }

    private void inverseTour() {
        if (tour.equals(Tour.jaune)) tour = Tour.rouge;
        else tour = Tour.jaune;
    }

    public void jouer(int colonne) {

        String caractere;
        if (tour.equals(Tour.jaune))
            caractere = "o";
        else
            caractere = "*";
        analyseur.getGrille().jouer(colonne, caractere);
        changerEtat();
        if (etat.equals(Etat.EnCours)) inverseTour();

    }

    private void changerEtat() {
        if (analyseur.partieGagnee()) etat = Etat.Gagnee;
        if (analyseur.partieNulle()) etat = Etat.Nulle;
    }

    public Tour getVainqueur() {
        if (etat.equals(Etat.Gagnee))
            return tour;
        else return null;
    }
}

