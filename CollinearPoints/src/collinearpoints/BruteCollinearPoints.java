/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collinearpoints;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author farukmoralioglu
 */
public class BruteCollinearPoints {

    private final Point[] points;
    int numberOfLineSegments;

    public BruteCollinearPoints(Point[] points) {
        this.points = points;
        numberOfLineSegments = 0;
    }

    public LineSegment[] segments() {
        //assuming the length of the points array will be 4
        List<LineSegment> segments = new ArrayList<>();
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                for (int k = j + 1; k < points.length; k++) {
                    for (int l = k + 1; l < points.length; l++) {
                        Point p = points[i], q = points[j], r = points[k], s = points[l];
                        if (p.slopeTo(q) == q.slopeTo(r) && q.slopeTo(r) == r.slopeTo(s)) {
                            numberOfLineSegments++;
                            segments.add(new LineSegment(p, s));
                        }
                    }
                }
            }
        }
        LineSegment[] segs = new LineSegment[segments.size()];
        segs = segments.toArray(segs);
        return segs;
    }
    
    public int numberOfSegments(){
        return numberOfLineSegments;
    }
}
