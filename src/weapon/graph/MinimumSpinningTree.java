package weapon.graph;

import weapon.datastructures.DisjointSet;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * Minimum Spinning Tree by Kruskal's Algorithm.
 */
public class MinimumSpinningTree {

  public class Edge implements Comparable<Edge> {
    public final int u, v, cost;

    Edge(int u, int v, int cost) {
      this.u = u;
      this.v = v;
      this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
      return this.cost - o.cost;
    }
  }

  public int N;
  public int minCost;
  ArrayList<Edge> edges;
  ArrayList<Edge> treeEdges;

  public MinimumSpinningTree(int N) {
    this.N = N;
    this.minCost = 0;
    this.edges = new ArrayList<Edge>();
    this.treeEdges = new ArrayList<Edge>();
  }

  public void addEdge(int u, int v, int cost) {
    this.edges.add(new Edge(u, v, cost));
  }

  public void solve() {
    DisjointSet ds = new DisjointSet(N);

    minCost = 0;
    PriorityQueue<Edge> pq = new PriorityQueue<Edge>(edges);
    while (treeEdges.size() < N - 1 && !pq.isEmpty()) {
      Edge e = pq.poll();
      if (!ds.isSameSet(e.u, e.v)) {
        treeEdges.add(e);
        ds.union(e.u, e.v);
        minCost += e.cost;
      }
    }
  }

  public boolean getOK() {
    return this.treeEdges.size() == N - 1;
  }

  public int getMinCost() {
    return this.minCost;
  }

  public ArrayList<Edge> getTreeEdges() {
    return this.treeEdges;
  }
}
