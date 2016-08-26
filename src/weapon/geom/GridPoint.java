package weapon.geom;

import java.util.Comparator;

/**
 * A point where x and y are integer.
 */
public final class GridPoint implements Comparable<GridPoint> {

  public long x, y;
  public int index = 0;

  public GridPoint(long x, long y) {
    this.x = x;
    this.y = y;
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
