package workspace;

import weapon.io.InputReader;
import weapon.io.OutputWriter;
import weapon.math.CatalanNumber;

public class POJ2084 {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    while (true) {
      int n = in.nextInt();
      if (n == -1) {
        break;
      }
      out.println(CatalanNumber.get(n));
    }
  }
}
