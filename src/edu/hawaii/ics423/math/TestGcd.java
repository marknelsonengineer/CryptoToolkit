package edu.hawaii.ics423.math;

import org.junit.Test;

public class TestGcd {

  @Test
  public void test() {
    org.junit.Assert.assertEquals(Math.gcd(26, 11), 1);

    org.junit.Assert.assertEquals(Math.gcd(12, 8), 4);
    org.junit.Assert.assertEquals(Math.gcd(8, 12), 4);

    org.junit.Assert.assertEquals(Math.gcd(54, 24), 6);
  }

}
