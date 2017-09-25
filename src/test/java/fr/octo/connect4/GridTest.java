package fr.octo.connect4;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GridTest {

    @Test
    public void GridShouldBeEmpty() {
        Grid grid = new Grid();
        grid.init();

        for (int col = 0; col < Grid.NBCOL; ++col) {
            for (int line = 0; line < Grid.NBLINES; ++line) {
                assertEquals(".", grid.getCellState(col, line));
            }
        }
    }

    @Test
    public void CellShouldTakeToken() {
        Grid grid = new Grid();
        grid.addToken(0);
        
        assertEquals( "O", grid.getCellState(0, 0));
    }

}