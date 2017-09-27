package fr.octo.puissance4;

import java.util.Scanner;

public class Vue {
    public void imprimer(String message) {
        System.out.println(message);
    }

    public String lire() {
        Scanner numeriseur = new Scanner(System.in);
        return numeriseur.nextLine();
    }
}
