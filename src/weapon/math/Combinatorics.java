package weapon.math;

public class Combinatorics {

  /**
   * Returns nCr.
   * @param n
   * @param r
   * @return
   */
  public static long C(long n, long r) {
    long ans = 1;
    for (int i = 1; i <= r; i++) {
      ans = ans * (n - i + 1);
      ans = ans / i;
    }
    return ans;
  }

  /**
   * Returns nPr.
   * @param n
   * @param r
   * @return
   */
  public static long P(long n, long r) {
    long ans = 1;
    for (int i = 1; i <= n; i++) {
      ans = ans * (n - i + 1);
      if (i <= r) {
        ans = ans / i;
      } else {
        ans = ans / (i - r);
      }
    }
    return ans;
  }
}
