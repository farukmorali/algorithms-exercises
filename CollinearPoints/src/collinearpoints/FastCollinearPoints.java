/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collinearpoints;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author farukmoralioglu
 */
public class FastCollinearPoints {

    private final Point[] points;
    int numberOfLineSegments;

    public FastCollinearPoints(Point[] points) {
        this.points = points;
        numberOfLineSegments = 0;
    }

    public LineSegment[] segments() {
        List<LineSegment> segments = new ArrayList<>();

        for (int i = 0; i < points.length; i++) {
            Point[] copy = copyButCurrent(points, i);
            Arrays.sort(copy, points[i].slopeOrder());

            double slopeTopivot, previousSlopeToPivot = 0.0;
            int equalCount = 0;
            for (int j = 0; j < copy.length; j++) {
                if (j == 0) {
                    previousSlopeToPivot = copy[j].slopeTo(points[i]);
                } else {
                    slopeTopivot = copy[j].slopeTo(points[i]);
                    if (slopeTopivot == previousSlopeToPivot) {
                        equalCount++;
                    } else {
                        equalCount = 0;
                    }
                    previousSlopeToPivot = slopeTopivot;
                }
                if (equalCount == 3) {
                    segments.add(new LineSegment(points[i], copy[j]));
                    numberOfLineSegments++;
                    break;
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

    public Point[] copyButCurrent(Point[] current, int ind) {
        Point[] aux = new Point[current.length - 1];
        for (int i = 0; i < current.length; i++) {
            if (i != ind) {
                aux[i] = current[i];
            }
        }
        return aux;
    }
}
