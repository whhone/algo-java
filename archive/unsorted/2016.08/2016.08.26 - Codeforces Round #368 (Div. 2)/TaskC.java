package workspace;

import weapon.io.InputReader;
import weapon.io.OutputWriter;

public class TaskC {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    long n = in.nextLong();
    long two = 1;

    while (n % 2 == 0) {
      n /= 2;
      two *= 2;
    }

    if (n == 1 && two <= 2) {
      out.println("-1");
      return;
    }

    if (n == 1) {
      out.printf("%d %d\n", two / 4 * 3, two / 4 * 5);
    } else {
      out.printf("%d %d\n", (n * n / 2) * two, (n * n / 2 + 1) * two);
    }
  }
}
