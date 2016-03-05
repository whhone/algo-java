package weapon.graph.shortestpath;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Shortest Path Faster Algorithm. It handles negative edge.
 */
public class SPFA extends ShortestPath {

  public SPFA(int N) {
    super(N);
  }

  public void solve(int source) {
    Arrays.fill(cost, INF_DIST);
    Arrays.fill(fromEdges, null);
    Arrays.fill(volume, 0);

    LinkedList<Integer> queue = new LinkedList<Integer>();
    boolean[] vis = new boolean[N];
    vis[source] = true;
    cost[source] = 0;
    volume[source] = Integer.MAX_VALUE;
    queue.add(source);

    while (!queue.isEmpty()) {
      int u = queue.removeFirst();
      vis[u] = false;
      for (ShortestPath.ShortestPathEdge edge : this.edges.get(u)) {
        if (edge.capacity > 0) {
          int v = edge.getTo();
          int tmp = cost[u] + edge.getWeight();
          if (tmp < cost[v]) {
            if (!vis[v]) {
              queue.add(v);
              vis[v] = true;
            }
            cost[v] = tmp;
            fromEdges[v] = edge;
            volume[v] = Math.min(volume[u], edge.capacity);
          }
        }
      }
    }
  }
}
