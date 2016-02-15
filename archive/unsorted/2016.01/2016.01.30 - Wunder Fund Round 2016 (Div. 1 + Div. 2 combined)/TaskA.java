package workspace;

import weapon.io.InputReader;
import weapon.io.OutputWriter;

public class TaskA {

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int two = 21;
    boolean first = true;
    for (int i = (1<<20); i >= 1; i /= 2) {
      if ((n & i) > 0) {
        if (!first) out.print(" ");
        first = false;
        out.print(two);
      }
      two--;
    }
  }
}
