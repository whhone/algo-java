package workspace;

import utils.InputReader;
import utils.OutputWriter;
import weapon.datastructures.MultiSet;

public class TaskB {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[][] a = in.nextIntArray2D(n, n);

    boolean done = false;
    for (int i = 0; i < n; i++) {
      MultiSet<Integer> ms = new MultiSet<Integer>();
      int v = 0;
      for (int j = 0; j < n; j++) {
        ms.add(a[i][j]);
      }
      for (int k : ms.elementSet()) {
        if (k + ms.count(k) == n) {
          v = k;
          if (v == n - 1 && done) v = n;
          if (v == n - 1) done = true;
        }
      }
      out.print(v);
      if (i == n-1) out.println();
      else out.print(' ');
    }
  }
}
