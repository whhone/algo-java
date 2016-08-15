package workspace;

import weapon.graph.BipartiteMatching;
import weapon.graph.flow.MaxFlow;
import weapon.io.InputReader;
import weapon.io.OutputWriter;

import java.util.HashMap;

public class C {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int N = in.nextInt();

    HashMap<String, Integer> mx = new HashMap<String, Integer>();
    HashMap<String, Integer> my = new HashMap<String, Integer>();

    int[] a = new int[N];
    int[] b = new int[N];

    for (int i = 0; i < N; i++) {
      String x = in.next();
      String y = in.next();

      if (!mx.containsKey(x)) {
        mx.put(x, mx.size() + 1);
      }
      a[i] = mx.get(x);
      if (!my.containsKey(y)) {
        my.put(y, my.size() + 1);
      }
      b[i] = my.get(y);
    }
    BipartiteMatching m = new BipartiteMatching(mx.size(), my.size());

    for (int i = 0; i < N; i++) {
      m.connect(a[i] - 1, b[i] - 1);
    }
    m.solve();

    out.printf("Case #%d: %d\n", testNumber, N - mx.size() - my.size() + m.ansCount);
  }
}
