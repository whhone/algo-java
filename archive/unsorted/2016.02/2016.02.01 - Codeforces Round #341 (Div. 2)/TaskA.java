package workspace;

import weapon.io.InputReader;
import weapon.io.OutputWriter;

public class TaskA {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    long sum = 0;
    long countOdd = 0;
    long minOdd = 999999999;
    for (int i = 0; i < n; i++) {
      long k = in.nextInt();
      sum += k;
      if (k % 2 == 1) {
        countOdd++;
        minOdd = Math.min(minOdd, k);
      }
    }
    if (countOdd % 2 == 1) {
      sum -= minOdd;
    }
    out.println(sum);
  }
}
