package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class TaskA {
  public void solve(int testNumber, Scanner in, PrintWriter out) {
    int x = in.nextInt();
    out.println((x - 1) / 5 + 1);
  }
}
