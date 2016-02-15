package workspace;

import weapon.geom.Line;
import weapon.geom.Point;
import weapon.geom.Segment;
import weapon.io.InputReader;
import weapon.io.OutputWriter;

public class POJ1039 {

  double mx;

  boolean test(Point a, Point b, Point[] points) {
    Line line = new Line(a, b);
    for (int i = 0; i < points.length; i++) {
      Segment segment = new Segment(points[i], points[i].move(0, -1));
      Point intersection = segment.intersect(line);
      if (intersection == null) {
        if (i > 0) {
          segment = new Segment(points[i], points[i - 1]);
          intersection = segment.intersect(line);
          if (intersection != null) {
            mx = Math.max(mx, intersection.x);
          }

          segment = new Segment(points[i].move(0, -1), points[i - 1].move(0, -1));
          intersection = segment.intersect(line);
          if (intersection != null) {
            mx = Math.max(mx, intersection.x);
          }
        }
        return false;
      }
    }
    return true;
  }

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    while (true) {
      int n = in.nextInt();
      if (n == 0) return;
      Point[] p = new Point[n];
      for (int i = 0; i < n; i++) {
        p[i] = new Point(in.nextDouble(), in.nextDouble());
      }
      boolean ok = false;
      mx = p[0].x;
      for (int i = 0; !ok && i < n; i++) {
        for (int j = i + 1; !ok && j < n; j++) {
          if (test(p[i], p[j], p)) {
            ok = true;
          }

          if (test(p[i], p[j].move(0, -1), p)) {
            ok = true;
          }
          if (test(p[i].move(0, -1), p[j], p)) {
            ok = true;
          }
          if (test(p[i].move(0, -1), p[j].move(0, -1), p)) {
            ok = true;
          }
        }
      }
      if (ok) {
        out.println("Through all the pipe.");
      } else {
        out.printf("%.2f\n", mx);
      }
    }
  }
}
