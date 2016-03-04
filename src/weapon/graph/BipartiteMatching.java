package weapon.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * Solves bipartite matching.
 */
public class BipartiteMatching {

  public int left;
  public int right;
  public int ansCount = -1;
  public int[] ansLeft, ansRight;
  public ArrayList<LinkedList<Integer>> edges;

  public BipartiteMatching(int leftN, int rightN) {
    this.left = leftN;
    this.right = rightN;
    this.ansLeft = new int[leftN];
    Arrays.fill(ansLeft, -1);
    this.ansRight = new int[rightN];
    Arrays.fill(ansRight, -1);
    this.edges = new ArrayList<LinkedList<Integer>>(this.left);
    for (int i = 0; i < this.left; i++) {
      this.edges.add(new LinkedList<Integer>());
    }
  }

  /**
   * Adds an edge between a left node and a right node.
   *
   * @param left The index of the left node.
   * @param right The index of the right node.
   */
  public void connect(int left, int right) {
    this.edges.get(left).add(right);
  }

  public void solve() {
    boolean[] visited = new boolean[left];
    ansCount = 0;
    for (int i = 0; i < left; ++i) {
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
        if ((ansRight[v] == -1) || (find(ansRight[v], visited))) {
          ansRight[v] = u;
          ansLeft[u] = v;
          return true;
        }
      }
    }
    return false;
  }
}
