package workspace;

import weapon.graph.flow.MinCostFlow;
import weapon.io.InputReader;
import weapon.io.OutputWriter;

public class POJ3422 {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int N = in.nextInt(), K = in.nextInt(), NN = N * N, S = NN * 2, T = NN * 2 - 1;
    MinCostFlow f = MinCostFlow.bySPFA(NN * 2 + 1);
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        int u = i * N + j;
        f.addEdge(u, u + NN, -in.nextInt(), 1);
        f.addEdge(u, u + NN, 0, K);
        if (i > 0) {
          f.addEdge(u - N + NN, u, 0, K);
        }
        if (j > 0) {
          f.addEdge(u - 1 + NN, u, 0, K);
        }
      }
    }
    f.addEdge(S, 0, 0, K);
    f.solve(S, T);
    out.println(-f.getMinCost());
  }
}
