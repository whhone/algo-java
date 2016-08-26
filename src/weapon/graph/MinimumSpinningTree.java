package weapon.graph;

import weapon.datastructures.DisjointSet;
import weapon.graph.common.WeightedEdge;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * Minimum Spinning Tree by Kruskal's Algorithm.
 */
public final class MinimumSpinningTree {

  private int N;
  private int minCost;
  private ArrayList<WeightedEdge> edges;
  private ArrayList<WeightedEdge> treeEdges;

  public MinimumSpinningTree(int N) {
    this.N = N;
    this.minCost = 0;
    this.edges = new ArrayList<WeightedEdge>(N - 1);
    this.treeEdges = new ArrayList<WeightedEdge>(N - 1);
  }

  public void addEdge(int u, int v, int cost) {
    this.edges.add(new WeightedEdge(u, v, cost));
  }

  public void solve() {
    DisjointSet ds = new DisjointSet(N);

    minCost = 0;
    PriorityQueue<WeightedEdge> pq = new PriorityQueue<WeightedEdge>(edges);
    while (treeEdges.size() < N - 1 && !pq.isEmpty()) {
      WeightedEdge e = pq.poll();
      if (!ds.isSameSet(e.getFrom(), e.getTo())) {
        treeEdges.add(e);
        ds.union(e.getFrom(), e.getTo());
        minCost += e.getWeight();
      }
    }
  }

  public boolean getOK() {
    return this.treeEdges.size() == N - 1;
  }

  public int getMinCost() {
    return this.minCost;
  }

  public ArrayList<WeightedEdge> getTreeEdges() {
    return this.treeEdges;
  }
}
