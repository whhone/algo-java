package workspace;

import weapon.io.InputReader;
import weapon.io.OutputWriter;
import weapon.math.ChineseRemainderTheorem;

public class POJ1006 {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    long[] r = new long[3];
    long[] m = {23, 28, 33};
    int tc = 0;
    while (true) {
      r[0] = in.nextLong() % 23;
      r[1] = in.nextLong() % 28;
      r[2] = in.nextLong() % 33;
      long d = in.nextLong();
      if (d == -1) {
        return;
      }
      long ans = ChineseRemainderTheorem.solveCoPrime(r, m);
      while (ans <= d) ans += 21252;
      out.printf("Case %d: the next triple peak occurs in %d days.\n", ++tc, ans - d);
    }
  }
}
