package weapon.graph.shortestpath;

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
public class Dijkstra extends ShortestPath {

  public Dijkstra(int N) {
    super(N);
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
      for (ShortestPath.ShortestPathEdge edge : edges.get(node.u)) {
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
