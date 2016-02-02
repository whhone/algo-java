package weapon.geom;

import com.sun.istack.internal.Nullable;

/**
 * Represents a line (ax + by + c = 0), where a^2 + b^2 = 1 and c >= 0.
 */
public class Line {

  public double a, b, c;

  public Line(double a, double b, double c) {
    double t = Math.sqrt(a * a + b * b) * ((c < 0) ? -1 : 1);
    this.a = a / t;
    this.b = b / t;
    this.c = c / t;
  }

  public Line(double x1, double y1, double x2, double y2) {
    this(y2 - y1, x1 - x2, y1 * x2 - x1 * y2);
  }

  public Line(Point a, Point b) {
    this(a.x, a.y, b.x, b.y);
  }

  public Line(Point a, double slope) {
    this(slope, -1, a.y - slope * a.x);
  }

  public Line(Segment segment) {
    this(segment.from.x, segment.from.y, segment.to.x, segment.to.y);
  }

  public String toString() {
    return String.format("[Line %f x + %f y + %f = 0]", a, b, c);
  }

  public boolean equals(Object object) {
    if (object == null) return false;
    if (object.getClass() != this.getClass()) return false;
    Line that = (Line)object;
    return (Math.abs(this.c - that.c) < GeomConfig.getEps() &&
            Math.abs(this.getSlope() - that.getSlope()) < GeomConfig.getEps());
  }

  /**
   * @return The slope of the line. Returns Double.POSITIVE_INFINITY for vertical line.
   */
  public double getSlope() {
    if (Math.abs(b) < GeomConfig.getEps()) {
      return Double.POSITIVE_INFINITY;
    } else {
      return - a / b;
    }
  }

  public double distance(Point point) {
    return point.distance(this);
  }

  public boolean isParallel(Line that) {
    if (this.getSlope() == Double.POSITIVE_INFINITY) {
      return that.getSlope() == Double.POSITIVE_INFINITY;
    } else {
      return Math.abs(this.getSlope() - that.getSlope()) < GeomConfig.getEps();
    }
  }

  @Nullable
  public Point intersect(Line that) {
    if (isParallel(that)) {
      return null;
    }
    double x = (this.b * that.c - this.c * that.b) / (this.a * that.b - this.b * that.a);
    double y = (this.a * that.c - this.c * that.a) / (this.b * that.a - this.a * that.b);
    return new Point(x, y);
  }
}