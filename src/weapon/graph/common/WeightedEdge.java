package weapon.graph.common;

public class WeightedEdge extends Edge {

  public final int weight;

  public WeightedEdge(int from, int to, int weight) {
    super(from, to);
    this.weight = weight;
  }
}
