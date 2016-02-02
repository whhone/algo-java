package tests.misc;

import org.junit.Test;
import weapon.misc.Mos;

import java.util.Random;

import static junit.framework.TestCase.assertEquals;

public class MosTest {

  @Test
  public void test() {
    int sizeOfArray = 50;
    int numOfQuery = 50;

    final int[] a = new int[sizeOfArray];

    Mos mos = new Mos(sizeOfArray, numOfQuery) {

      @Override
      public void rightRight() {
        curRight++;
        curAns += a[curRight];
      }

      @Override
      public void rightLeft() {
        curAns -= a[curRight];
        --curRight;
      }

      @Override
      public void leftRight() {
        curAns -= a[curLeft];
        ++curLeft;
      }

      @Override
      public void leftLeft() {
        curLeft--;
        curAns += a[curLeft];
      }
    };

    for (int i = 0; i < sizeOfArray; i++) {
      a[i] = i;
    }

    Random random = new Random();
    int[] expectedAns = new int[numOfQuery];
    for (int i = 0; i < numOfQuery; i++) {
      int left = random.nextInt(sizeOfArray);
      int right = left + random.nextInt(sizeOfArray - left);
      mos.setQuery(i, left, right);
      expectedAns[i] = right * (right + 1) / 2 - (left - 1) * (left) / 2;
    }

    mos.exec();

    for (int i = 0; i < numOfQuery; i++) {
      assertEquals(expectedAns[i], mos.getAnswer(i));
    }
  }
}
