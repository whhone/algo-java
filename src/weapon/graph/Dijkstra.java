package weapon.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Dijkstra's Algorithm.
 *
 * A single-source shortest-path algorithm for arbitrary directed graphs with unbounded non-negative weights.
 */
public class Dijkstra {

  public static class Edge {
    public final int from;
    public final int to;
    public int cost;
    public int capacity;

    public Edge(int from, int to, int cost, int capacity) {
      this.from = from;
      this.to = to;
      this.cost = cost;
      this.capacity = capacity;
    }
  }

  /** Represents the unreachable distance. */
  public final static int INF_DIST = Integer.MAX_VALUE;

  private final int N;
  private ArrayList<ArrayList<Edge>> edges;
  private int[] cost;
  private int[] volume;
  private Edge[] fromEdges;

  public Dijkstra(int N) {
    this.N = N;

    this.edges = new ArrayList<ArrayList<Edge>>(N);
    for (int i = 0; i < this.N; i++) {
      this.edges.add(new ArrayList<Edge>());
    }
    cost = new int[N];
    volume = new int[N];
    fromEdges = new Edge[N];
  }

  public void addEdge(Edge edge) {
    this.edges.get(edge.from).add(edge);
  }

  public void addEdge(int from, int to, int cost) {
    addEdge(new Edge(from, to, cost, 1));
  }

  public void solve(int source) {
    Arrays.fill(cost, INF_DIST);
    Arrays.fill(fromEdges, null);
    Arrays.fill(volume, 0);

    cost[source] = 0;
    volume[source] = Integer.MAX_VALUE;
    PriorityQueue<Node> pq = new PriorityQueue<Node>(N, comparator);
    pq.add(new Node(source, 0));

    while (!pq.isEmpty()) {
      Node node = pq.poll();
      if (node.dist != cost[node.u]) {
        continue;
      }
      for (Edge edge : edges.get(node.u)) {
        if (edge.capacity > 0) {
          int tmp = cost[node.u] + edge.cost;
          if (tmp < cost[edge.to]) {
            cost[edge.to] = tmp;
            fromEdges[edge.to] = edge;
            volume[edge.to] = Math.min(volume[node.u], edge.capacity);
            pq.add(new Node(edge.to, tmp));
          }
        }
      }
    }
  }

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
  public Edge getFromEdge(int node) {
    return this.fromEdges[node];
  }

  class Node {
    final int u, dist;
    Node(int u, int dist) {
      this.u = u;
      this.dist = dist;
    }
  }

  Comparator<Node> comparator = new Comparator<Node>() {
    @Override
    public int compare(Node o1, Node o2) {
      return o1.dist - o2.dist;
    }
  };
}
