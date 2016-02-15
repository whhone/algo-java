package workspace;

import weapon.io.InputReader;
import weapon.io.OutputWriter;

public class POJ1106 {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    while (true) {
      int X = in.nextInt(), Y = in.nextInt();
      double r = in.nextDouble();
      if (r < 0) break;
      double rr = r * r;

      int n = in.nextInt();
      int[] x = new int[n];
      int[] y = new int[n];
      double[] d = new double[n];
      for (int i = 0; i < n; i++) {
        x[i] = in.nextInt() - X;
        y[i] = in.nextInt() - Y;
        d[i] = x[i] * x[i] + y[i] * y[i];
      }

      int ans = 0;
      for (int i = 0; i < n; i++) {
        if (d[i] > rr) continue;
        int cntp = 0, cntn = 0;
        for (int j = 0; j < n; j++) {
          if (d[j] > rr) continue;
          int dot = x[i] * y[j] - x[j] * y[i];
          if (dot >= 0) {
            ++cntp;
          } else if (dot <= 0) {
            ++cntn;
          }
        }
        ans = Math.max(ans, Math.max(cntp, cntn));
      }
      out.println(ans);
    }
  }
}
