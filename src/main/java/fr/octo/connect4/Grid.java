package fr.octo.connect4;

public class Grid {
    public static final int NBCOL = 7;
    public static final int NBLINES = 6;
    private String[][] state = new String[NBCOL][NBLINES];
    private int[] nbTokensInColumns = new int[NBCOL];
    //private int nbTokens;

    public Grid() {
        init();
    }

    public void init() {
        for (int col = 0; col < NBCOL; ++col) {
            nbTokensInColumns[col] = 0;
            for (int line = 0; line < NBLINES; ++line) {
                state[col][line] = ".";
            }
        }
    }

    public boolean addToken(int col, Token token) {
        if (nbTokensInColumns[col] >= NBLINES) {
            return false;
        }

        state[col][nbTokensInColumns[col]] = token.toString();
        ++nbTokensInColumns[col];

        return true;
    }

    public String getCellState(int col, int line) {
        return state[col][line];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int lastLine = NBLINES - 1;
        for (int line = lastLine; line >= 1; --line) {
            for (int col = 0; col < NBCOL; ++col) {
                sb.append(state[col][line]);
            }
            sb.append("\n");
        }
        for (int col = 0; col < NBCOL; ++col) {
            sb.append(state[col][0]);
        }
        return sb.toString();
    }
}
