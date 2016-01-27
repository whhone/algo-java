package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class TaskB {
  public void solve(int testNumber, Scanner in, PrintWriter out) {
    int N = in.nextInt();
    int[] a = new int[N];
    for (int i = 0; i < N; ++i) {
      a[i] = in.nextInt();
    }
    int count_1 = 0;
    long p = 1;
    long ans = 1;
    for (int i = 0; i < N; ++i) {
      if (a[i] == 0) {
        p++;
      } else {
        if (count_1 > 0) {
          ans *= p;
        }
        p = 1;
        count_1++;
      }
    }
    if (count_1 == 0) ans = 0;
    out.println(ans);
  }
}
