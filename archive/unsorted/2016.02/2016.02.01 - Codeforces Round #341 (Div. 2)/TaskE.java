package workspace;

import io.InputReader;
import io.OutputWriter;
import weapon.math.Matrix;

public class TaskE {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int b = in.nextInt();
    int k = in.nextInt();
    int x = in.nextInt();
    int[] cnt = new int[10];
    Matrix.setMod(1000000007);
    for (int i = 0; i < n; i++) {
      cnt[in.nextInt()]++;
    }
    Matrix m = new Matrix(x, x);
    for (int i = 0; i < x; i++) {
      for (int j = 1; j <= 9; j++) {
        int z = (i * 10 + j) % x;
        m.add(z, i, cnt[j]);
      }
    }
    Matrix result = m.power(b).multi(Matrix.getIdentity(x));
    out.println(result.get(k, 0));
  }
}
