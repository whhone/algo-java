package weapon.math;

import java.util.ArrayList;
import java.util.Collections;

public class ChineseRemainderTheorem {

  private static long solveCoPrime2(long r1, long m1, long r2, long m2) {
    long mod = m1 * m2;
    EGCD egcd = new EGCD(m1, m2);

    long ans = 0;

    long t1 = (m2 * egcd.getY()) % mod;
    ans = (ans + (t1 * r1) % mod) % mod;

    long t2 = (m1 * egcd.getX()) % mod;
    ans = (ans + (t2 * r2) % mod) % mod;

    if (ans < 0) {
      ans = mod - (-ans % mod);
    }

    return ans;
  }

  // Assume gcd(mi, mj) = 1
  public static long solveCoPrime(long[] r, long[] m) {
    int N = m.length;
    for (int i = 1; i < N; i++) {
      long t = solveCoPrime2(r[0], m[0], r[i], m[i]);
      r[0] = t;
      m[0] *= m[i];
    }
    return r[0];
  }

  // Allow any modular. Returns -1 if there is no solutions.
  public static long solveMightNotCoPrime(long[] r, long[] m) {
    int N = m.length;

    if (N == 1) {
      return r[0];
    }

    long maxM = m[0];
    for (int i = 1; i < N; i++) {
      maxM = Math.max(maxM, m[i]);
    }

    ArrayList<Long> primes = Primes.getPrimes((long) (Math.sqrt(maxM * 1.0) + 1.5));
    ArrayList<Long> powers = new ArrayList<Long>(Collections.nCopies(primes.size(), 0L));
    ArrayList<Long> rmds = new ArrayList<Long>(Collections.nCopies(primes.size(), 0L));

    for (int i = 0; i < N; i++) {
      long mm = m[i];
      for (int j = 0; j < powers.size(); j++) {
        long p = primes.get(j);
        if (p > m[i]) {
          continue;
        }
        if (mm % p == 0) {
          long powerValue = 1;
          while (mm > 0 && mm % p == 0) {
            powerValue *= p;
            mm /= p;
          }
          if (powers.get(j) > 0) {
            if (!isValid(rmds.get(j), powers.get(j), r[i] % powerValue, powerValue)) {
              return -1;
            } else if (powerValue > powers.get(j)) {
              powers.set(j, powerValue);
              rmds.set(j, r[i] % powerValue);
            }
          } else {
            powers.set(j, powerValue);
            rmds.set(j, r[i] % powerValue);
          }
        }
      }
      if (mm > 1) {
        primes.add(mm);
        powers.add(mm);
        rmds.add(r[i] % mm);
      }
    }

    int count = 0;
    for (int i = 0; i < powers.size(); i++) {
      if (powers.get(i) != 0) {
        ++count;
      }
    }

    long[] rr = new long[count];
    long[] mm = new long[count];

    for (int i = 0; i < powers.size(); i++) {
      if (powers.get(i) != 0) {
        --count;
        rr[count] = rmds.get(i);
        mm[count] = powers.get(i);

        // System.out.printf("%d %d\n", rr[count], mm[count]);
      }
    }

    return solveCoPrime(rr, mm);
  }



  private static boolean isValid(long r1, long m1, long r2, long m2) {
    if (m1 == m2) {
      return r1 == r2;
    } else {
      return r1 % Math.min(m1, m2) == r2 % Math.min(m1, m2);
    }
  }
}
