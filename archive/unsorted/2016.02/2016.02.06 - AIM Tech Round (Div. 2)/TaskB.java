package workspace;

import weapon.io.InputReader;
import weapon.io.OutputWriter;

import java.util.Arrays;
import java.util.Collections;

public class TaskB {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int N = in.nextInt();
    Long[] a = new Long[N];
    for (int i = 0; i < N; i++) {
      a[i] = in.nextLong();
    }
    Arrays.sort(a, Collections.reverseOrder());
    long ans = a[0];
    long mx = a[0];
    for (int i = 1; i < N; i++) {
      if (a[i] >= mx) {
        a[i] = mx - 1;
      }
      if (a[i] >= 0) {
        ans += a[i];
        mx = a[i];
      }
    }
    out.println(ans);
  }
}
