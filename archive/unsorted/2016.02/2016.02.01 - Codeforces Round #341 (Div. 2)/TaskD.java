package workspace;

import weapon.io.InputReader;
import weapon.io.OutputWriter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TaskD {

  double mx = 0;
  String ans = "";

  void check(double value, String exp) {
    if (value > mx + 1e-15) {
      mx  = value;
      ans = exp;
    }
  }

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    double x = in.nextDouble();
    double y = in.nextDouble();
    double z = in.nextDouble();

    BigDecimal bx = BigDecimal.valueOf(x);
    BigDecimal by = BigDecimal.valueOf(y);
    BigDecimal bz = BigDecimal.valueOf(z);

    check(Math.pow(x, Math.pow(y, z)), "x^y^z");
    check(Math.pow(x, Math.pow(z, y)), "x^z^y");
    check(Math.pow(Math.pow(x, y), z), "(x^y)^z");
    check(Math.pow(Math.pow(x, z), y), "(x^z)^y");

    check(Math.pow(y, Math.pow(x, z)), "y^x^z");
    check(Math.pow(y, Math.pow(z, x)), "y^z^x");
    check(Math.pow(Math.pow(y, x), z), "(y^x)^z");
    check(Math.pow(Math.pow(y, z), x), "(y^z)^x");

    check(Math.pow(z, Math.pow(x, y)), "z^x^y");
    check(Math.pow(z, Math.pow(y, x)), "z^y^x");
    check(Math.pow(Math.pow(z, x), y), "(z^x)^y");
    check(Math.pow(Math.pow(z, y), x), "(z^y)^x");

    out.println(ans);
  }
}
