package workspace;

import weapon.datastructures.ExtendedBIT;
import weapon.io.InputReader;
import weapon.io.OutputWriter;

public class POJ3468 {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int N = in.nextInt();
    int Q = in.nextInt();
    ExtendedBIT exbit = new ExtendedBIT(N);
    for (int i = 0; i < N; i++) {
      exbit.add(i, i, in.nextInt());
    }
    for (int q = 0; q < Q; q++) {
      String cmd = in.next();
      int a = in.nextInt() - 1;
      int b = in.nextInt() - 1;
      if (cmd.charAt(0) == 'Q') {
        out.println(exbit.query(a, b));
      } else {
        int c = in.nextInt();
        exbit.add(a, b, c);
      }
    }
  }
}
