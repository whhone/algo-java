package weapon.geom;

import java.util.ArrayList;
import java.util.List;

/**
 * (x - center.x) ^ 2 + (y - center.y) ^ 2 = r ^ 2.
 */
public class Circle {

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

  public Circle(Point center, double radius) {
    this.center = center;
    this.radius = radius;
  }

  public Circle(double x, double y, double radius) {
    this(new Point(x, y), radius);
  }

  public Circle move(double dx, double dy) {
    return new Circle(center.move(dx, dy), radius);
  }

  public Circle scale(final Point origin, final double ratio) {
    return new Circle(center.scale(origin, ratio), radius * ratio);
  }

  public Circle scale(final double ratio) {
    return new Circle(center, radius * ratio);
  }

  /**
   * + means the distance.
   * 0 means touching.
   * - means intersecting.
   */
  public double distance(final Circle circle) {
    return center.distance(circle.center) - (radius + circle.radius);
  }

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
