package fr.octo;

public class Point {
	private final double x;
	private final double y;

	public Point(double x, double y) {

		this.x = x;
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double distance(Point pointB){
		return Math.sqrt(Math.pow(x- pointB.x, 2) + Math.pow(y - pointB.y, 2));
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Point point = (Point) o;

		if (Double.compare(point.x, x) != 0) return false;
		return Double.compare(point.y, y) == 0;
	}


}
