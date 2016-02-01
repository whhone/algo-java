package workspace;

import utils.InputReader;
import utils.OutputWriter;

public class TaskC {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    int s = in.nextInt();
    long nn = ((n - 1) % s + 1);
    long mm = ((m - 1) % s + 1);
    long nnn = ((n - 1) / s + 1);
    long mmm = ((m - 1) / s + 1);
    out.println(nn * mm * nnn * mmm);
  }
}
