package weapon.math;

/**
 * Given a and b. Solves a * x + b * y = gcd where gcd > 0.
 *
 * Notes that there could be multiple solution for (x, y). EGCD will returns any one of it.
 */
public class EGCD {

  final public long a, b, x, y, gcd;

  public EGCD(long a, long b) {
    this.a = a;
    this.b = b;
    long[] ans = egcd(a, b);
    this.gcd = ans[0];
    this.x = ans[1];
    this.y = ans[2];
  }

  private long[] egcd(long a, long b) {
    if (b == 0) {
      long gcd = Math.abs(a);
      return new long[]{gcd, a / gcd, 0};
    } else {
      long[] ans = egcd(b, a % b);
      ans[1] -= a / b * ans[2];
      long tmp = ans[1];
      ans[1] = ans[2];
      ans[2] = tmp;
      return ans;
    }
  }
}
