package workspace;

import weapon.io.InputReader;
import weapon.io.OutputWriter;
import weapon.lab.ArrayUtils;

import java.util.Arrays;

public class TaskB {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int N = in.nextInt();
    int[] a = in.nextIntArray(N);
    ArrayUtils.sort(a);
    out.println(a[(N - 1) / 2]);
  }
}
