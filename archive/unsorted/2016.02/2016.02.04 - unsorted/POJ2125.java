package workspace;

import weapon.io.InputReader;
import weapon.io.OutputWriter;
import weapon.graph.MaxFlow;

import java.util.ArrayList;

public class POJ2125 {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
//    int N = in.nextInt();
//    int M = in.nextInt();
//    int S = 0, T = 1 + 2 * N;
//    MaxFlow flow = new MaxFlow(2 * N + 2);
//    for (int i = 0; i < N; i++) {
//      flow.addEdge(i + 1 + N, T, in.nextInt());
//    }
//    for (int i = 0; i < N; i++) {
//      flow.addEdge(S, 1 + i, in.nextInt());
//    }
//    for (int i = 0; i < M; i++) {
//      flow.addEdge(in.nextInt(), in.nextInt() + N, Integer.MAX_VALUE);
//    }
//
//    out.println(flow.solve(S, T));
//    ArrayList<MaxFlow.Edge> minCutEdges = flow.minCutEdges(S, T);
//    out.println(minCutEdges.size());
//    for (MaxFlow.Edge edge : minCutEdges) {
//      if (edge.u == S) {
//        out.printf("%d -\n", edge.v);
//      } else if (edge.v == T) {
//        out.printf("%d +\n", edge.u - N);
//      }
//    }
  }
}
