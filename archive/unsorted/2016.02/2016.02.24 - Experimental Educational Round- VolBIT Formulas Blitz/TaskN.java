package workspace;

import weapon.io.InputReader;
import weapon.io.OutputWriter;

public class TaskN {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int a = in.nextInt(), b = in.nextInt(), c = in.nextInt();
    double t = Math.sqrt(b * b - 4 * a * c);
    double ans1 = (-b + t) / 2 / a;
    double ans2 = (-b - t) / 2 / a;
    if (ans1 > ans2) {
      out.println(ans1);
      out.println(ans2);
    } else {
      out.println(ans2);
      out.println(ans1);
    }
  }
}
