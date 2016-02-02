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

  /** Represents the unreachable distance. */
  public final static int INF_DIST = Integer.MAX_VALUE;

  /** Represents a null node */
  public final static int UNDEFINED = -1;

  public int N;
  public ArrayList<ArrayList<Edge>> edges;
  public int[] dist;
  public int[] prev;

  public Dijkstra(int N) {
    this.N = N;

    this.edges = new ArrayList<ArrayList<Edge>>();
    for (int i = 0; i < this.N; i++) {
      this.edges.add(new ArrayList<Edge>());
    }
    dist = new int[N];
    prev = new int[N];
  }

  public void addEdge(int from, int to, int cost) {
    this.edges.get(from).add(new Edge(to, cost));
  }

  public void solve(int s) {
    Arrays.fill(dist, INF_DIST);
    Arrays.fill(prev, UNDEFINED);

    dist[s] = 0;
    PriorityQueue<Node> pq = new PriorityQueue<Node>(N, comparator);
    pq.add(new Node(s, 0));

    while (!pq.isEmpty()) {
      Node node = pq.poll();
      if (node.dist != dist[node.u]) {
        continue;
      }
      for (Edge edge : edges.get(node.u)) {
        int tmp = dist[node.u] + edge.cost;
        if (tmp < dist[edge.v]) {
          dist[edge.v] = tmp;
          prev[edge.v] = node.u;
          pq.add(new Node(edge.v, tmp));
        }
      }
    }
  }

  class Edge {
    int v, cost;

    Edge(int to, int cost) {
      this.v = to;
      this.cost = cost;
    }
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
