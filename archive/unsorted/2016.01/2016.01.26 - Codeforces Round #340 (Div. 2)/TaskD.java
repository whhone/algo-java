package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class TaskD {
  public void solve(int testNumber, Scanner in, PrintWriter out) {
    int[] x = new int[3];
    int[] y = new int[3];
    for (int i = 0; i < 3; ++i) {
      x[i] = in.nextInt();
      y[i] = in.nextInt();
    }

    if ((x[0] == x[1] && x[1] == x[2]) || (y[0] == y[1] && y[1] == y[2])) {
      out.println("1");
      return;
    }

    for (int i = 0; i < 3; ++i) {
      for (int j = 0; j < 3; ++j) {
        if (i == j) continue;
        int k = 3 - i - j;

        if (x[i] == x[j]) {
          if ((y[k] >= y[i] && y[k] >= y[j]) || (y[k] <= y[i] && y[k] <= y[j])) {
            out.println("2");
            return;
          }
        }
        if (y[i] == y[j]) {
          if ((x[k] >= x[i] && x[k] >= x[j]) || (x[k] <= x[i] && x[k] <= x[j])) {
            out.println("2");
            return;
          }
        }
      }
    }

    out.println("3");
  }
}
