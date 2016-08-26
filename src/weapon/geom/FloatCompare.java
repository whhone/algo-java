package weapon.geom;

public final class FloatCompare {

  static double epsilon = 1e-8;

  public static double getEps() {
    return epsilon;
  }

  public static void setEpsilon(double eps) {
    epsilon = eps;
  }

  public static boolean equals(double a, double b) {
    return Math.abs(a - b) < epsilon;
  }

  public static boolean greater(double a, double b) {
    return a > b + epsilon;
  }

  public static boolean greaterEquals(double a, double b) {
    return a > b - epsilon;
  }

  public static boolean less(double a, double b) {
    return a < b - epsilon;
  }

  public static boolean lessEquals(double a, double b) {
    return a < b + epsilon;
  }
}
