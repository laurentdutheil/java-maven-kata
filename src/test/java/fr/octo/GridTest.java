package fr.octo;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class GridTest {

    @Test
    public void gridState() {
        Grid grid = new Grid();
    }

    @Test
    public void gridEmpty() {
        Grid grid = new Grid();
        grid.clear();

        Assert.assertTrue(Arrays.deepEquals(grid.grid, new int[6][7]));
    }

    @Test(expected = IllegalArgumentException.class)
    public void acceptTil6TokensByColumn_moreThanExpected() {
        Grid grid = new Grid();
        int columnIndex = 6;
        grid.grid[5][columnIndex] = 1;

        grid.addToken(columnIndex);
    }
}
