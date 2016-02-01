package tests.math;

import org.junit.Test;
import weapon.math.Matrix;

import static junit.framework.TestCase.assertEquals;

public class MatrixTest {

  @Test
  public void testMulti() {
    Matrix m = new Matrix(3, 3);
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        m.set(i, j, 1);
      }
    }
    Matrix mm = m.multi(m);
    Matrix expected = new Matrix(3, 3);
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        expected.set(i, j, 3);
      }
    }
    assertEquals(expected, mm);
  }

  @Test
  public void testPow() {
    Matrix m = new Matrix(3, 3);
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        m.set(i, j, 1);
      }
    }
    Matrix m0 = m.power(0);
    assertEquals(Matrix.getIdentity(3), m0);

    long check = 1;
    for (int power = 1; power <= 20 ; power++) {
      Matrix mm = m.power(power);
      assertEquals(3, mm.m);
      assertEquals(3, mm.n);
      for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
          assertEquals(check, mm.get(i, j));
        }
      }
      check *= 3;
    }
  }
}
