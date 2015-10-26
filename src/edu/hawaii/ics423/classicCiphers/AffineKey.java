/**
 * Copyright (c) Mark Nelson - 2015 - All rights reserved.
 */
package edu.hawaii.ics423.classicCiphers;

import edu.hawaii.ics423.coding.BaseUtils;

/**
 * The key for an Affine cipher.
 *
 * Note: This implementation does not calculate inverse of an encryption key.
 * Therefore, the user of this class is expected to do so.
 *
 * Consequently, users will create two AffineKeys. One used for encryption and
 * another used for decryption.
 *
 * Keys may be represented as char, int or Strings.
 *
 * @author Mark Nelson
 * @see https://en.wikipedia.org/wiki/Affine_cipher
 */
public class AffineKey implements Key {

  /** The multiplicative elements of the key. */
  private int a[];

  /** The additive elements of the key. */
  private int b[];

  /** The number base of the key system. */
  private BaseUtils base;


  /**
   * Create a new Affine Key.
   *
   * @param inA
   *          The multiplicative term.
   * @param inB
   *          The additive term.
   */
  public AffineKey(final int inA, final int inB, final BaseUtils inBase) {

    if (inA < 0) {
      throw new UnsupportedOperationException("The multipliciative term inA can not be negative");
    }

    if (inA >= inBase.getCipherBase()) {
      throw new UnsupportedOperationException(
          "The multiplicative term inA can not exceed the base of the number system");
    }

    if (inB < 0) {
      throw new UnsupportedOperationException("The additive term inB can not be negative");
    }

    if (inB >= inBase.getCipherBase()) {
      throw new UnsupportedOperationException("The additive term inB can not exceed the base of the number system");
    }

    a = new int[1];
    b = new int[1];

    this.a[0] = inA;
    this.b[0] = inB;
    this.base = inBase;
  }


  /**
   * Create a new Affine key.
   *
   * @param inA
   *          The multiplicative character.
   * @param inB
   *          The additive character.
   * @param inBase
   *          The number base for this key.
   */
  public AffineKey(final char inA, final char inB, final BaseUtils inBase) {
    this(inBase.charToInt(inA), inBase.charToInt(inB), inBase);
  }


  /**
   * Create a new Affine key.
   *
   * @param inA
   *          The multiplicative integer.
   * @param inB
   *          The additive character.
   * @param inBase
   *          The number base for this key.
   */
  public AffineKey(final int inA, final char inB, final BaseUtils inBase) {
    this(inA, inBase.charToInt(inB), inBase);
  }


  /**
   * Create a new Affine key.
   *
   * @param inA
   *          The multiplicative character.
   * @param inB
   *          The additive integer.
   * @param inBase
   *          The number base for this key.
   */
  public AffineKey(final char inA, final int inB, final BaseUtils inBase) {
    this(inBase.charToInt(inA), inB, inBase);
  }


  /**
   * Create a new Affine key.
   *
   * @param inA
   *          The multiplicative string.
   * @param inB
   *          The additive string.
   * @param inBase
   *          The number base for this key.
   */
  public AffineKey(final String inA, final String inB, final BaseUtils inBase) {
    this.a = inBase.stringToIntArray(inA);
    this.b = inBase.stringToIntArray(inB);
    this.base = inBase;
  }


  /**
   * Get the cipher key.
   *
   * @return This key.
   */
  @Override
  public final AffineKey getKey() {
    return this;
  }


  /**
   * Get the first multiplicative term.
   *
   * @return The multiplative term.
   */
  public final int getA() {
    return this.a[0];
  }


  /**
   * Get a multiplicative term.
   *
   * @param i
   *          The term to get (mod with the length of a).
   * @return The multiplative term.
   */
  public final int getA(final int i) {
    return this.a[i % a.length];
  }


  /**
   * Get the first additive term.
   *
   * @return The additive term.
   */
  public final int getB() {
    return this.b[0];
  }


  /**
   * Get an additive term.
   *
   * @param i
   *          The term to get (mod with the length of b).
   * @return The additive term.
   */
  public final int getB(final int i) {
    return this.b[i % b.length];
  }


  @Override
  public void printKey(String prefix, String suffix) {
    if (a.length == 1 && b.length == 1) {
      System.out.println(prefix + "Affine key a = [" + this.getA() + "(" + base.intToChar(this.getA()) + ")] "
                                           + "b = [" + this.getB() + "(" + base.intToChar(this.getB()) + ")]" + suffix);
    } else {
      System.out.println(prefix + "Affine key" + suffix);
      System.out.print(prefix + "  a: ");
      base.printIntArray(this.a);
      System.out.print(prefix + "  b: ");
      base.printIntArray(this.b);

    }
  }

}
