package workspace;

import weapon.io.InputReader;
import weapon.io.OutputWriter;
import weapon.lab.Strings;

public class TaskC {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int N = in.nextInt();
    long[] c = new long[N];
    String[] s = new String[N];

    for (int i = 0; i < N; i++) {
      c[i] = in.nextLong();
    }

    for (int i = 0; i < N; i++) {
      s[i] = in.nextLine();
    }

    long[][] dp = new long[N][2];
    dp[0][0] = 0;
    dp[0][1] = c[0];

    for (int i = 1; i < N; i++) {
      dp[i][0] = dp[i][1] = Long.MAX_VALUE;

      if (dp[i-1][0] != Long.MAX_VALUE && s[i].compareTo(s[i-1]) >= 0) {
        dp[i][0] = Math.min(dp[i][0], dp[i-1][0]);
      }

      if (dp[i-1][1] != Long.MAX_VALUE && s[i].compareTo(Strings.reverse(s[i-1])) >= 0) {
        dp[i][0] = Math.min(dp[i][0], dp[i-1][1]);
      }

      if (dp[i-1][0] != Long.MAX_VALUE && Strings.reverse(s[i]).compareTo(s[i-1]) >= 0) {
        dp[i][1] = Math.min(dp[i][1], dp[i-1][0] + c[i]);
      }

      if (dp[i-1][1] != Long.MAX_VALUE && Strings.reverse(s[i]).compareTo(Strings.reverse(s[i-1])) >= 0) {
        dp[i][1] = Math.min(dp[i][1], dp[i-1][1] + c[i]);
      }
    }

    long ans = Math.min(dp[N-1][0], dp[N-1][1]);
    if (ans == Long.MAX_VALUE) ans = -1;
    out.println(ans);
  }
}
