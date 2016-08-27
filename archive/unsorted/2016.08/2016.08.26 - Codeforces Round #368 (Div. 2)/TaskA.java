package workspace;

import weapon.io.InputReader;
import weapon.io.OutputWriter;

public class TaskA {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int N = in.nextInt();
    int M = in.nextInt();
    boolean bw = true;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        String s = in.next();
        if ("CMY".contains(s)) {
          bw = false;
        }
      }
    }
    out.println(bw ? "#Black&White" : "#Color");
  }
}
