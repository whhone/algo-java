package workspace;

import weapon.io.InputReader;
import weapon.io.OutputWriter;

public class TaskD {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    long n = in.nextInt();
    out.println(3 * n * (n + 1) + 1);
  }
}
