package workspace;

import weapon.io.InputReader;
import weapon.io.OutputWriter;
import weapon.geom.*;

import java.util.List;

public class TaskC {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    Circle a = new Circle(in.nextInt(), in.nextInt(), in.nextInt());
    Circle b = new Circle(in.nextInt(), in.nextInt(), in.nextInt());
    Circle c = new Circle(in.nextInt(), in.nextInt(), in.nextInt());

    if (a.radius == b.radius) {
      Point mid = new Point((a.center.x + b.center.x) / 2, (a.center.y + b.center.y) / 2);
      Line ab = new Line(a.center, b.center);
      Line mab = new Line(mid, 1 / ab.getSlope());
    }

    Point ans = null;

    double low = 1;
    double high = 2e3;
    for (int i = 0; i < 250000; i++) {
      System.out.printf("%f %f\n", low, high);

      double middle = (high + low) / 2;
      Circle aa = a.scale(middle);
      Circle bb = b.scale(middle);
      Circle cc = c.scale(middle);


      List<Point> intersections = aa.intersect(bb);

      if (intersections.size() == 0) {
        low = middle;
      } else if (intersections.size() == 1) {

      } else if (intersections.size() == 2) {

      }

      boolean updated = false;
      for (Point point : intersections) {

        out.printf("%s %s %f\n", point, cc.center, cc.radius);
        if (point.distance(cc.center) <= cc.radius) {
          high = middle;
          updated = true;
          ans = point;
          break;
        }
      }
      if (!updated) {
        low = middle;
      }
    }
    out.println(low);
    if (ans != null) {
      out.println("have ans");
      Circle cc = c.scale(low);
      if (Math.abs(cc.center.distance(ans) - cc.radius) < GeomConfig.getEps()) {
        out.printf("%.5f %.5f\n", ans.x + GeomConfig.getEps(), ans.y + GeomConfig.getEps());
      }
    }
  }
}
