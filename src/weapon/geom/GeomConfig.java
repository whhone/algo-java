package weapon.geom;

public class GeomConfig {

  static double epsilon = 1e-8;

  public static double getEps() {
    return epsilon;
  }

  public static void setEpsilon(double eps) {
    epsilon = eps;
  }
}
