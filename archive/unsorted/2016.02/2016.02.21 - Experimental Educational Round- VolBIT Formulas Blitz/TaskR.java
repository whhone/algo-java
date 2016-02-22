package workspace;

import weapon.io.InputReader;
import weapon.io.OutputWriter;

public class TaskR {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    long n = in.nextLong();
    out.println((n % 2 == 0) ? 2 : 1);
  }
}
