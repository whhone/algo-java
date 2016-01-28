package workspace;

import utils.InputReader;
import java.io.PrintWriter;

public class TaskB {
  public void solve(int testNumber, InputReader in, PrintWriter out) {
    int R = in.nextInt();
    int C = in.nextInt();
    int[][] a = new int[R][C];

    for (int r = 0; r < R; ++r) {
      for (int c = 0; c < C; ++c) {
        a[r][c] = in.nextInt();
      }
    }

    int ans = 0;

    for (int r = 0; r < R; ++r) {
      int mn = a[r][0];
      for (int c = 1; c < C; ++c) {
        mn = Math.min(mn, a[r][c]);
      }
      ans = Math.max(ans, mn);
    }

    out.println(ans);
  }
}
