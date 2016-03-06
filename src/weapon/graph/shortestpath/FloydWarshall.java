package weapon.graph.shortestpath;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * The Floyd–Warshall algorithm is an algorithm for finding shortest paths in a weighted graph with positive or negative
 * edge weights. It can check whether a graph contains a negative cycle.
 */
public class FloydWarshall {

  public final static int INF = Integer.MAX_VALUE;

  private final int N;
  private int[][] dist;
  private int[][] previousNode;
  private boolean hasNegativeCycle;

  public FloydWarshall(int N) {
    this.N = N;
    dist = new int[N][N];
    previousNode = new int[N][N];
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        previousNode[i][j] = j;
      }
      Arrays.fill(dist[i], INF);
      dist[i][i] = 0;
    }
  }

  public void addEdge(int from, int to, int cost) {
    dist[from][to] = Math.min(dist[from][to], cost);
  }

  /**
   * @return False if there is a negative cycle.
   */
  public boolean solve() {
    for (int k = 0; k < N; k++) {
      for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
          if (dist[i][k] != INF && dist[k][j] != INF) {
            int tmp = dist[i][k] + dist[k][j];
            if (tmp < dist[i][j]) {
              dist[i][j] = tmp;
              previousNode[i][j] = previousNode[i][k];
            }
            if (i == j && dist[i][j] < 0) {
              hasNegativeCycle = true;
              return false;
            }
          }
        }
      }
    }
    return true;
  }

  public int getDistance(int from, int to) {
    return dist[from][to];
  }

  public boolean hasNegativeCycle() {
    return hasNegativeCycle;
  }

  public ArrayList<Integer> getPath(int from, int to) {
    ArrayList<Integer> p = new ArrayList<Integer>();
    p.add(0, from);
    while (from != to) {
      p.add(previousNode[from][to]);
      from = previousNode[from][to];
    }
    return p;
  }
}
