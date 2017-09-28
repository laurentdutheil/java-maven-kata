package fr.octo.puissance4;

public class Application {

    private final Vue vue;
    private Grille grille;
    private final Arbitre arbitre;


    public Application(Vue vue, Arbitre arbitre) {
        this.arbitre = arbitre;
        this.vue = vue;



    }


    public void start() {
        this.grille = arbitre.getGrille();

        vue.print(grille.toString());

        vue.print(arbitre.aQuiLeTour());

        while (!arbitre.getEtatPartie().equals(Arbitre.PARTIEGAGNEE)) {

            int coupAjouer = Integer.parseInt(vue.read());
            arbitre.joue(coupAjouer);
            vue.print(grille.toString());
        }

        vue.print(Arbitre.PARTIEGAGNEE);

    }


    public static void main(String[] args) {
        Grille grille = new Grille();
        Application app = new Application(new Vue(), new Arbitre(grille, new Analyseur(grille)));
        app.start();
    }


}
