package workspace;

import weapon.Nim;

import java.util.Scanner;
import java.io.PrintWriter;

public class TaskA {

  long parse(Scanner in) {
    int n = in.nextInt();
    int b = in.nextInt();
    long x = 0;
    for (int i = 0; i < n; ++i) {
      long l = in.nextLong();
      x = x * b + l;
    }
    return x;
  }

  public void solve(int testNumber, Scanner in, PrintWriter out) {
    long x = parse(in);
    long y = parse(in);
    if (x == y) out.println("=");
    if (x > y) out.println(">");
    if (x < y) out.println("<");
  }
}
