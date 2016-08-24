package workspace;

import weapon.io.InputReader;
import weapon.io.OutputWriter;

public class TaskA {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    String s = in.next();
    int x = s.charAt(0) - 'a';
    int y = s.charAt(1) - '1';

    int count = 0;

    for (int dx = -1; dx <= 1; dx++) {
      for (int dy = -1; dy <= 1; dy++) {
        int xx = x + dx;
        int yy = y + dy;
        if (xx >= 0 && xx < 8 && yy >= 0 && yy < 8) {
          ++count;
        }
      }
    }

    out.println(count - 1);
  }
}
