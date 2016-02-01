package workspace;

import utils.InputReader;
import utils.OutputWriter;
import weapon.geom.GridPoint;

import java.util.Arrays;

public class TaskC {

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    GridPoint[] p = new GridPoint[n];
    for (int i = 0; i < n; i++) {
      p[i] = new GridPoint(in.nextInt(), in.nextInt()).setIndex(i+1);
    }
    Arrays.sort(p);
    for (int i = 2; i < n; ++i) {
      if (GridPoint.isCollinear(p[0], p[1], p[i])) continue;
      out.printf("%d %d %d\n", p[0].index, p[1].index, p[i].index);
      return;
    }
  }
}
