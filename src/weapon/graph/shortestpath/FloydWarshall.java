package weapon.graph.shortestpath;

import java.util.Arrays;

/**
 * The Floyd–Warshall algorithm is an algorithm for finding shortest paths in a weighted graph with positive or negative
 * edge weights. It can check whether a graph contains a negative cycle.
 */
public class FloydWarshall {

  public final static int INF = Integer.MAX_VALUE / 2;

  private final int N;
  private int[][] dist;

  public FloydWarshall(int N) {
    this.N = N;
    dist = new int[N][N];
    for (int i = 0; i < N; i++) {
      Arrays.fill(dist[i], INF);
      dist[i][i] = 0;
    }
  }

  public void addEdge(int from, int to, int cost) {
    dist[from][to] = Math.min(dist[from][to], cost);
  }

  public void solve() {
    for (int k = 0; k < N; k++) {
      for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
          dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
        }
      }
    }
  }

  public int getDistance(int from, int to) {
    return dist[from][to];
  }

  public boolean hasNegativeCycle() {
    for (int i = 0; i < N; i++) {
      if (dist[i][i] < 0) {
        return true;
      }
    }
    return false;
  }
}
