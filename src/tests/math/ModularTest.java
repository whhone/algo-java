package tests.math;

import org.junit.Test;
import weapon.math.Modular;

import static junit.framework.TestCase.assertEquals;

public class ModularTest {

  @Test
  public void testPrime() {
    Modular mod = Modular.on(7);

    assertEquals(1, mod.inverseModPrime(1));
    assertEquals(4, mod.inverseModPrime(2));
    assertEquals(5, mod.inverseModPrime(3));
    assertEquals(2, mod.inverseModPrime(4));
    assertEquals(3, mod.inverseModPrime(5));
    assertEquals(6, mod.inverseModPrime(6));
  }
}
