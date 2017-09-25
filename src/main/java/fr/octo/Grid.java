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
        if(grid[5][columnIndex] != 0) {
            throw new IllegalArgumentException("No more than 6 tokens");
        }
    }
}
