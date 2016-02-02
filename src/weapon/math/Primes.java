package weapon.math;

import java.util.ArrayList;

public class Primes {

  /**
   * Returns all primes less then or equal to n.
   */
  public static ArrayList<Long> getPrimes(long n) {
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
}
