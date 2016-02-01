package weapon.geom;

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

//  public Segment(Point from, double slope, double length) {
//
//  }

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
}
