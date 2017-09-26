package fr.octo.connect4;

import org.junit.Test;


import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;

public class GridTest {

    @Test
    public void GridShouldBeEmpty() {
        Grid grid = new Grid();
        grid.init();

        gridIsEmpty(grid);
    }

    @Test
    public void CellShouldTakeToken() {
        Grid grid = new Grid();
        grid.addToken(0, Token.R);

        assertEquals( Token.R.toString(), grid.getCellState(0, 0));
    }

    @Test
    public void ColShouldStackTokens() {
        Grid grid = new Grid();
        grid.addToken(0, Token.R);
        grid.addToken(0, Token.R);

        assertEquals(Token.R.toString(), grid.getCellState(0, 0));
        assertEquals(Token.R.toString(), grid.getCellState(0, 1));
    }

    @Test
    public void GridShouldbeResetable() {
        Grid grid = new Grid();
        grid.addToken(1, Token.R);
        grid.addToken(1, Token.R);

        grid.init();

        gridIsEmpty(grid);
    }

    @Test
    public void ColStackLimitShouldNotBeOverflowed() {
        Grid grid = new Grid();

        grid.addToken(0, Token.R);
        grid.addToken(0, Token.R);
        grid.addToken(0, Token.R);
        grid.addToken(0, Token.R);
        grid.addToken(0, Token.R);
        grid.addToken(0, Token.R);

        boolean colIsFull = grid.addToken(0, Token.R);
        assertFalse(colIsFull);
    }

    @Test
    public void TokenTypeShouldBeToggled() {
        Grid grid = new Grid();
        grid.addToken(0, Token.Y);
        grid.addToken(0, Token.R);

        assertEquals(Token.Y.toString(), grid.getCellState(0, 0));
        assertEquals(Token.R.toString(), grid.getCellState(0, 1));
    }

    @Test
    public void GridShouldReturnAString() {
        Grid grid = new Grid();
        grid.addToken(0, Token.Y);
        grid.addToken(0, Token.R);

        String res =
                ".......\n" +
                ".......\n" +
                ".......\n" +
                ".......\n" +
                "O......\n" +
                "X......";

        assertEquals(res, grid.toString());
    }

    private void gridIsEmpty(Grid grid) {
        for (int col = 0; col < Grid.NBCOL; ++col) {
            for (int line = 0; line < Grid.NBLINES; ++line) {
                assertEquals(".", grid.getCellState(col, line));
            }
        }
    }
}