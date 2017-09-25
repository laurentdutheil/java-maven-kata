package fr.octo;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DistancePointTest {

	private static final double MARGIN = 0.0001;


	@Test
	public void DistanceBetweenSamePointsShouldBeZero() {
		Point pointA = new Point(3.0,2.0);
		Point pointB = new Point(3.0,2.0);
		assertEquals(0, pointA.distance(pointB), MARGIN );
		
	}

	@Test
	public void DistanceBetweenSameX() {
		Point pointA = new Point(4.0, 6.0);
		Point pointB = new Point(4.0, 2.0);
		assertEquals(4, pointA.distance(pointB), MARGIN);
	}

	@Test
	public void DistanceBetweenSameY() {
		Point pointA = new Point(8.0, 2.0);
		Point pointB = new Point(5.0, 2.0);
		assertEquals(3, pointA.distance(pointB), MARGIN);
	}

	@Test
	public void DistanceBetweenTwoPoints() {
		Point pointA = new Point(8.0, 0.0);
		Point pointB = new Point(5.0, 4.0);
		assertEquals(5.0, pointA.distance(pointB), MARGIN);
	}

}
