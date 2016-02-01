package weapon.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class BipartiteMatching {

  public int N, M;
  public int ansCount = -1;
  public int[] ansN, ansM;
  public ArrayList<LinkedList<Integer>> edges;

  public BipartiteMatching(int N, int M) {
    this.N = N;
    this.M = M;
    this.ansN = new int[N];
    Arrays.fill(ansN, -1);
    this.ansM = new int[M];
    Arrays.fill(ansM, -1);
    this.edges = new ArrayList<LinkedList<Integer>>();
    for (int i = 0; i < this.N; i++) {
      this.edges.add(new LinkedList<Integer>());
    }
  }

  public void connect(int n, int m) {
    this.edges.get(n).add(m);
  }

  public void solve() {
    boolean[] visited = new boolean[N];
    ansCount = 0;
    for (int i = 0; i < N; ++i) {
      Arrays.fill(visited, false);
      if (find(i, visited)) {
        ++ansCount;
      }
    }
  }

  private boolean find(int u, boolean[] visited) {
    for (int v: edges.get(u)) {
      if (!visited[v]) {
        visited[v] = true;
        if ((ansM[v] == -1) || (find(ansM[v], visited))) {
          ansM[v] = u;
          ansN[u] = v;
          return true;
        }
      }
    }
    return false;
  }
}
