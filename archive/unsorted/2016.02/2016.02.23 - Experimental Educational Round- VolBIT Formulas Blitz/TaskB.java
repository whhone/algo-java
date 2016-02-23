package workspace;

import weapon.io.InputReader;
import weapon.io.OutputWriter;

public class TaskB {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int t = in.nextInt();
    out.println(n * Math.pow(1.000000011, t));
  }
}
