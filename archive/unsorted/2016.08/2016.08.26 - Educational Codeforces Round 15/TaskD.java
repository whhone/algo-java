package workspace;

import weapon.io.InputReader;
import weapon.io.OutputWriter;

public class TaskD {

  long d, k, a, b, t;

  long f(long x) {
    long dd = d;
    long ret = x * t;

    if (k * (x + 1) <= dd) {
      ret += k * (x + 1) * a;
      dd -= k * (x + 1);
    } else {
      ret += dd * a;
      dd -= dd;
    }

    return ret + dd * b;
  }

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    d = in.nextLong();
    k = in.nextLong();
    a = in.nextLong();
    b = in.nextLong();
    t = in.nextLong();

    long l = 0, r = (d - 1) / k + 1;
    while (l < r) {

      long m1 = (l + r) / 3;
      long m2 = (l + r) * 2 / 3;

//      out.printf("%d %d %d %d\n", l, m1, m2, r);
 //     out.printf("%d %d %d %d\n", f(l), f(m1), f(m2), f(r));
      if (m1 == m2) {
        break;
      }

      if (f(m1) > f(m2)) {
        l = m1;
      } else {
        r = m2;
      }
    }

    out.println(Math.min(Math.min(f(l), f(r)), f((l + r)/2)));
  }
}
