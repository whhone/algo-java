package weapon.graph;

import weapon.graph.common.Edge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * Dinic's algorithm for max flow. O(V * V * E).
 */
public class MaxFlow {
  class MaxFlowEdge extends Edge {
    public int cap;
    public MaxFlowEdge reverse;

    public MaxFlowEdge(int from, int to, int cap) {
      super(from, to);
      this.cap = cap;
    }
  }

  int N;
  public ArrayList<ArrayList<MaxFlowEdge>> edges;

  public MaxFlow(int N) {
    this.N = N;
    this.edges = new ArrayList<ArrayList<MaxFlowEdge>>(N);
    for (int i = 0; i < this.N; i++) {
      this.edges.add(new ArrayList<MaxFlowEdge>());
    }
  }

  public void addEdge(int from, int to, int cap) {
    MaxFlowEdge ef = new MaxFlowEdge(from, to, cap);
    MaxFlowEdge et = new MaxFlowEdge(to, from, 0);
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
      for (MaxFlowEdge edge : edges.get(cur)) {
        if (edge.cap > 0 && dist[edge.getTo()] == -1) {
          dist[edge.getTo()] = dist[cur] + 1;
          queue.add(edge.getTo());
        }
      }
    }

    return dist;
  }

  private int push(int u, int T, int input, int[] dist) {
    if (u == T) {
      return input;
    }
    int used = 0;
    for (MaxFlowEdge edge : edges.get(u)) {
      if (input - used <= 0) {
        break;
      }
      int v = edge.getTo();
      if (edge.cap > 0 && dist[v] == dist[u] + 1) {
        int t = push(v, T, Math.min(input - used, edge.cap), dist);
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
      int tmp = push(S, T, Integer.MAX_VALUE, dist);
      flow += tmp;
    }
    return flow;
  }
}
