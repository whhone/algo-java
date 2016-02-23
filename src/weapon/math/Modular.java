package weapon.math;


/**
 * Number Theory's Modular Arithmetic.
 *
 * Modular.on(MOD).power(a, b);
 */
public class Modular {

  public static Modular on(long mod) {
    return new Modular(mod);
  }

  long MOD;

  private Modular(long mod) {
    this.MOD = mod;
  }

  /**
   * Returns a ^ b % MOD.
   */
  public long power(long a, long b) {
    if (b == 0) {
      return 1;
    }
    long val = power(a, b / 2);
    if (b % 2 == 0) {
      return (val * val) % MOD;
    } else {
      return (val * (val * a % MOD)) % MOD;
    }
  }

  /**
   * Returns the inverse of a such that inverse * a % MOD = 1.
   */
  public long inverse(long a) {
    return power(a, NumberTheory.eulerTotient(MOD) - 1);
  }

  /**
   * Returns the inverse of a such that inverse * a % MOD = 1. MOD is required to be a prime.
   */
  public long inverseModPrime(long a) {
    return power(a, MOD - 2);
  }
}
