package workspace;

import weapon.graph.flow.MinCostFlow;
import weapon.io.InputReader;
import weapon.io.OutputWriter;

public class POJ2516 {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    do {
      int N = in.nextInt(), M = in.nextInt(), K = in.nextInt();
      if (N == 0) break;

      int[] goods = new int[K];
      int[][] need = new int[N][K];
      int[][] supply = new int[M][K];
      for (int i = 0; i < N; i++) {
        for (int j = 0; j < K; j++) {
          need[i][j] = in.nextInt();
          goods[j] += need[i][j];
        }
      }

      for (int i = 0; i < M; i++) {
        for (int j = 0; j < K; j++) {
          supply[i][j] = in.nextInt();
          goods[j] -= supply[i][j];
        }
      }

      boolean enough = true;
      for (int i = 0; i < K; i++) {
        if (goods[i] > 0) {
          enough = false;
        }
      }

      if (!enough) {
        for (int i = 0; i < K; i++) {
          for (int j = 0; j < N; j++) {
            for (int k = 0; k < M; k++) {
              in.nextInt();
            }
          }
        }
        out.println(-1);
      } else {
        int ans = 0;
        for (int i = 0; i < K; i++) {
          int S = 0, T = N + M + 1;
          MinCostFlow mcf = MinCostFlow.bySPFA(T + 1);
          for (int j = 0; j < N; j++) {
            mcf.addEdge(S, 1 + j, 0, need[j][i]);
          }
          for (int j = 0; j < M; j++) {
            mcf.addEdge(1 + N + j, T, 0, supply[j][i]);
          }
          for (int j = 0; j < N; j++) {
            for (int k = 0; k < M; k++) {
              int cost = in.nextInt();
              mcf.addEdge(1 + j, 1 + N + k, cost, (1 << 20));
            }
          }
          mcf.solve(S, T);
          ans += mcf.getMinCost();
        }
        out.println(ans);
      }
    } while (true);
  }
}
