package workspace;

import weapon.graph.flow.MaxFlow;
import weapon.io.InputReader;
import weapon.io.OutputWriter;

public class TaskD {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int N = in.nextInt();
    int M = in.nextInt();
    int X = in.nextInt();

    int[] a = new int[M];
    int[] b = new int[M];
    int[] c = new int[M];

    for (int i = 0; i < M; i++) {
      a[i] = in.nextInt() - 1;
      b[i] = in.nextInt() - 1;
      c[i] = in.nextInt();
    }

    double low = 0, high = 1000000;

    while ((high - low) * X > 1e-8 ) {
      double m = (low + high) / 2;
      MaxFlow mf = new MaxFlow(N);
      for (int i = 0; i < M; i++) {
        mf.addEdge(a[i], b[i], (int)Math.floor(c[i] / m));
      }
      int flow = mf.solve(0, N - 1);

      if (flow >= X) {
        low = m;
      } else {
        high = m;
      }
    }

    out.println((low + high) * X / 2);
  }
}
