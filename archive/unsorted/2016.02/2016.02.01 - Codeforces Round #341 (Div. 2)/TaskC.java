package workspace;

import utils.InputReader;
import utils.OutputWriter;

public class TaskC {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int p = in.nextInt();
    double a[] = new double[n];
    double dp[][] = new double[n][2];

    for (int i = 0; i < n; i++) {
      int l = in.nextInt();
      int r = in.nextInt();
      double count = r / p - (l - 1) / p;
      a[i] = count / (r - l + 1);
    }

    dp[0][0] = 0;
    dp[0][1] = 0;
    for (int i = 1; i <= n; i++) {
      dp[i % n][0] = (dp[i - 1][1] + 2000) * a[i - 1] + dp[i - 1][0] * (1 - a[i - 1]);
      dp[i % n][1] = (dp[i - 1][1] + 2000) * a[i - 1] + (dp[i - 1][0] + 2000) * (1 - a[i - 1]);
    }

    out.println((dp[0][0] * (1 - a[0]) + dp[0][1] * a[0]));
  }
}
