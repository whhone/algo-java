package workspace;

import io.InputReader;
import io.OutputWriter;

public class ZOJ1060 {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    while (in.hasNext()) {
      int a = in.nextInt();
      out.println((a % 4 == 2) ? "yes" : "no");
    }
  }
}
