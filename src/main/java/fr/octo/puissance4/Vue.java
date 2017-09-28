package fr.octo.puissance4;

import java.util.Scanner;

public class Vue {

    public void afficherMessage(String message) {
        System.out.println(message);
    }

    public String lireMessage() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
