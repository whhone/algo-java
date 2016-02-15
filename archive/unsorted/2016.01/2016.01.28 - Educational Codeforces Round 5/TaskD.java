package workspace;



import weapon.io.InputReader;
import weapon.io.OutputWriter;
import weapon.MultiSet;

import java.io.PrintWriter;
import java.util.HashMap;

public class TaskD {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int N = in.nextInt();
    int K = in.nextInt();
    int[] A = in.nextIntArray(N);

    MultiSet<Integer> ms = new MultiSet<Integer>();

    int j = 0;
    int ans = -1;
    int ansi = 0, ansj = 0;
    for (int i = 0; i < N; ++i) {
      ms.add(A[i]);
      while (ms.size() > K) {
        ms.remove(A[j]);
        ++j;
      }

      if (i - j > ans) {
        ans = i - j;
        ansi = i;
        ansj = j;
      }
    }
    out.printf("%d %d\n", ansj + 1, ansi + 1);
  }
}
