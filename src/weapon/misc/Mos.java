package weapon.misc;

import java.util.Arrays;
import java.util.Comparator;

/**
 * The implementation of Mo's Algorithm.
 *
 * Time Complexity: O((N + M) * sqrt(N) * F)
 *
 * Tutorial:
 *  - https://www.hackerearth.com/notes/mos-algorithm/
 *  - http://blog.anudeep2011.com/mos-algorithm/
 *
 * Sample Problems:
 *  - http://codeforces.com/contest/86/problem/D
 *  - http://codeforces.com/contest/340/problem/E
 *  - http://codeforces.com/contest/351/problem/D
 *  - http://www.codechef.com/problems/IITI15
 */
public abstract class Mos {

  final protected static Comparator<Query> CmpB = new Comparator<Query>() {
    public int compare(Query a, Query b) {
      if (a.b != b.b) {
        return a.b - b.b;
      } else {
        return a.r - b.r;
      }
    }
  };

  public int blockSize, sizeOfArray, numOfQuery;
  public Query[] queries;
  public long[] answers;
  public int curLeft, curRight;

  public long curAns;

  public Mos(int sizeOfArray, int numOfQuery) {
    this.sizeOfArray = sizeOfArray;
    this.numOfQuery = numOfQuery;

    this.curLeft = 0;
    this.curRight = -1;
    this.curAns = 0;
    this.answers = new long[numOfQuery];
    this.queries = new Query[numOfQuery];
    this.blockSize = (int) Math.sqrt(sizeOfArray + 0.5);
  }

  public abstract void rightRight();

  public abstract void rightLeft();

  public abstract void leftRight();

  public abstract void leftLeft();

  public void setQuery(int i, int l, int r) {
    this.queries[i] = new Query(i, l, r);
  }

  public void exec() {
    Arrays.sort(this.queries, CmpB);
    for (int i = 0; i < numOfQuery; ++i) {
      while (curRight < queries[i].r) {
        rightRight(); // ++curRight
      }
      while (curRight > queries[i].r) {
        rightLeft(); // --curRight
      }
      while (curLeft < queries[i].l) {
        leftRight(); // ++curLeft
      }
      while (curLeft > queries[i].l) {
        leftLeft(); // --curLeft
      }
      answers[queries[i].i] = this.curAns;
    }
  }

  public long getAnswer(int i) {
    return this.answers[i];
  }

  public class Query {
    public int i, l, r, b;

    public Query(int i, int l, int r) {
      this.i = i;
      this.l = l;
      this.r = r;
      this.b = l / blockSize;
    }
  }
}
