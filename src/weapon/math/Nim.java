package weapon.math;

/**
 * Nim. Grundy Number. Sprague-Grundy theorem.
 */
public final class Nim {

  public static int getGrundyNumber(int[] reachableValues) {
    boolean[] b = new boolean[reachableValues.length];
    for (int reachableValue : reachableValues) {
      if (reachableValue < b.length)
        b[reachableValue] = true;
    }
    int sg = 0;
    while (b[sg]) {
      ++sg;
    }
    return sg;
  }

  /**
   * Returns the nim-addition of x and y in O(1).
   */
  public static int add(int x, int y) {
    return x ^ y;
  }

  /**
   * Returns the nim-multiplication of x and y in O(log x * log y)
   */
  public static int mul(int x, int y) {
    if (x < y) {
      int tmp = x;
      x = y;
      y = tmp;
    }
    if (y == 0 || y == 1) {
      return x * y;
    }
    int fx = rightMostBitNumber(x);
    if (x == (x & -x)) {
      if (fx == (fx & -fx)) {
        if (x == y) {
          return x / 2 * 3;
        } else {
          return x * y;
        }
      } else {
        int t = fx;
        while (t != (t & -t)) --t;
        if (y == (1 << t)) {
          return mul(mul((1 << t), y), (x >> t));
        } else {
          return mul(mul((x >> t), y), (1 << t));
        }
      }
    } else {
      return (mul((x & -x), y) ^ mul(x - (x & -x), y));
    }
  }

  static int rightMostBitNumber(int k) {
    int r = 0;
    while (k > 0 && (k & 1) == 0) {
      k /= 2;
      ++r;
    }
    return r;
  }
}
