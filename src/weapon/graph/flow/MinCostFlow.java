package weapon.graph.flow;

import weapon.graph.shortestpath.Dijkstra;
import weapon.graph.shortestpath.SPFA;
import weapon.graph.shortestpath.ShortestPath;

/**
 * Min Cost Max Flow. Implementation of Successive Shortest Path Algorithm using Dijkstra.
 */
public class MinCostFlow {

  public static MinCostFlow byDijkstra(int N) {
    return new MinCostFlow(new Dijkstra(N));
  }

  public static MinCostFlow bySPFA(int N) {
    return new MinCostFlow(new SPFA(N));
  }

  class Edge extends ShortestPath.ShortestPathEdge {
    Edge reverse;

    Edge(int from, int to, int cost, int capacity) {
      super(from, to, cost, capacity);
    }
  }

  private ShortestPath shortestPath;
  private int flow;
  private int cost;

  private MinCostFlow(int N) {
    this.shortestPath = new Dijkstra(N);
  }

  private MinCostFlow(ShortestPath shortestPath) {
    this.shortestPath = shortestPath;
  }

  public void addEdge(int from, int to, int weight, int cap) {
    Edge ef = new Edge(from, to, weight, cap);
    Edge et = new Edge(to, from, -weight, 0);
    ef.reverse = et;
    et.reverse = ef;
    shortestPath.addEdge(ef);
    shortestPath.addEdge(et);
  }

  public void solve(int S, int T) {
    do {
      shortestPath.solve(S);
      int volume = shortestPath.getVolume(T);
      if (volume > 0) {
        this.flow += volume;
        this.cost += volume * shortestPath.getCost(T);

        int u = T;
        while (u != S) {
          Edge edge = (Edge) shortestPath.getFromEdge(u);
          Edge reverseEdge = edge.reverse;
          edge.capacity -= volume;
          reverseEdge.capacity += volume;
          u = edge.getFrom();
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
