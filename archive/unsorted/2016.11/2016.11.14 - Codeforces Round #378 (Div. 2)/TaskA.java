package workspace;

import weapon.io.InputReader;
import weapon.io.OutputWriter;

public class TaskA {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    String s = in.next();
    int ans = 0;
    int step = 0;
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      step++;
      if (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U' || c == 'Y') {
        ans = Math.max(ans, step);
        step = 0;
      }
    }

    ++step;
    ans = Math.max(ans, step);
    out.println(ans);
  }
}
