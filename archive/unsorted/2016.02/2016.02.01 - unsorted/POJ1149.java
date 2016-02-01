package workspace;

import utils.InputReader;
import utils.OutputWriter;
import weapon.graph.MaxFlow;

public class POJ1149 {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int m = in.nextInt();
    int n = in.nextInt();
    MaxFlow maxFlow = new MaxFlow(m + n + 2);
    int S = 0, T = 1 + n + m;

    for (int i = 1; i <= m; i++) {
      maxFlow.addEdge(0, i, in.nextInt());
    }

    boolean[][] b = new boolean[n][m];

    for (int i = 0; i < n; i++) {
      int customer = 1 + m + i;

      int K = in.nextInt();
      for (int j = 0; j < K; j++) {
        b[i][in.nextInt() - 1] = true;
      }

      for (int j = 0; j < m; j++) {
        if (b[i][j]) {
          maxFlow.addEdge(1 + j, customer, Integer.MAX_VALUE);
        }
      }

      for (int j = 0; j < i; ++j) {
        boolean ok = false;
        for (int k = 0; k < m; ++k) {
          if (b[i][k] && b[j][k]) {
            ok = true;
          }
        }
        if (ok) {
          maxFlow.addEdge(1 + m + j, 1 + m + i, Integer.MAX_VALUE);
        }
      }

      maxFlow.addEdge(customer, T, in.nextInt());
    }
    out.println(maxFlow.solve(S, T));
  }
}
