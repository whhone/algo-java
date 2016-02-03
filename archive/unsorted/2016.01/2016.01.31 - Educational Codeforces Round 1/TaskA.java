package workspace;

import io.InputReader;
import io.OutputWriter;

public class TaskA {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int t = in.nextInt();
    for (int i = 0; i < t; i++) {
      long n = in.nextInt();

      long sum = n * (n + 1) / 2;
      long two = 1;
      while (two <= n) {
        sum -= 2 * two;
        two *= 2;
      }
      out.println(sum);
    }
  }
}
