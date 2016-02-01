package workspace;

import utils.InputReader;
import utils.OutputWriter;
import weapon.geom.Line;
import weapon.geom.Point;
import weapon.geom.Segment;

public class TaskA {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    Point origin = new Point(in.nextInt(), in.nextInt());
    Point pre, first, p;
    pre = first = new Point(in.nextInt(), in.nextInt());

    double mn, mx;
    mn = mx = origin.distance(first);

    for (int i = 1; i < n; i++) {
      p = new Point(in.nextInt(), in.nextInt());
      double d2 = origin.distance(p);
      mx = Math.max(mx, d2);
      mn = Math.min(mn, d2);
      Segment segment = new Segment(pre, p);
      mn = Math.min(mn, origin.distance(segment));
      pre = p;
    }
    mn = Math.min(mn, origin.distance(new Segment(first, pre)));
    out.println((mx * mx - mn * mn) * Math.PI);
  }
}
