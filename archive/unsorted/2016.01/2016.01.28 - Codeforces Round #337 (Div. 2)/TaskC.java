package workspace;

import utils.InputReader;
import utils.OutputWriter;

public class TaskC {

  int[][] make(int k) {
    if (k == 0) {
      int[][] A = new int[1][1];
      A[0][0] = 1;
      return A;
    }
    int[][] a = make(k - 1);
    int N = a.length;
    int[][] A = new int[N * 2][N * 2];

    for (int i = 0; i < N; ++i) {
      for (int j = 0; j < N; ++j) {
        A[i][2 * j] = A[i][2 * j + 1] = a[i][j];
      }
    }
    for (int i = 0; i < N; ++i) {
      for (int j = 0; j < N; ++j) {
        A[i+N][2 * j] = a[i][j];
        A[i+N][2 * j + 1] = -a[i][j];
      }
    }
    return A;
  }

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int[][] ans = make(in.nextInt());
    for (int i = 0; i < ans.length; ++i) {
      for (int j = 0; j < ans.length; ++j) {
        if (ans[i][j] == 1)out.print("+");
        else out.print("*");
      }
      out.println();
    }
  }
}
