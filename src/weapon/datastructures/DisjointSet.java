package weapon.datastructures;

/**
 * A union-and-find data structure.
 */
public class DisjointSet {

  public int N;
  private int[] parent;

  public DisjointSet(int N) {
    this.N = N;
    this.parent = new int[N];
    for (int i = 0; i < N; i++) {
      this.parent[i] = i;
    }
  }

  public int find(int u) {
    if (u != parent[u]) {
      parent[u] = find(parent[u]);
      return parent[u];
    } else {
      return u;
    }
  }

  public void union(int u, int v) {
    int up = find(u), vp = find(v);
    if (up != vp) {
      parent[u] = parent[v];
    }
  }
}
