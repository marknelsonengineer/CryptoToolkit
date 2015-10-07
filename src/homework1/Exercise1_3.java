package homework1;

import org.junit.Test;

import edu.hawaii.ics423.math.Math;

public class Exercise1_3 {

  @Test
  public void test() {
    org.junit.Assert.assertEquals(Math.gcd(65, 78), 13);

    org.junit.Assert.assertEquals(Math.gcd(323, 408), 17);
  }

}
