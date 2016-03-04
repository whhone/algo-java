package weapon.graph;

/**
 * Min Cost Max Flow. Implementation of Successive Shortest Path Algorithm using Dijkstra.
 */
public class MinCostFlow {

  class Edge extends Dijkstra.DijkstraEdge {
    Edge reverse;

    Edge(int from, int to, int cost, int capacity) {
      super(from, to, cost, capacity);
    }
  }

  private Dijkstra dijkstra;
  private int flow;
  private int cost;

  public MinCostFlow(int N) {
    this.dijkstra = new Dijkstra(N);
  }

  public void addEdge(int from, int to, int weight, int cap) {
    Edge ef = new Edge(from, to, weight, cap);
    Edge et = new Edge(to, from, -weight, 0);
    ef.reverse = et;
    et.reverse = ef;
    dijkstra.addEdge(ef);
    dijkstra.addEdge(et);
  }

  public void solve(int S, int T) {
    do {
      dijkstra.solve(S);
      int volume = dijkstra.getVolume(T);
      if (volume > 0) {
        this.flow += volume;
        this.cost += volume * dijkstra.getCost(T);

        int u = T;
        while (u != S) {
          Edge edge = (Edge)dijkstra.getFromEdge(u);
          Edge reverseEdge = edge.reverse;
          edge.capacity -= volume;
          reverseEdge.capacity += volume;
          u = edge.from;
        }
      } else {
        break;
      }
    } while (true);
  }

  public int getMaxFlow() {
    return this.flow;
  }

  public int getMinCost() {
    return this.cost;
  }
}
