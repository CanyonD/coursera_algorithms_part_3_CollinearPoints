public class LineSegment {
    private final Point p;   // one endpoint of this line segment
    private final Point q;   // the other endpoint of this line segment

    public LineSegment(Point p, Point q)        // constructs the line segment between points p and q
    {
        if (p == null || q == null) {
            throw new NullPointerException("argument is null");
        }
        this.p = p;
        this.q = q;
    }
    public   void draw()                        // draws this line segment
    {}
    public String toString()                    // string representation
    { return p + " -> " + q; }
}