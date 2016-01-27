package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class TaskB {
  public void solve(int testNumber, Scanner in, PrintWriter out) {
    int N = in.nextInt();
    int ans = 0;
    int[] a = new int[N];
    int[][] dp = new int[N][3];

    for (int i = 0; i < N; ++i) {
      a[i] = in.nextInt();
    }

    dp[0][0] = dp[0][1] = dp[0][2] = 0;

    for (int i = 1; i < N; ++i) {
      if (a[i] == a[i - 1]) {
        dp[i][0] = dp[i - 1][0];
        dp[i][1] = dp[i - 1][1];
        dp[i][2] = dp[i - 1][2];
      } else if (a[i] > a[i - 1]) {
        dp[i][0] = i;
        dp[i][1] = dp[i - 1][2];
        dp[i][2] = i;
      } else {
        dp[i][0] = i;
        dp[i][1] = i;
        dp[i][2] = dp[i - 1][1];
      }
      for (int j = 0; j < 3; ++j) {
        ans = Math.max(i - dp[i][j] + 1, ans);
      }
    }

    out.println(ans);
  }
}
