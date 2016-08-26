package weapon.geom;

public final class GeomUtils {

  /**
   * Dot product of OA and OB.. Returns (2 * Area of triangle ABC).
   *
   * If OA rotates to OB anti-clockwise, the dot product is positive.
   */
  public static double dotProduct(double ax, double ay, double bx, double by, double ox, double oy) {
    return (ax - ox) * (by - oy) - (ay - oy) * (bx - ox);
  }

  /**
   * Dot product of OA and OB.
   */
  public static double dotProduct(Point a, Point b, Point o) {
    return dotProduct(a.x, a.y, b.x, b.y, o.x, o.y);
  }

  /**
   * Whether three points are collinear.
   */
  public static boolean isCollinear(Point a, Point b, Point c) {
    return FloatCompare.equals(0, dotProduct(a, b, c));
  }

  public static double cosineLawGetDegree(double a, double b, double c) {
    return Math.acos( (a * a + b * b - c * c) / (2 * a * b));
  }

//  /**
//   * Whether from point lies on from line.
//   */
//  public static boolean isPointOnLine(Point from, Line line) {
//    return Math.abs(dotProduct(from.x, from.y, line.x1, line.y1, line.x2, line.y2)) < FloatCompare.getEps();
//  }
//
//  /**
//   * Whether from point lies on from segment inclusively.
//   */
//  public static boolean isPointOnSegment(Point point, Segment segment) {
//    if (!(segment.from.x <= point.x && point.x <= segment.to.x) || (segment.to.x <= point.x && point.x <= segment.from.x)) {
//      return false;
//    }
//    if (!(segment.from.y <= point.y && point.y <= segment.to.y) || (segment.to.y <= point.y && point.y <= segment.from.y)) {
//      return false;
//    }
//    return isPointOnLine(point, new Line(segment));
//  }
}
