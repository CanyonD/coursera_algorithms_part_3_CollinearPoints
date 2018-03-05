import edu.princeton.cs.algs4.StdDraw;

import java.util.Comparator;

public class Point implements Comparable<Point> {
    private final int x;     // x-coordinate of this point
    private final int y;     // y-coordinate of this point

    public Point(int x, int y)                         // constructs the point (x, y)
    {
        this.x = x;
        this.y = y;
    }

    public   void draw()                               // draws this point
    {
        StdDraw.point(x, y);
    }
    public   void drawTo(Point that)                   // draws the line segment from this point to that point
    {
        StdDraw.line(this.x, this.y, that.x, that.y);
    }

    public String toString()                           // string representation
    {
        return "(" + x + ", " + y + ")";
    }
    public               int compareTo(Point that)     // compare two points by y-coordinates, breaking ties by x-coordinates
    {
        if (this.y < that.y) return -1;
        if (this.y == that.y) {
            if (this.x < that.x) return -1;
            if (this.x == that.x) return 0;
        }
        return 1;
    }
    public            double slopeTo(Point that)       // the slope between this point and that point
    {
        if (this.x == that.x) {
            if (this.y == that.y) return Double.NEGATIVE_INFINITY;
            else return Double.POSITIVE_INFINITY;
        }
        if (this.y == that.y) return 0;
        return (double) (this.y - that.y) / (this.x - that.x);
    }
    public Comparator<Point> slopeOrder()              // compare two points by slopes they make with this point
    {
        return new SlopeOrder();
    }

    private class SlopeOrder implements Comparator<Point> {

        @Override
        public int compare(Point o1, Point o2) {
            double d1 = slopeTo(o1);
            double d2 = slopeTo(o2);
            if (d1 < d2) return -1;
            if (d1 == d2) return 0;
            return 1;

        }
    }


}