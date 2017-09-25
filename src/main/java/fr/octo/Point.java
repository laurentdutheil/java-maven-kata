package fr.octo;

public class Point {
    private final double x;
    private final double y;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Point point = (Point) o;

        if (Double.compare(point.x, x) != 0) return false;
        return Double.compare(point.y, y) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(x);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(y);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double distance(Point b) {

            return Math.sqrt(Math.abs(this.getX()-b.getX()) + Math.abs(this.getY()-b.getY()));
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
