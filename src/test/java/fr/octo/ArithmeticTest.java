package fr.octo;



import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

public class ArithmeticTest {

    private static final double MARGIN = 0.0001;

    @Test
    public void should_test() {
        //fail("not yet implemented");
        //assertEquals(4, 2+2);
        assertThat(2+2).isEqualTo(4);
    }

    @Test
    public void DistanceBetweenSamePointsShouldBeZero() {
        Point a = new Point(3.0, 2.0);
        Point b = new Point(3.0, 2.0);
        assertEquals(0.0, a.distance(b), MARGIN);
    }

    @Test
    public void DistanceBetweenSameXShouldBeDifferenceBetweenY() {
        Point a = new Point(3.0, 1.0);
        Point b = new Point(3.0, 4.0);
        assertEquals(3.0, a.distance(b), MARGIN);
    }

    @Test
    public void DistanceBetweenSameYShouldBeDifferenceBetweenX() {
        Point a = new Point(1.0, 4.0);
        Point b = new Point(3.0, 4.0);
        assertEquals(2.0, a.distance(b), MARGIN);
    }
    @Test
    public void DistanceBetweenDifferentXAndDifferentY() {
        Point a = new Point(1.0, 4.0);
        Point b = new Point(3.0, 1.0);
        assertEquals(Math.sqrt(5.0), a.distance(b), MARGIN);
    }
}
