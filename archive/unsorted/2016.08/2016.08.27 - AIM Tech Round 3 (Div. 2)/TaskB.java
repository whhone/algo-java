package workspace;

import weapon.io.InputReader;
import weapon.io.OutputWriter;
import weapon.lab.ArrayUtils;

public class TaskB {

  int calc(int left, int right, int start) {
    if (start <= left) {
      return right - start;
    } else if (start >= right) {
      return start - left;
    } else {
      return Math.min(start - left, right - start) + right - left;
    }
  }

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int a = in.nextInt();
    int[] x = in.nextIntArray(n);
    ArrayUtils.sort(x);

    if (n == 1) {
      out.println(0);
    } else {
      out.println(Math.min(
          calc(x[0], x[x.length - 2], a),
          calc(x[1], x[x.length - 1], a)));
    }
  }
}
