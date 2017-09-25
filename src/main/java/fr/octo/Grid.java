package fr.octo;

public class Grid {

    public int[][] grid;

    public Grid() {
        grid = new int[6][7];
    }

    public void clear() {
        grid = new int[6][7];
    }

    public void addToken(int columnIndex) {
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][columnIndex] == 0) {
                grid[i][columnIndex] = 1;
                return;
            }
        }
        throw new IllegalArgumentException("No more than 6 tokens");
    }
}
