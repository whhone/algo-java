package workspace;

import weapon.io.InputReader;
import weapon.io.OutputWriter;
import weapon.datastructures.MultiSet;

public class POJ1840 {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int[] a = in.nextIntArray(5);

    MultiSet<Integer> ms1 = new MultiSet<Integer>();
    for (int a1 = -50; a1 <= 50; a1++) {
      for (int a2 = -50; a2 <= 50 ; a2++) {
        if (a1 != 0 && a2 != 0) {
          ms1.add(a1 * a1 * a1 * a[0] + a2 * a2 * a2 * a[1]);
        }
      }
    }

    MultiSet<Integer> ms2 = new MultiSet<Integer>();
    for (int a1 = -50; a1 <= 50; a1++) {
      for (int a2 = -50; a2 <= 50 ; a2++) {
        for (int a3 = -50; a3 <= 50; a3++) {
          if (a1 != 0 && a2 != 0 && a3 != 0) {
            ms2.add(a1 * a1 * a1 * a[2] + a2 * a2 * a2 * a[3] + a3 * a3 * a3 * a[4]);
          }
        }
      }
    }
    long ans = 0;
    for (Integer e1 : ms1.elementSet()) {
      int c2 = ms2.count(-e1);
      if (c2 > 0) {
        int c1 = ms1.count(e1);
        ans += c1 * c2;
      }
    }

    out.println(ans);
  }
}
