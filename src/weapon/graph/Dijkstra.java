package weapon.graph;

import weapon.graph.common.WeightedEdge;

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

  public static class DijkstraEdge extends WeightedEdge {
    public int capacity;

    public DijkstraEdge(int from, int to, int cost, int capacity) {
      super(from, to, cost);
      this.capacity = capacity;
    }
  }

  /** Represents the unreachable distance. */
  public final static int INF_DIST = Integer.MAX_VALUE;

  private final int N;
  private ArrayList<ArrayList<DijkstraEdge>> edges;
  private int[] cost;
  private int[] volume;
  private DijkstraEdge[] fromEdges;

  public Dijkstra(int N) {
    this.N = N;

    this.edges = new ArrayList<ArrayList<DijkstraEdge>>(N);
    for (int i = 0; i < this.N; i++) {
      this.edges.add(new ArrayList<DijkstraEdge>());
    }
    cost = new int[N];
    volume = new int[N];
    fromEdges = new DijkstraEdge[N];
  }

  public void addEdge(DijkstraEdge edge) {
    this.edges.get(edge.getFrom()).add(edge);
  }

  public void addEdge(int from, int to, int cost) {
    addEdge(new DijkstraEdge(from, to, cost, 1));
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
      for (DijkstraEdge edge : edges.get(node.u)) {
        if (edge.capacity > 0) {
          int tmp = cost[node.u] + edge.getWeight();
          if (tmp < cost[edge.getTo()]) {
            cost[edge.getTo()] = tmp;
            fromEdges[edge.getTo()] = edge;
            volume[edge.getTo()] = Math.min(volume[node.u], edge.capacity);
            pq.add(new Node(edge.getTo(), tmp));
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
  public DijkstraEdge getFromEdge(int node) {
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
