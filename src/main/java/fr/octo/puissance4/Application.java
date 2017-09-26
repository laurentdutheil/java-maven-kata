package fr.octo.puissance4;

public class Application {

    private Arbitre arbitre;


    public Application() {
        arbitre = new Arbitre();
    }

    public void print (String message) {
        System.out.println(message);

    }

    public void start () {
        print(arbitre.getGrille().toString());

        print(arbitre.aQuiLeTour());
    }





}
