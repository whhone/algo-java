package weapon.geom;

import java.util.Comparator;

/**
 * A point where x and y are integer.
 */
public final class GridPoint implements Comparable<GridPoint> {

  public static final GridPoint ORIGIN = new GridPoint(0, 0);
  public long x, y;
  public int index = 0;

  public GridPoint(long x, long y) {
    this.x = x;
    this.y = y;
  }

  @Override
  public String toString() {
    return String.format("%d %d", x, y);
  }

  @Override
  public boolean equals(Object other) {
    if (other == null) return false;
    if (!(other instanceof GridPoint)) return false;
    GridPoint otherPoint = (GridPoint)other;
    return (otherPoint.x == x && otherPoint.y == y);
  }

  public double dist(GridPoint gridPoint) {
    return dist(gridPoint.x, gridPoint.y);
  }

  public double dist(long x, long y) {
    return Math.sqrt(dist2(x, y));
  }

  public long dist2(GridPoint gridPoint) {
    return dist2(gridPoint.x, gridPoint.y);
  }

  public long dist2(long x, long y) {
    return (this.x - x) * (this.x - x) + (this.y - y) * (this.y - y);
  }

  public GridPoint rotate90Clockwise(GridPoint origin) {
    return new GridPoint(origin.x - origin.y + y, origin.y - x + origin.x);
  }

  public GridPoint rotate90CounterClockwise(GridPoint origin) {
    return new GridPoint(-(y - origin.y) + origin.x, (x - origin.x) + origin.y);
  }

  public static boolean isCollinear(GridPoint a, GridPoint b, GridPoint c) {
    return (c.y - a.y) * (b.x - a.x) == (b.y - a.y) * (c.x - a.x);
  }

  public GridPoint setIndex(int i) {
    this.index = i;
    return this;
  }

  /**
   * Sort by x then y.
   */
  @Override
  public int compareTo(GridPoint p) {
    if (this.x != p.x) return (int)(this.x - p.x);
    else return (int)(this.y - p.y);
  }

  final protected static Comparator<GridPoint> customComparator = new Comparator<GridPoint>() {
    public int compare(GridPoint a, GridPoint b) {
      if (a.x != b.x) {
        return (int)(a.x - b.x);
      } else {
        return (int)(a.y - b.y);
      }
    }
  };
}
