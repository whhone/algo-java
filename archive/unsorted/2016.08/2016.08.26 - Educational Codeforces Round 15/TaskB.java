package workspace;

import weapon.datastructures.MultiSet;
import weapon.io.InputReader;
import weapon.io.OutputWriter;

public class TaskB {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int N = in.nextInt();
    int[] a = in.nextIntArray(N);
    long ans = 0;
    MultiSet<Integer> ms = new MultiSet<Integer>();
    for (int i = 0; i < N; i++) {
      for (int j = 1; j <= 30; j++) {
        int sum = (1 << j);
        int b = sum - a[i];
        ans += ms.count(b);
      }
      ms.add(a[i]);
    }
    out.println(ans);
  }
}
