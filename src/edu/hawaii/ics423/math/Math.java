/**
 * Copyright (c) Mark Nelson - 2015 - All rights reserved.
 */
package edu.hawaii.ics423.math;

import java.math.BigInteger;

/**
 * Mathematical algorithms in support of ICS 423.
 *
 * @author Mark Nelson
 */
public class Math {

  /**
   * Compute the multiplicative Inverse of two values.
   *
   * @param a The number to invert.
   * @param b The number base.
   *
   * @return The multiplicative invere of a in base b.
   */
  public static int multiplicativeInverse(final int a, final int b) {
    // Two numbers are relatively prime if they have no
    // common factors, other than 1.
    BigInteger bi1 = new BigInteger(new Integer(a).toString());
    BigInteger bi2 = new BigInteger(new Integer(b).toString());

    // perform modInverse operation on bi1 using bi2
    BigInteger bi3 = bi1.modInverse(bi2);

    //System.out.println( bi1 + "^-1 mod " + bi2 + " is " +bi3 );
    return bi3.intValue();
  }

  /**
   * Use the Extended Euclidean Algorithm to derive the greatest common divisor
   * from two numbers.
   *
   * @param a
   *          The first number.
   * @param b
   *          The second number.
   * @return The greatest common divisor between a and b.
   */
  public static int gcd(final int a, final int b) {
    int r0 = a;
    int r1 = b;
    int s0 = 1;
    int s1 = 0;
    int t0 = 0;
    int t1 = 1;

    while (r1 != 0) {
      int q = r0 / r1;

      int temp = r0;

      r0 = r1;

      r1 = temp - q * r1;

      temp = s0;

      s0 = s1;

      s1 = temp - q * s1;

      temp = t0;

      t0 = t1;
      t1 = temp - q * t1;
    }

    // System.out.println("r0 = " + r0);
    // System.out.println("s0 = " + s0);
    // System.out.println("t0 = " + t0);

    System.out.println("gcd(" + a + ", " + b + ") = " + r0);

    return r0;
  }

}
