package workspace;

import io.InputReader;
import io.OutputWriter;

public class POJ2318 {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    boolean first = true;
    while (true) {
      int n = in.nextInt();
      if (n == 0) break;

      if (!first) out.println();
      first = false;

      int m = in.nextInt();
      int x1 = in.nextInt(), y1 = in.nextInt(), x2 = in.nextInt(), y2 = in.nextInt();

      int[] ux = new int[n + 1];
      int[] lx = new int[n + 1];
      ux[0] = x1;
      lx[0] = x1;
      for (int i = 1; i <= n; i++) {
        ux[i] = in.nextInt();
        lx[i] = in.nextInt();
      }
      int[] cnt = new int[n + 1];
      for (int i = 0; i < m; i++) {
        int x = in.nextInt();
        int y = in.nextInt();

        int left = 0, right = n;
        while (left < right) {
          int middle = (left + right + 1) / 2;

          int dot = (y - y2) * (ux[middle] - lx[middle]) - (x - lx[middle]) * (y1 - y2);
          if (dot < 0) {
            left = middle;
          } else {
            right = middle - 1;
          }
        }
        cnt[left]++;
      }
      for (int i = 0; i <= n; i++) {
        out.printf("%d: %d\n", i, cnt[i]);
      }
    }
  }
}
