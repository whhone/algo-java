package workspace;

import weapon.io.InputReader;
import weapon.io.OutputWriter;
import weapon.graph.MaxFlow;

public class POJ3469 {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt(), m = in.nextInt();
    MaxFlow mf = new MaxFlow(n + 2);
    for (int i = 1; i <= n; i++) {
      mf.addEdge(0, i, in.nextInt());
      mf.addEdge(i, 1 + n, in.nextInt());
    }
    for (int i = 0; i < m; i++) {
      int a = in.nextInt(), b = in.nextInt(), c = in.nextInt();
      mf.addEdge(a, b, c);
      mf.addEdge(b, a, c);
    }
    out.println(mf.solve(0, 1 + n));
  }
}
