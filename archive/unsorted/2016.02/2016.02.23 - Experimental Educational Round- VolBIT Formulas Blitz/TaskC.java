package workspace;

import weapon.io.InputReader;
import weapon.io.OutputWriter;

public class TaskC {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    long n = in.nextInt();
    long t = 2;
    long sum = 0;
    for (int i = 0; i < n; i++) {
      sum += t;
      t *= 2;
    }
    out.println(sum);
  }
}
