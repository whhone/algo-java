package workspace;

import utils.InputReader;
import utils.OutputWriter;

import java.util.Arrays;

public class TaskD {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    long x = in.nextInt();
    long y = in.nextInt();

    int[] d = new int[n + 1];

    for (int i = 0; i < n - 1; i++) {
      int u = in.nextInt();
      int v = in.nextInt();
      d[u]++;
      d[v]++;
    }

    if (x < y) {
      int leaf = 0;
      for (int i = 1; i <= n; i++) {
        if (d[i] == 1) ++leaf;
      }
      out.println((leaf - 2) * y + (n - 1 - leaf + 2) * x);
    } else {
      long sad = 0;
      Arrays.sort(d, 1, n + 1);

      for (int i = n; i >= 2; --i) {
        if (d[i] == i - 1) {
          ++sad;
          break;
        }
      }
//      for (int index = 1; index <= n ; index++) {
//        out.printf("check %d %d\n", index, d[index]);
//      }
//      out.println(sad);
      out.println(x * sad + y * (n - 1 - sad));
    }
  }
}
