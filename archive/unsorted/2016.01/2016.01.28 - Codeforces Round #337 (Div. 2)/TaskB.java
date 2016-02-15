package workspace;

import weapon.lab.ArrayUtils;
import weapon.io.InputReader;
import weapon.io.OutputWriter;

public class TaskB {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int N = in.nextInt();
    int[] a = in.nextIntArray(N);
    long mn = ArrayUtils.findIntArrayMin(a);
    int NN = N + N;
    int count = 0;
    long ans = 0;
    for (int i = 0; i < NN; ++i) {
      if (a[i % N] != mn) {
        ++count;
      } else {
        ans = Math.max(ans, count);
        count = 0;
      }
    }
    ans = Math.max(ans, count);
    out.println(ans + N * mn);
  }
}
