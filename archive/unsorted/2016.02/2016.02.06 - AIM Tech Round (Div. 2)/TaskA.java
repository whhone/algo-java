package workspace;

import io.InputReader;
import io.OutputWriter;

public class TaskA {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int d = in.nextInt(), L = in.nextInt(), v1 = in.nextInt(), v2 = in.nextInt();
    out.println((double)(L - d) / (v1 + v2));
  }
}
