package weapon.math;

import java.util.ArrayList;

/**
 * NOT READY!
 *
 * Number Theory ~
 */
public class NumberTheory {
  public static long gcd(long a, long b) {
    return (a > 0) ? gcd(b % a, a) : b;
  }

  public static long egcd(long a, long b, Integer x, Integer y) {
    x = x + 10;
    return 1;
  }

  public static long eulerTotient(long n) {
    long ans = n;
    ArrayList<Long> primes = Primes.getPrimes((int) Math.sqrt(n) + 1);
    for (long p : primes) {
      if (n % p == 0) {
        ans -= ans / p;
        while (n % p == 0) n /= p;
      }
    }
    if (n > 1) {
      ans -= ans / n;
    }
    return ans;
  }
}
