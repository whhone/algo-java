package workspace;

import utils.InputReader;
import utils.OutputWriter;
import weapon.graph.MaxFlow;

import java.util.Scanner;

public class POJ1273 {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    while (in.hasNext()) {
      int n = in.nextInt();
      int m = in.nextInt();
      MaxFlow flow = new MaxFlow(m);
      for (int i = 0; i < n; i++) {
        flow.addEdge(in.nextInt() - 1, in.nextInt() - 1, in.nextInt());
      }
      out.println(flow.solve(0, m - 1));
    }
  }
}
