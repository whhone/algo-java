package workspace;

import weapon.io.InputReader;
import weapon.io.OutputWriter;

public class TaskC {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int N = in.nextInt();

    int odd = 1;
    int even = 2;

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (Math.abs(i - N / 2) + Math.abs(j - N / 2) <= N / 2) {
          out.print(odd);
          odd += 2;
        } else {
          out.print(even);
          even += 2;
        }
        if (j < N - 1) {
          out.print(" ");
        } else {
          out.println();
        }
      }

    }
  }
}
