package workspace;



import weapon.io.InputReader;
import weapon.io.OutputWriter;
import weapon.math.Combinatorics;

public class TaskF {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    out.println(Combinatorics.C(n, 5) + Combinatorics.C(n, 6) + Combinatorics.C(n, 7));
  }
}
