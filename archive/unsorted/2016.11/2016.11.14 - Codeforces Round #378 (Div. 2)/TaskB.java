package workspace;

import weapon.io.InputReader;
import weapon.io.OutputWriter;

public class TaskB {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int N = in.nextInt();
    int[] l = new int[N];
    int[] r = new int[N];
    int L = 0;
    int R = 0;
    for (int i = 0; i < N; i++) {
      l[i] = in.nextInt();
      r[i] = in.nextInt();
      L += l[i];
      R += r[i];
    }

    int MX = Math.abs(L - R);
    int ans = -1;

    for (int i = 0; i < N; i++) {
      int V = Math.abs((L - l[i] + r[i]) - (R - r[i] + l[i]));
      if (V > MX) {
        MX = V;
        ans = i;
      }
    }

    out.println(ans + 1);
  }
}
