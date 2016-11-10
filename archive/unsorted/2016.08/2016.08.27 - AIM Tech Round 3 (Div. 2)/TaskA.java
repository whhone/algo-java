package workspace;

import weapon.io.InputReader;
import weapon.io.OutputWriter;

public class TaskA {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int b = in.nextInt();
    int d = in.nextInt();

    int count = 0;
    int waste = 0;


    for (int i = 0; i < n; i++) {
      int a = in.nextInt();
      if (a <= b) {
        waste += a;
      }
      if (waste > d) {
        ++count;
        waste = 0;
      }
    }

    out.println(count);
  }
}
