package weapon.graph.common;

public class WeightedEdge extends Edge {

  private final int weight;

  public WeightedEdge(int from, int to, int weight) {
    super(from, to);
    this.weight = weight;
  }

  public int getWeight() {
    return this.weight;
  }
}
