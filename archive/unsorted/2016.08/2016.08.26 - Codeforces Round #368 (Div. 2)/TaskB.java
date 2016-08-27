package workspace;

import weapon.io.InputReader;
import weapon.io.OutputWriter;

public class TaskB {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int N = in.nextInt();
    int M = in.nextInt();
    int K = in.nextInt();
    int[] u = new int[M];
    int[] v = new int[M];
    int[] c = new int[M];
    boolean[] s = new boolean[N + 1];
    int ans = Integer.MAX_VALUE;

    for (int i = 0; i < M; i++) {
      u[i] = in.nextInt();
      v[i] = in.nextInt();
      c[i] = in.nextInt();
    }

    for (int i = 0; i < K; i++) {
      int t = in.nextInt();
      s[t] = true;
    }

    for (int i = 0; i < M; i++) {
      if (s[u[i]] ^ s[v[i]]) {
        ans = Math.min(ans, c[i]);
      }
    }

    if (ans == Integer.MAX_VALUE) {
      ans = -1;
    }

    out.println(ans);
  }
}
