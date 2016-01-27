package weapon;

public class Nim {
  public int x;

  public Nim() {
    this.x = 0;
  }

  public Nim add(int xor) {
    this.x ^= xor;
    return this;
  }

  public int get() {
    return x;
  }
}
