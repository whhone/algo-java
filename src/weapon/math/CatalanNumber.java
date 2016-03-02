package weapon.math;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;

/**
 * The Catalan numbers are a set of numbers that arise in tree enumeration problems of the type.
 * See http://mathworld.wolfram.com/CatalanNumber.html
 */
public class CatalanNumber {

  private static ArrayList<BigInteger> cached =
      new ArrayList<BigInteger>(Collections.singletonList(BigInteger.ONE));

  public static BigInteger get(int k) {
    if (k < cached.size() - 1) {
      return cached.get(k);
    }
    for (int i = cached.size(); i <= k; i++) {
      cached.add(cached.get(i - 1)
          .multiply(BigInteger.valueOf(4 * (i + 1) - 6))
          .divide(BigInteger.valueOf(i + 1)));
    }
    return cached.get(k);
  }
}
