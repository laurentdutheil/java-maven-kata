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
    public void clearGridShouldGetEmpty() {
        Grid grid = new Grid();
        grid.clear();

        Assert.assertTrue(Arrays.deepEquals(grid.grid, new int[6][7]));
    }

    @Test(expected = IllegalArgumentException.class)
    public void add7TokensShouldReturnIllegalArgumentException() {
        Grid grid = new Grid();
        int columnIndex = 6;
        int tokenToFill = 6;

        for(int i = 0; i < tokenToFill; i++) {
            grid.addToken(columnIndex);
        }

        grid.addToken(columnIndex);
    }

    @Test
    public void addTokenShouldBeKeptInGrid() {
        Grid grid = new Grid();

        Assert.assertTrue(grid.grid[0][0] == 0);
        grid.addToken(0);

        Assert.assertTrue(grid.grid[0][0] == 1);
    }

    @Test
    public void keepGridState() {
        Grid grid = new Grid();

        Assert.assertTrue(grid.grid[0][2] == 0);
        Assert.assertTrue(grid.grid[1][2] == 0);
        Assert.assertTrue(grid.grid[0][4] == 0);
        Assert.assertTrue(grid.grid[0][5] == 0);

        grid.addToken(2);

        Assert.assertTrue(grid.grid[0][2] == 1);

        grid.addToken(2);

        Assert.assertTrue(grid.grid[0][2] == 1);
        Assert.assertTrue(grid.grid[1][2] == 1);

        grid.addToken(4);

        Assert.assertTrue(grid.grid[0][2] == 1);
        Assert.assertTrue(grid.grid[1][2] == 1);
        Assert.assertTrue(grid.grid[0][4] == 1);

        grid.addToken(5);

        Assert.assertTrue(grid.grid[0][2] == 1);
        Assert.assertTrue(grid.grid[1][2] == 1);
        Assert.assertTrue(grid.grid[0][4] == 1);
        Assert.assertTrue(grid.grid[0][5] == 1);
    }

    @Test
    public void displayGridShouldPrintGridState() {
        String gridToDisplay = ".......\n..*..*..\n..*.**..\n.**.**..\n.******.\n.******";

        Grid grid = new Grid();

        Assert.assertTrue(gridToDisplay);
    }
}
