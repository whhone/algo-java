package workspace;

import weapon.datastructures.MultiSet;
import io.InputReader;
import io.OutputWriter;
import weapon.Modular;

public class TaskD {

  long MOD = 1000000007;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int m = in.nextInt();
    int[] a = in.nextIntArray(m);
    MultiSet<Integer> ms = new MultiSet<Integer>();

    for (int i = 0; i < m; ++i) {
      ms.add(a[i]);
    }

    long[] l = new long[m];
    long[] r = new long[m];

    Integer[] ps = new Integer[ms.size()];
    ps = ms.elementSet().toArray(ps);
    for (int i = 0; i < ps.length; ++i) {
      long count = ms.count(ps[i]);

      if (i == 0) {
        l[i] = (count + 1);
      } else {
        l[i] = (l[i - 1] * (count + 1)) % (MOD - 1);
      }
    }

    for (int i = ps.length - 1; i >= 0; --i) {
      long count = ms.count(ps[i]);

      if (i == ps.length - 1) {
        r[i] = (count + 1);
      } else {
        r[i] = (r[i + 1] * (count + 1)) % (MOD - 1);
      }
    }

    long ans = 1;
    for (int i = 0; i < ps.length; ++i) {
      int p = ps[i];
      long count = ms.count(p);
      long tmp = 1;
      if (i > 0) tmp *= l[i - 1];
      if (i < ps.length - 1) tmp *= r[i + 1];
      tmp %= (MOD - 1);
      long counts = (count * (count + 1) / 2) % (MOD - 1);
      ans = (ans * Modular.on(MOD).power(p, (counts * tmp) % (MOD - 1))) % MOD;
    }
    out.println(ans);
  }

}

