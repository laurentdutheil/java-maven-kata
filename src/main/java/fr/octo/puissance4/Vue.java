package fr.octo.puissance4;

import java.util.Scanner;

public class Vue {

    public void print (String message) {
        System.out.println(message);

    }

    public String read () {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
