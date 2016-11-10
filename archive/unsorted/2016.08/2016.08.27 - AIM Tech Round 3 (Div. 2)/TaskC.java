package workspace;

import weapon.io.InputReader;
import weapon.io.OutputWriter;

public class TaskC {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    StringBuilder s = new StringBuilder(in.next());
    int i = 0;
    boolean started = false;

    while (i < s.length()) {
      if (s.charAt(i) == 'a') {
        if (started) {
          break;
        }
      } else {
        started = true;
        s.setCharAt(i, (char) (s.charAt(i) - 1));
      }
      ++i;
    }
    if (!started) {
      s.setCharAt(s.length() - 1, 'z');
    }
    out.println(s.toString());
  }
}
