package workspace;



import weapon.io.InputReader;
import weapon.io.OutputWriter;
import weapon.math.Primes;

import java.util.ArrayList;

public class TaskK {
  long ans = 0;

  void doit(long product, ArrayList<Long> primes, int pos, int count) {
    if (pos >= primes.size()) {
      if (count % 2 == 0) {
        ans += product;
      } else {
        ans -= product;
      }
    } else {
      doit(product / primes.get(pos), primes, pos + 1, count + 1);
      doit(product, primes, pos + 1, count);
    }
  }

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    long n = in.nextLong();
    ArrayList<Long> p = Primes.getPrimes(10);
    doit(n, p, 0, 0);
    out.println(ans);
  }
}
