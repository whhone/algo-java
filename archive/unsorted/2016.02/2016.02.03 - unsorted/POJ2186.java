package workspace;

import weapon.io.InputReader;
import weapon.io.OutputWriter;
import weapon.graph.StronglyConnectedComponent;

public class POJ2186 {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int N = in.nextInt(), M = in.nextInt();
    int[] u = new int[M], v = new int[M];
    StronglyConnectedComponent scc = new StronglyConnectedComponent(N);

    for (int i = 0; i < M; i++) {
      u[i] = in.nextInt() - 1;
      v[i] = in.nextInt() - 1;
      scc.addEdge(u[i], v[i]);
    }

    scc.solve();

    boolean[] ok = new boolean[N];
    for (int i = 0; i < M; i++) {
      int sccu = scc.getNodeComponentId(u[i]);
      int sccv = scc.getNodeComponentId(v[i]);
      if (sccu != sccv) {
        ok[sccu] = true;
      }
    }

    int count = 0;
    int id = -1;
    for (int i = 0; i < scc.getComponentCount(); i++) {
      if (!ok[i]) {
        count++;
        id = i;
      }
    }
    int ans = 0;
    if (count == 1) {
      for (int i = 0; i < N; i++) {
        if (scc.getNodeComponentId(i) == id) {
          ++ans;
        }
      }
    }

    out.println(ans);
  }
}
