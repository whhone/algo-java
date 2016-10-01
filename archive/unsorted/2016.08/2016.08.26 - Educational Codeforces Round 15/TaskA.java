package workspace;

import weapon.io.InputReader;
import weapon.io.OutputWriter;

public class TaskA {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int N = in.nextInt();
    int[] a = in.nextIntArray(N);
    int ans = 0;
    int tmp = 1;

    for (int i = 1; i < N; i++) {
      if (a[i] > a[i - 1]) {
        tmp++;
      } else {
        ans = Math.max(ans, tmp);
        tmp = 1;
      }
    }
    out.println(Math.max(ans, tmp));
  }
}
