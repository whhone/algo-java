package weapon.geom;

import com.sun.istack.internal.Nullable;

/**
 * Represents a segment, a vector.
 */
public class Segment {

  public final Point from, to;

  public Segment(double x1, double y1, double x2, double y2) {
    this(new Point(x1, y1), new Point(x2, y2));
  }

  public Segment(Point from, Point to) {
    this.from = from;
    this.to = to;
  }

  public double length() {
    return from.distance(to);
  }

  public double distance(Point point) {
    return point.distance(this);
  }

  public Segment move(double dx, double dy) {
    return new Segment(from.x + dx, from.y + dy, to.x + dx, to.y + dy);
  }

  public Segment rotate(final Point origin, final double degree) {
    return new Segment(from.rotate(origin, degree), to.rotate(origin, degree));
  }

  public Segment rotate(final double degree) {
    return rotate(from, degree);
  }

  public Segment scale(final Point origin, final double ratio) {
    return new Segment(from.scale(origin, ratio), to.scale(origin, ratio));
  }

  public Segment scale(final double ratio) {
    return scale(from, ratio);
  }

  @Nullable
  public Point intersect(Segment that) {
    Line thisLine = new Line(this);
    Line thatLine = new Line(that);

    Point intersection = thisLine.intersect(thatLine);
    if (intersection != null &&
        within(intersection.x, this.from.x, this.to.x) &&
        within(intersection.y, this.from.y, this.to.y) &&
        within(intersection.x, that.from.x, that.to.x) &&
        within(intersection.y, that.from.y, that.to.y)) {
      return intersection;
    } else {
      return null;
    }
  }

  @Nullable
  public Point intersect(Line that) {
    Line thisLine = new Line(this);

    Point intersection = thisLine.intersect(that);
    if (intersection != null &&
        within(intersection.x, this.from.x, this.to.x) &&
        within(intersection.y, this.from.y, this.to.y)) {
      return intersection;
    } else {
      return null;
    }
  }

  /**
   * Checks if the value in the range between bound1 and bound2.
   */
  private boolean within(double value, double bound1, double bound2) {
    if (bound1 > bound2) {
      double t = bound1;
      bound1 = bound2;
      bound2 = t;
    }
    return FloatCompare.lessEquals(bound1, value) && FloatCompare.lessEquals(value, bound2);
  }
}
