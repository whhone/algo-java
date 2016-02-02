package workspace;

import utils.InputReader;
import utils.OutputWriter;
import weapon.graph.Dijkstra;

public class POJ1847 {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt(), a = in.nextInt() - 1, b = in.nextInt() - 1;
    Dijkstra dijkstra = new Dijkstra(n);

    for (int i = 0; i < n; i++) {
      int k = in.nextInt();
      for (int i1 = 0; i1 < k; i1++) {
        int to = in.nextInt() - 1;
        dijkstra.addEdge(i, to, (i1 == 0) ? 0 : 1);
      }
    }
    dijkstra.solve(a);
    int ans = dijkstra.dist[b];
    out.println((ans == Dijkstra.INF_DIST) ? -1 : ans);
  }
}
