package weapon.geom;

import java.util.ArrayList;
import java.util.List;

/**
 * A circle in the form of (x - center.x) ^ 2 + (y - center.y) ^ 2 = r ^ 2.
 */
public final class Circle {

  public final Point center;
  public final double radius;

  @Override
  public String toString() {
    return String.format("Circle[%s, %f]", center, radius);
  }

  @Override
  public boolean equals(Object object) {
    if (object == null) return false;
    if (object.getClass() != this.getClass()) return false;
    Circle that = (Circle)object;
    return this.center.equals(that.center) && FloatCompare.equals(radius, that.radius);
  }

  /**
   * @param center The center of the circle.
   * @param radius The radius of the circle.
   */
  public Circle(Point center, double radius) {
    this.center = center;
    this.radius = radius;
  }

  /**
   * @param x The x coordinate of the center of the circle.
   * @param y The y coordinate of the center of the circle.
   * @param radius The radius of the circle.
   */
  public Circle(double x, double y, double radius) {
    this(new Point(x, y), radius);
  }

  /**
   * Returns the circle moved by dx and dy.
   *
   * @param dx The x delta.
   * @param dy The y delta.
   * @return The moved circle.
   */
  public Circle move(double dx, double dy) {
    return new Circle(center.move(dx, dy), radius);
  }

  /**
   * Returns the circle with the radius scaled by a ratio against a point.
   *
   * @param origin The center of the scale operation.
   * @param ratio The ratio of the new radius over the old radius.
   * @return The scaled circle.
   */
  public Circle scale(final Point origin, final double ratio) {
    return new Circle(center.scale(origin, ratio), radius * ratio);
  }

  /**
   * Returns the circle with the radius scaled based on its center.
   *
   * @param ratio The ratio of the new radius over the old radius.
   * @return The scaled circle.
   */
  public Circle scale(final double ratio) {
    return new Circle(center, radius * ratio);
  }

  /**
   * Returns the distance to another circle. If the two circles do not overlap, the distance is positive. If two circles
   * touch each other, the distance is zero. If two circles intersect, the distance is negative.
   *
   * + means the distance.
   * 0 means touching.
   * - means intersecting.
   *
   * @return The distance to another circle.
   */
  public double distance(final Circle circle) {
    return center.distance(circle.center) - (radius + circle.radius);
  }

  /**
   * Finds the intersection to another circle.
   *
   * If the two circles do not overlap, return an empty list. If two circles touch each other, the list has one point.
   * If two circles intersect, the list contains two points.
   *
   * @param that The other circle.
   * @return The list of intersections.
   */
  public List<Point> intersect(final Circle that) {
    List<Point> intersections = new ArrayList<Point>();

    double d = this.center.distance(that.center);
    if (FloatCompare.less(this.radius + that.radius, d)) {
      return intersections;
    }

    double a = (this.radius * this.radius - that.radius * that.radius + d * d) / (2 * d);
    double h = Math.sqrt(this.radius * this.radius - a * a);
    Segment seg = new Segment(this.center, that.center);
    Point p2 = seg.scale(a / d).to;

    if (FloatCompare.greater(h, 0)) {
      intersections.add(new Point(
          p2.x + (that.center.y - this.center.y) * h / d,
          p2.y - (that.center.x - this.center.x) * h / d));
      intersections.add(new Point(
          p2.x - (that.center.y - this.center.y) * h / d,
          p2.y + (that.center.x - this.center.x) * h / d));
    } else {
      intersections.add(p2);
    }
    return intersections;
  }

  /**
   * Finds the intersection to another line.
   *
   * If the circles and the line do not overlap, return an empty list. If they touch each other, the list has one point.
   * If they intersect, the list contains two points.
   *
   * @param line The other circle.
   * @return The list of intersections.
   */
  public List<Point> intersect(final Line line) {
    List<Point> intersections = new ArrayList<Point>();

    double d = center.distance(line);
    if (FloatCompare.equals(radius, d)) {
      // touching. one intersection.
      Line toD = new Line(center, 1 / line.getSlope());
      intersections.add(line.intersect(toD));
    } else if (FloatCompare.less(d, radius)) {
      // two intersections
      if (FloatCompare.equals(0, d)) {
        double degree = Math.atan(line.getSlope());
        intersections.add(new Point(
            this.center.x + this.radius * Math.cos(degree),
            this.center.y + this.radius * Math.sin(degree)));
        intersections.add(new Point(
            this.center.x - this.radius * Math.cos(degree),
            this.center.y - this.radius * Math.sin(degree)));
      } else {
        Line toD = new Line(center, -1 / line.getSlope());
        Point p2 = toD.intersect(line);
        double h = Math.sqrt(radius * radius - center.distance(p2) * center.distance(p2));
        intersections.add(new Point(
            p2.x + (p2.y - this.center.y) * h / d,
            p2.y - (p2.x - this.center.x) * h / d));
        intersections.add(new Point(
            p2.x - (p2.y - this.center.y) * h / d,
            p2.y + (p2.x - this.center.x) * h / d));
      }
    }

    return intersections;
  }
}
