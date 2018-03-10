import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FastCollinearPoints {
    private LineSegment[] ls;

    public FastCollinearPoints(Point[] points)     // finds all line segments containing 4 or more points
    {
        if (points == null) throw new IllegalArgumentException();
        int count = points.length;
        for (int i = 0; i < count; i++) {
            if (points[i] == null) throw new IllegalArgumentException();
            for (int j = i + 1; j < count; j++) {
                if (points[i].compareTo(points[j]) == 0)
                    throw new IllegalArgumentException();
            }
        }
        Point[] ps = points.clone();
        Arrays.sort(ps);
        List<LineSegment> list = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            Point[] p = ps.clone();
            Arrays.sort(p, p[i].slopeOrder());
            int j = 1;
            while (j < count - 2) {
                int k = j;
                double s1 = p[0].slopeTo(p[k++]);
                double s2;
                do {
                    if (k == count) {
                        k++;
                        break;
                    }
                    s2 = p[0].slopeTo(p[k++]);
                } while (s1 == s2);
                if (k - j < 4) {
                    j++;
                    continue;
                }
                int len = k-- - j;
                Point[] line = new Point[len];
                line[0] = p[0];

                for (int l = 1; l < len; l++) {
                    line[l] = p[j + l - 1];
                }
                Arrays.sort(line);
                // remove duplicate
                if (line[0] == p[0]) {
                    list.add(new LineSegment(line[0], line[len - 1]));
                }
                j = k;
            }
        }
        // transform to array
        ls = list.toArray(new LineSegment[list.size()]);
    }
    public           int numberOfSegments()        // the number of line segments
    {
        return ls.length;
    }
    public LineSegment[] segments()                // the line segments
    {
        return ls.clone();
    }
}