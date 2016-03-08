package weapon.math;

import java.math.BigInteger;

public class Combinatorics {

  /**
   * Computes nCr.
   */
  public static BigInteger C(long n, long r) {
    BigInteger ans = BigInteger.ONE;
    for (int i = 1; i <= r; i++) {
      ans = ans.multiply(BigInteger.valueOf(n - i + 1)).divide(BigInteger.valueOf(i));
    }
    return ans;
  }

  /**
   * Computes nPr.
   */
  public static BigInteger P(long n, long r) {
    BigInteger ans = BigInteger.ONE;
    for (long i = 1; i <= r; i++) {
      ans = ans.multiply(BigInteger.valueOf(n - i + 1));
    }
    return ans;
  }
}
