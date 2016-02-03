package weapon.datastructures;

/**
 * Binary Indexed Tree. Support two kinds of operations,
 *   1) add from value to a point;
 *   2) query the sum of a range;
 */
public class BinaryIndexedTree {

  public int N;
  public int a[];

  public BinaryIndexedTree(int N) {
    this.N = N;
    this.a = new int[N + 1];
  }

  public void addValue(int pos, int value) {
    for (int i = pos; i <= N; i += i & -i) {
      this.a[i] += value;
    }
  }

  public int querySum(int left, int right) {
    return sum(right) - sum(left - 1);
  }

  private int sum(int n) {
    int r = 0;
    for (int i = n; i > 0 ; i -= i & -i) {
      r += a[i];
    }
    return r;
  }
}
