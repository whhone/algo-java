package workspace;

import utils.InputReader;
import utils.OutputWriter;
import weapon.graph.BipartiteMatching;

public class POJ3014 {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int N = in.nextInt();
    int K = in.nextInt();
    BipartiteMatching matching = new BipartiteMatching(N, N);
    for (int i = 0; i < K; i++) {
      matching.connect(in.nextInt() - 1, in.nextInt() - 1);
    }
    matching.solve();
    out.println(matching.ansCount);
  }
}
