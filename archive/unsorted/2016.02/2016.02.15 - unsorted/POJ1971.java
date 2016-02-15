package workspace;

import weapon.datastructures.MultiSet;
import weapon.geom.Point;
import weapon.io.InputReader;
import weapon.io.OutputWriter;

public class POJ1971 {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int T = in.nextInt();

    for (int tt = 0; tt < T; tt++) {
      int N = in.nextInt();
      long[] x = new long[N];
      long[] y = new long[N];
      for (int i = 0; i < N; i++) {
        x[i] = in.nextInt();
        y[i] = in.nextInt();
      }
      MultiSet<Long> ms = new MultiSet<Long>();
      for (int i = 0; i < N; i++) {
        for (int j = i + 1; j < N; j++) {
          long key = (x[i] + x[j] + 2000000000) * 4000000001L + (y[i] + y[j] + 2000000000);
          ms.add(key);
        }
      }
      long ans = 0;
      for (long key : ms.elementSet()) {
        long count = ms.count(key);
        ans += count * (count - 1) / 2;
      }
      out.println(ans);
    }
  }
}
