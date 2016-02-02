package weapon.math;

/**
 * Returns an long array {gcd, x, y} so that a * x + b * y = gcd.
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
      return new long[] {a, 1, 0};
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
