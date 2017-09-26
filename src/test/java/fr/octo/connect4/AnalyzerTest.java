package fr.octo.connect4;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class AnalyzerTest {

    @Test
    public void ShouldDectectFourTokenLine() {
        Grid grid = new Grid();
        Analyzer analyzer = new Analyzer(grid);

        grid.addToken(1, Token.R);
        grid.addToken(2, Token.R);
        grid.addToken(3, Token.R);
        grid.addToken(4, Token.R);

        boolean checkLine = analyzer.checkTokenLine(3, 0);
        assertTrue(checkLine);
    }
}
