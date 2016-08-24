package weapon.math;

import java.util.ArrayList;

public class Primes {

  /**
   * Returns all primes less then or equal to n.
   */
  public static ArrayList<Long> getPrimesLessThanOrEqual(long n) {
    boolean[] visited = new boolean[(int)n + 1];
    ArrayList<Long> primes = new ArrayList<Long>();
    for (int i = 2; i <= n; ++i) {
      if (!visited[i]) {
        primes.add((long)i);
        for (int j = i + i; j <= n; j += i) {
          visited[j] = true;
        }
      }
    }
    return primes;
  }

  /**
   * Returns the smallest prime divisor of n for n >= 2.
   */
  public static long smallestPrimeDivisor(long n) {
    long squareRoot = (long) Math.sqrt(n + 0.5);
    for (long i = 2; i <= squareRoot; i++) {
      if (n % i == 0) {
        return i;
      }
    }
    return n;
  }

  public static boolean isPrime(long n) {
    if (n <= 1) {
      return false;
    } else {
      return n == smallestPrimeDivisor(n);
    }
  }
}
