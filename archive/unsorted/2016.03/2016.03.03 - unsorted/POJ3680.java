package workspace;

import weapon.graph.flow.MinCostFlow;
import weapon.io.InputReader;
import weapon.io.OutputWriter;

import java.util.Arrays;

public class POJ3680 {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int[] a = new int[205];
    int[] b = new int[205];
    int[] w = new int[205];
    int[] all = new int[405];
    int[] mp = new int[100005];

    int TTT = in.nextInt();
    for (int ttt = 0; ttt < TTT; ttt++) {
      int N = in.nextInt(), K = in.nextInt();

      for (int i = 0; i < N; i++) {
        a[i] = in.nextInt();
        b[i] = in.nextInt();
        w[i] = in.nextInt();
        all[i * 2] = a[i];
        all[i * 2 + 1] = b[i];
      }

      int NN = N + N;
      Arrays.sort(all, 0, NN);
      for (int i = 0; i < NN; i++) {
        mp[all[i]] = i;
      }
      int S = 0, T = 2 * N + 1;
      MinCostFlow mcf = MinCostFlow.byDijkstra(2 * N + 2);
      for (int i = 0; i < N; i++) {
        mcf.addEdge(mp[a[i]], mp[b[i]], -w[i], 1);
      }
      for (int i = 1; i <= T; i++) {
        mcf.addEdge(i - 1, i, 0, K);
      }
      mcf.solve(S, T);
      out.println(-mcf.getMinCost());
    }
  }
}
