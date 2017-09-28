package fr.octo.puissance4;

public class Arbitre {

    public static final String PARTIEENCOURS = "En cours";
    public static final String PARTIENULLE= "Nulle";
    public static final String PARTIEGAGNEE = "Gagnée !";
    public static final String JOUEUR_JAUNE = "O";
    public static final String JOUEUR_ROUGE = "*";

    private final Analyseur analyseur;
    private Grille grille;
    private String joueurEnCours;
    private String etatPartie;
    private String vainqueur;

    public Arbitre(Grille grille, Analyseur analyseur) {
        this.grille = grille;
        joueurEnCours = JOUEUR_JAUNE;
        etatPartie = PARTIEENCOURS;
        this.analyseur = analyseur;
        vainqueur = "";
    }

    public String aQuiLeTour() {
         return joueurEnCours;

    }

    public void joue(int colonne) {
        grille.jouer(colonne, joueurEnCours);

        if(analyseur.partieGagnee()) {
           etatPartie = PARTIEGAGNEE;
           vainqueur = joueurEnCours;
        } else if( analyseur.partieNulle()) {
           etatPartie = PARTIENULLE;
        } else {
            changerJoueurEnCours();
        }

    }

    public Grille getGrille() {
        return grille;
    }

    public void changerJoueurEnCours(){
        joueurEnCours = joueurEnCours.equals(JOUEUR_JAUNE) ? JOUEUR_ROUGE : JOUEUR_JAUNE;
    }

    public String getEtatPartie() {
        return etatPartie;
    }

    public String getVainqueur() {
        return vainqueur;
    }
}
