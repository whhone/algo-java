package weapon.geom;

public final class Point {
  public static Point ORIGIN = new Point(0, 0);

  public final double x;
  public final double y;

  @Override
  public String toString() {
    return String.format("Point: %.10f %.10f", x, y);
  }

  @Override
  public boolean equals(Object object) {
    if (object == null) return false;
    if (object.getClass() != this.getClass()) return false;
    Point that = (Point)object;
    return FloatCompare.equals(this.x, that.x) && FloatCompare.equals(this.y, that.y);
  }

  public Point(double x, double y) {
    this.x = x;
    this.y = y;
  }

  public Point move(double dx, double dy) {
    return new Point(this.x + dx, this.y + dy);
  }

  public Point add(Point delta) {
    return new Point(this.x + delta.x, this.y + delta.y);
  }

  public Point rotate(final Point origin, final double degree) {
    double dx = x - origin.x;
    double dy = y - origin.y;
    double xx = dx * Math.cos(degree) - dy * Math.sin(degree);
    double yy = dx * Math.sin(degree) + dy * Math.cos(degree);
    return new Point(origin.x + xx, origin.y + yy);
  }

  public Point rotate(final double degree) {
    return rotate(ORIGIN, degree);
  }

  public Point scale(final Point origin, final double ratio) {
    return new Point(origin.x + (this.x - origin.x) * ratio, origin.y + (this.y - origin.y) * ratio);
  }

  public double distance2(double x, double y) {
    return (x - this.x) * (x - this.x) + (y - this.y) * (y - this.y);
  }

  public double distance2(Point point) {
    return (point.x - this.x) * (point.x - this.x) + (point.y - this.y) * (point.y - this.y);
  }

  public double distance(double x, double y) {
    return Math.sqrt(distance2(x, y));
  }

  public double distance(Point point) {
    return Math.sqrt(distance2(point));
  }

  public double distance(Line line) {
    return Math.abs(line.a * this.x + line.b * this.y + line.c);
  }

  public double distance(Segment segment) {
    double c = segment.length();
    double a = distance(segment.from);
    if (FloatCompare.equals(c, 0)) {
      return a;
    }
    double b = distance(segment.to);
    if (b * b + c * c < a * a) {
      return b;
    }
    if (a * a + c * c < b * b) {
      return a;
    }
    return distance(new Line(segment));
  }
}
