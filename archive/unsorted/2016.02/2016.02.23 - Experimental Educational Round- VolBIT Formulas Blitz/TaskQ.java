package workspace;

import weapon.io.InputReader;
import weapon.io.OutputWriter;

public class TaskQ {
  double getAngle(int k) {
    return (k - 2) * Math.PI / k / 2;
  }

  double getHeight(int k) {
    double dToC = 0.5 / Math.cos(getAngle(k));
    return Math.sqrt(1 - dToC * dToC);
  }

  double getArea(int k) {
    double height = 0.5 * Math.tan(getAngle(k));
    return height / 2 * k;
  }

  double getVolumn(int k) {
    return getHeight(k) * getArea(k) / 3;
  }

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    double l3 = in.nextDouble();
    double l4 = in.nextDouble();
    double l5 = in.nextDouble();

    out.println(getVolumn(3) * l3 * l3 * l3 + getVolumn(4) * l4 * l4 * l4 + getVolumn(5) * l5 * l5 *l5);

  }
}
