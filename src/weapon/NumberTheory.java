package weapon;

/**
 * NOT READY!
 *
 * Number Theory ~
 */
public class NumberTheory {
  public static int gcd(int a, int b) {
    return (a > 0) ? gcd(b % a, a) : b;
  }

  public static long gcd(long a, long b) {
    return (a > 0) ? gcd(b % a, a) : b;
  }
}
