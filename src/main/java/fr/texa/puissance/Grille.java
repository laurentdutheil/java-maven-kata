package fr.texa.puissance;

public class Grille {

    private String data;
    public Grille() {
        this.data = ".......\n" +
                    ".......\n" +
                    ".......\n" +
                    ".......\n" +
                    ".......\n" +
                    ".......\n";
    }

    @Override
    public String toString() {
        return this.data;
    }

    public void place(int x, char type){
        for(int i = 0; i < 41; i += 8) {
            if (this.data.charAt(x + i) == '.') {
                this.data = this.data.substring(0, x + i)+ type +this.data.substring(x + i + 1);
            }
        }
    }
}
