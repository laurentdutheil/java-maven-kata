package fr.texa.puissance;

public class Grille {

    private String data;
    public Grille() {
        this.data = ".......\n.......\n" +
        ".......\n.......\n.......\n.......\n";
    }

    @Override
    public String toString() {
        return this.data;
    }

    public void place(int x, char type){

        if (this.data.charAt(x + 40) == '.') {
            this.data = this.data.substring(0, x + 40)+ type +this.data.substring(x + 41);
        }
        else if (this.data.charAt(x + 32) == '.') {
            this.data = this.data.substring(0,x + 32)+ type +this.data.substring(x + 33);
        }
        else if (this.data.charAt(x + 24) == '.') {
            this.data = this.data.substring(0,x + 24)+ type +this.data.substring(x + 25);
        }
        else if (this.data.charAt(x + 16) == '.') {
            this.data = this.data.substring(0,x + 16)+ type +this.data.substring(x + 17);
        }
        else if (this.data.charAt(x + 8) == '.') {
            this.data = this.data.substring(0,x + 8)+ type +this.data.substring(x + 9);
        }
        else if (this.data.charAt(x) == '.') {
            this.data = type +this.data.substring(x + 1);
        }


    }
}
