package weapon.graph.shortestpath;

import weapon.graph.common.WeightedEdge;

import java.util.ArrayList;

public abstract class ShortestPath {

  /** Represents the unreachable distance. */
  public final static int INF_DIST = Integer.MAX_VALUE;

  public static class ShortestPathEdge extends WeightedEdge {
    public int capacity;

    public ShortestPathEdge(int from, int to, int cost, int capacity) {
      super(from, to, cost);
      this.capacity = capacity;
    }
  }

  protected final int N;
  protected ArrayList<ArrayList<ShortestPathEdge>> edges;
  protected int[] cost;
  protected int[] volume;
  protected ShortestPath.ShortestPathEdge[] fromEdges;

  protected ShortestPath(int N) {
    this.N = N;
    this.edges = new ArrayList<ArrayList<ShortestPath.ShortestPathEdge>>(N);
    for (int i = 0; i < this.N; i++) {
      this.edges.add(new ArrayList<ShortestPath.ShortestPathEdge>());
    }
    cost = new int[N];
    volume = new int[N];
    fromEdges = new ShortestPath.ShortestPathEdge[N];
  }

  public void addEdge(ShortestPath.ShortestPathEdge edge) {
    this.edges.get(edge.getFrom()).add(edge);
  }

  public void addEdge(int from, int to, int cost) {
    addEdge(new ShortestPath.ShortestPathEdge(from, to, cost, 1));
  }

  /**
   * Finds the shortest path from the source to all other nodes.
   *
   * @param source The source to start.
   */
  abstract public void solve(int source);


  /**
   * Gets the cost of the shortest path to the node.
   */
  public int getCost(int node) {
    return this.cost[node];
  }

  /**
   * Gets the max flow of the shortest to the node.
   */
  public int getVolume(int node) {
    return this.volume[node];
  }

  /**
   * Gets the previous edge in the shortest path.
   */
  public ShortestPath.ShortestPathEdge getFromEdge(int node) {
    return this.fromEdges[node];
  }

  /**
   * Gets the path of edges to the node.
   */
  public ArrayList<ShortestPath.ShortestPathEdge> getPath(int node) {
    ArrayList<ShortestPath.ShortestPathEdge> path = new ArrayList<ShortestPath.ShortestPathEdge>();
    for (ShortestPath.ShortestPathEdge edge = getFromEdge(node); edge != null; edge = getFromEdge(edge.getFrom())) {
      path.add(0, edge);
    }
    return path;
  }
}
