package workspace;

import weapon.io.InputReader;
import weapon.io.OutputWriter;

public class TaskA {

  long hash1(long a, long b) {
    return a ^ b;
  }

  long hash2(long a, long b) {
    return a ^ (13 * b + 1238);
  }

  long hash3(long a, long b) {
    return a ^ (123 * b + 98765);
  }

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int T = in.nextInt();

    while (T-- > 0) {
      int prev = 0;
      int N = in.nextInt();
      int[] a = in.nextIntArray(N);
      int[] b = in.nextIntArray(N);
      long ha1 = 0, ha2 = 0, ha3 = 0;
      long hb1 = 0, hb2 = 0, hb3 = 0;

      for (int i = 0; i < N; i++) {
        ha1 = hash1(ha1, a[i]);
        ha2 = hash2(ha2, a[i]);
        ha3 = hash3(ha3, a[i]);

        hb1 = hash1(hb1, b[i]);
        hb2 = hash2(hb2, b[i]);
        hb3 = hash3(hb3, b[i]);

        if (ha1 == hb1 && ha2 == hb2 && ha3 == hb3) {
          if (prev != 0) {
            out.print(" ");
          }
          out.printf("%d-%d", prev + 1, i + 1);
          prev = i + 1;
          ha1 = ha2 = ha3 = hb1 = hb2 = hb3 = 0;
        }
      }
      out.println();
    }
  }
}
