package workspace;

import utils.InputReader;
import utils.OutputWriter;
import weapon.datastructures.MultiSet;

public class TaskB {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();

    MultiSet<Integer> msp = new MultiSet<Integer>();
    MultiSet<Integer> msd = new MultiSet<Integer>();
    for (int i = 0; i < n; i++) {
      int x = in.nextInt();
      int y = in.nextInt();
      msp.add(x + y);
      msd.add(x - y);
    }

    long ans = 0;
    for (int k : msp.elementSet()) {
      long count = msp.count(k);
      ans += count * (count - 1) / 2;
    }
    for (int k : msd.elementSet()) {
      long count = msd.count(k);
      ans += count * (count - 1) / 2;
    }
    out.println(ans);
  }
}
