package workspace;

import utils.InputReader;
import utils.OutputWriter;
import weapon.math.Nim;

public class POJ3533 {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    while (in.hasNext()) {
      int N = in.nextInt();
      int xor = 0;
      for (int i = 0; i < N; i++) {
        xor ^= Nim.mul(in.nextInt(), Nim.mul(in.nextInt(), in.nextInt()));
      }
      out.println((xor == 0) ? "Yes" : "No");
    }
  }
}
