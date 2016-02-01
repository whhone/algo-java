package weapon.math;

/**
 * Nimber. Grundy Number. Sprague–Grundy theorem.
 */
public class Nimber {
  public int x;

  public Nimber() {
    this.x = 0;
  }

  public Nimber add(int value) {
    this.x ^= value;
    return this;
  }

  public Nimber mul(int value) {
    throw new RuntimeException("TODO");
  }

  public int getValue() {
    return x;
  }

  public static int getGrundyNumber(int[] reachableValues) {
    boolean[] b = new boolean[reachableValues.length];
    for (int reachableValue: reachableValues) {
      if (reachableValue < b.length)
        b[reachableValue] = true;
    }
    int sg = 0;
    while (b[sg]) {
      ++sg;
    }
    return sg;
  }
}
