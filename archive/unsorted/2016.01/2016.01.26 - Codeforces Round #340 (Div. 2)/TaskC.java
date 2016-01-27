package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class TaskC {
  public void solve(int testNumber, Scanner in, PrintWriter out) {
    int N = in.nextInt();
    long[] x = new long[2];
    long[] y = new long[2];
    long[] xx = new long[N];
    long[] yy = new long[N];

    x[0] = in.nextLong();
    y[0] = in.nextLong();
    x[1] = in.nextLong();
    y[1] = in.nextLong();

    for (int i = 0; i < N; ++i) {
      xx[i] = in.nextLong();
      yy[i] = in.nextLong();
    }
    long ans = 0;
    for (int i = -1; i < N; ++i) {
      long r = 0;
      if (i >= 0) {
        r = (x[0] - xx[i]) * (x[0] - xx[i]) + (y[0] - yy[i]) * (y[0] - yy[i]);
      }
      long R = 0;
      for (int j = 0; j < N; ++j) {
        long rr = (x[0] - xx[j]) * (x[0] - xx[j]) + (y[0] - yy[j]) * (y[0] - yy[j]);
        if (rr > r) {
          R = Math.max(R, (x[1] - xx[j]) * (x[1] - xx[j]) + (y[1] - yy[j]) * (y[1] - yy[j]));
        }
      }
      if (i == -1) ans = r + R;
      else ans = Math.min(ans, r + R);

    }
    out.println(ans);
  }
}
