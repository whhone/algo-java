package weapon.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class MaxFlow {
  class Edge {
    public int u, v, cap;
    public Edge reverse;

    public Edge(int u, int v, int cap) {
      this.u = u;
      this.v = v;
      this.cap = cap;
    }
  }

  int N;
  public ArrayList<LinkedList<Edge>> edges;

  public MaxFlow(int N) {
    this.N = N;
    this.edges = new ArrayList<LinkedList<Edge>>();
    for (int i = 0; i < this.N; i++) {
      this.edges.add(new LinkedList<Edge>());
    }
  }

  public void addEdge(int from, int to, int cap) {
    Edge ef = new Edge(from, to, cap);
    Edge et = new Edge(to, from, 0);
    ef.reverse = et;
    et.reverse = ef;
    this.edges.get(from).add(ef);
    this.edges.get(to).add(et);
  }

  private int[] build(int starting) {
    int[] dist = new int[this.N];
    Arrays.fill(dist, -1);

    dist[starting] = 0;
    LinkedList<Integer> queue = new LinkedList<Integer>();
    queue.add(starting);
    while (!queue.isEmpty()) {
      int cur = queue.removeFirst();
      for (Edge edge : edges.get(cur)) {
        if (edge.cap > 0 && dist[edge.v] == -1) {
          dist[edge.v] = dist[cur] + 1;
          queue.add(edge.v);
        }
      }
    }

    return dist;
  }

  private int dfs(int u, int T, int input, int[] dist) {
    if (u == T) {
      return input;
    }
    int used = 0;
    for (Edge edge : edges.get(u)) {
      if (input - used <= 0) {
        break;
      }
      int v = edge.v;
      if (edge.cap > 0 && dist[v] == dist[u] + 1) {
        int t = dfs(v, T, Math.min(input - used, edge.cap), dist);
        if (t > 0) {
          edge.cap -= t;
          edge.reverse.cap += t;
          used += t;
        }
      }
    }
    if (used == 0) {
      dist[u] = -1;
    }
    return used;
  }

  public int solve(int S, int T) {
    int flow = 0;
    while (true) {
      int[] dist = build(S);
      if (dist[T] == -1) {
        break;
      }
      int tmp = dfs(S, T, Integer.MAX_VALUE, dist);
      flow += tmp;
    }
    return flow;
  }
}
