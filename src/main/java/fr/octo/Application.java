package fr.octo;

import fr.octo.puissance4.Arbitre;
import fr.octo.puissance4.Grille;

import java.util.Scanner;

public class Application {

    private Arbitre arbitre;

    public Application(Arbitre arbitre) {
        this.arbitre = arbitre;
    }

    public void print(String message) {
        System.out.println(message);
    }

    public String read() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public void afficheGrille() {
        this.print(this.arbitre.getAnalyseur().getGrille().toString());
    }

    public void afficheTour(){
        this.print(arbitre.getTour().toString());
    }

    public void getNumeroColonne() {

        String colonne;
        colonne = read();
    }
}
