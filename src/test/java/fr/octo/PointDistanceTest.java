package fr.octo;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PointDistanceTest {

    private static final double MARGIN = 0.0001;

    @Test
    public void DistanceBetweenSamePointsShouldBeZero() {
        Point a = new Point(3.0, 2.0);
        Point b = new Point(3.0, 2.0);

        assertEquals(0.0, a.distance(b), MARGIN);
    }

    @Test
    public void DistanceBewteenTwoPointsHavingSameXCoodShouldBe() {
        Point a = new Point(3.0, 5.0);
        Point b = new Point(3.0, 3.0);

        assertEquals(2.0, a.distance(b), MARGIN);
    }
}
