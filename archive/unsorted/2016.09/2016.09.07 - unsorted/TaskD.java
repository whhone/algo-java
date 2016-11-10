package workspace;

import weapon.io.InputReader;
import weapon.io.OutputWriter;

public class TaskD {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int T = in.nextInt();
    while (T-- > 0) {
      int N = in.nextInt();
      int ans1 = (N + 2) / 3;
      if (ans1 % 2 == 0) ++ans1;
      int NN = N;
      if (NN % 2 == 0) --NN;
      ans1 = (NN - ans1) / 2 + 1;
      int ans2 = (N + 1)/ 2;
      out.println(ans1 + ans2);
      // out.printf("%d %d\n", ans1, ans2);
    }
  }
}
