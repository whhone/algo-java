package workspace;

import weapon.io.InputReader;
import weapon.io.OutputWriter;

public class TaskC {

  int sgf(int k) {
    if (k <= 3) return k & 1;
    if (k == 4) return 2;
    if (k % 2 == 1) return 0;
    else {
      int f = sgf(k / 2);
      if (f <= 1) return f + 1;
      else return 1;
    }
  }

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int k = in.nextInt();
    int[] a = in.nextIntArray(n);
    int x = 0;
    if (k % 2 == 0) {
      for (int i = 0; i < n; ++i) {
        if (a[i] <= 2) {
          x ^= a[i];
        } else {
          x ^= ((a[i] + 1) & 1);
        }
      }
    } else {
      for (int i = 0; i < n; ++i) {
        x ^= sgf(a[i]);
      }
    }
    if (x != 0) {
      out.println("Kevin");
    } else {
      out.println("Nicky");
    }
  }
}
