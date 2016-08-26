package weapon.math;

/**
 * A collection of area formula.
 */
public final class Area {

  /**
   * Calculates the area of a regular polygon.
   */
  public static double ofRegularPolygon(int numOfSide, double sideLength) {
    return numOfSide / 4.0 / Math.tan(Math.PI / numOfSide) * sideLength * sideLength;
  }

  /**
   * Calculates the area of a triangle with Heron's formula.
   */
  public static double ofTriangle(double sideA, double sideB, double sideC) {
    double s = (sideA + sideB + sideC) / 2;
    return Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC));
  }

  /**
   * Calculates the area of a circle.
   */
  public static double ofCircle(double radius) {
    return Math.PI * radius * radius;
  }

  /**
   * Calculates the area of an ellipse.
   */
  public static double ofEllipse(double radius1, double radius2) {
    return Math.PI * radius1 * radius2;
  }
}
