package weapon.datastructures;

/**
 * 2D Binary Indexed Tree. Support two kinds of operations,
 *   1) add from value to a point;
 *   2) query the sum of a range;
 */
public class BinaryIndexedTree2D {

  public int N, M;
  public int[][] a;

  public BinaryIndexedTree2D(int N, int M) {
    this.N = N;
    this.M = M;
    this.a = new int[N + 1][M + 1];
  }

  public void addValue(int x, int y, int value) {
    for (int i = x; i <= N; i += i & -i) {
      for (int j = y; j <= M; j += j & -j) {
        this.a[i][j] += value;
      }
    }
  }

  public int querySum(int xMin, int yMin, int xMax, int yMax) {
    return sum(xMax, yMax) + sum(xMin - 1, yMin - 1) - sum(xMax, yMin - 1) - sum(xMin - 1, yMax);
  }

  public int sum(int x, int y) {
    int sum = 0;
    for (int i = x; i > 0; i -= i & -i) {
      for (int j = y; j > 0; j -= j & -j) {
        sum += this.a[i][j];
      }
    }
    return sum;
  }
}
