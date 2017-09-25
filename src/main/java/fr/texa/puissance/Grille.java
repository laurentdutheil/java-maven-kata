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

        if ((x == 0) && (this.data.charAt(40) == '.')) {
            this.data = this.data.substring(0,40)+ type +this.data.substring(41);
        }
        else if ((x == 0) && (this.data.charAt(32) == '.')) {
            this.data = this.data.substring(0,32)+ type +this.data.substring(33);
        }
        else if ((x == 0) && (this.data.charAt(24) == '.')) {
            this.data = this.data.substring(0,24)+ type +this.data.substring(25);
        }
        else if ((x == 0) && (this.data.charAt(16) == '.')) {
            this.data = this.data.substring(0,16)+ type +this.data.substring(17);
        }
        else if ((x == 0) && (this.data.charAt(8) == '.')) {
            this.data = this.data.substring(0,8)+ type +this.data.substring(9);
        }
        else if ((x == 0) && (this.data.charAt(0) == '.')) {
            this.data = type +this.data.substring(1);
        }

    }
}
