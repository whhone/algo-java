package workspace;

import weapon.io.InputReader;
import weapon.io.OutputWriter;
import weapon.math.NumberTheory;

public class TaskJ {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    long n = in.nextLong();
    long s = 1;
    for (int i = 2; i <= 10; i++) {
      s = s * i / NumberTheory.gcd(s, i);
    }
    out.println(n / s);
  }
}
