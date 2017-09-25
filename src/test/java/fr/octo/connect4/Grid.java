package fr.octo.connect4;

public class Grid {
    public static final int NBCOL = 7;
    public static final int NBLINES = 6;
    private String[][] state = new String[NBCOL][NBLINES];
    //private int nbTokens;

    public Grid() {
        init();
    }

    public void init() {
        for (int col = 0; col < NBCOL; ++col) {
            for (int line = 0; line < NBLINES; ++line) {
                state[col][line] = ".";
            }
        }
    }

    public void addToken(int col) {
        state[col][0] = "O";
    }

    public String getCellState(int col, int line) {
        return state[col][line];
    }

}
