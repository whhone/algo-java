package weapon.graph;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Solves Strongly Connected Component problem with the Kosaraju's algorithm.
 *
 * Complexity: O(|V| + |E|)
 */
public class StronglyConnectedComponent {

  class Node {
    int index, component;
    ArrayList<Node> edges, reverseEdges;

    Node(int index) {
      this.index = index;
      edges = new ArrayList<Node>();
      reverseEdges = new ArrayList<Node>();
      component = -1;
    }
  }

  int N;
  Node[] nodes;
  int componentCount;

  public StronglyConnectedComponent(int N) {
    this.N = N;
    nodes = new Node[N];
    for (int i = 0; i < N; i++) {
      nodes[i] = new Node(i);
    }
  }

  public void addEdge(int from, int to) {
    nodes[from].edges.add(nodes[to]);
    nodes[to].reverseEdges.add(nodes[from]);
  }

  public int getComponentCount() {
    return componentCount;
  }

  public int getNodeComponent(int u) {
    return nodes[u].component;
  }

  public void solve() {
    boolean[] visited = new boolean[N];
    ArrayList<Node> topologicalOrder = new ArrayList<Node>();

    for (int i = 0; i < N; i++) {
      if (!visited[i]) {
        DFS1(nodes[i], visited, topologicalOrder);
      }
    }

    componentCount = 0;
    Arrays.fill(visited, false);
    for (int i = N - 1; i >= 0; i--) {
      Node u = topologicalOrder.get(i);
      if (!visited[u.index]) {
        DFS2(u, visited, componentCount++);
      }
    }
  }

  /**
   * Normal DFS to find the to Topological order.
   */
  private void DFS1(Node u, boolean[] visited, ArrayList<Node> topologicalOrder) {
    visited[u.index] = true;
    for (Node v : u.edges) {
      if (!visited[v.index]) {
        DFS1(v, visited, topologicalOrder);
      }
    }
    topologicalOrder.add(u);
  }

  /**
   * DFS using the reversed edges.
   */
  private void DFS2(Node u, boolean[] visited, int index) {
    visited[u.index] = true;
    u.component = index;
    for (Node v : u.reverseEdges) {
      if (!visited[v.index]) {
        DFS2(v, visited, index);
      }
    }
  }
}
