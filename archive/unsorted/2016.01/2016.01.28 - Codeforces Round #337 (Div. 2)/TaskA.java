package workspace;

import utils.InputReader;
import utils.OutputWriter;

public class TaskA {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    if (n % 2 == 0) {
      int nn = n / 2;
      out.println((nn - 1) / 2);
    } else {
      out.println(0);
    }
  }
}
