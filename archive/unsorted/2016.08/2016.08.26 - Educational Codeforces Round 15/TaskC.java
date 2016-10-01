package workspace;

import weapon.io.InputReader;
import weapon.io.OutputWriter;

public class TaskC {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int N = in.nextInt(), M = in.nextInt();
    int[] a = in.nextIntArray(N);
    int[] b = in.nextIntArray(M);

    long l = 0, r = 2000000000;

    while (l < r) {
      long m = l + (r - l) / 2;

      int aa = 0, bb = 0;
      while (aa < N && bb < M) {
        if (a[aa] < b[bb] - m) {
          break;
        } else {
          while (aa < N && a[aa] <= b[bb] + m) {
            ++aa;
          }
        }
        ++bb;
      }

      if (aa == N) {
        r = m;
      } else {
        l = m + 1;
      }
    }

    out.println(r);
  }
}
