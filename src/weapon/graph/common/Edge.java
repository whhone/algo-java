package weapon.graph.common;

public class Edge {

  private final int from;
  private final int to;

  public Edge(int from, int to) {
    this.from = from;
    this.to = to;
  }

  public int getFrom() {
    return this.from;
  }

  public int getTo() {
    return this.to;
  }
}
