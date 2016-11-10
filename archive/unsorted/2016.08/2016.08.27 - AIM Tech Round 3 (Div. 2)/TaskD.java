package workspace;

import weapon.io.InputReader;
import weapon.io.OutputWriter;

public class TaskD {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int a = in.nextInt();
    int b = in.nextInt();
    int c = in.nextInt();
    int d = in.nextInt();

    long c0 = -1, c1 = -1;

    for (long i = 0; i <= 50000; i++) {
      if (i * (i + 1) / 2 == a) {
        c0 = i;
      }
      if (i * (i + 1) / 2 == d) {
        c1 = i;
      }
    }

    if (c0 == -1 || c1 == -1) {
      out.println("Impossible");
      return;
    }

    StringBuilder sb = new StringBuilder();
    while (b > 0 || c > 0) {
      if (b > c) {
        sb.append("0");
        b -= c1;
        c0--;
      }
    }
  }
}
