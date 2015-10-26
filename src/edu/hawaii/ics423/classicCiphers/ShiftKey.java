/**
 * Copyright (c) Mark Nelson - 2015 - All rights reserved.
 */
package edu.hawaii.ics423.classicCiphers;

import edu.hawaii.ics423.coding.BaseUtils;

/**
 * The key for a Monoalphabetic (Ceasar) Shift Cipher.
 *
 * @author Mark Nelson
 */
public class ShiftKey implements Key {

  /** The number of characters to shift. */
  private int shift;

  /** The number base of the key system. */
  private BaseUtils base;


  /**
   * Create a new Shift Key with an integer.
   *
   * @param inShift
   *          The number of characters to shift.
   * @param inBase
   *          The coding system used by the cipher.
   */
  public ShiftKey(final int inShift, final BaseUtils inBase) {
    this.base = inBase;
    // This logic deserves some explanation... Users can put anything
    // in inShift. Negatives, large numbers, etc. The first modulous
    // converts the number to a range from negative base, through 0 to
    // positive base. Next we add the base -- this gets us in the realm
    // of positive numbers. Finally we re-modulous the key to get the
    // number from 0 to base-1.
    this.shift = ((inShift % base.getCipherBase()) + base.getCipherBase()) % base.getCipherBase();
  }


  /**
   * Create a new Shift Key with a character.
   *
   * @param inShift
   *          The character to shift. A=0, B=1, ... Z=25
   * @param inBase
   *          The coding system used by the cipher.
   */
  public ShiftKey(final char inShift, final BaseUtils inBase) {
    this.shift = inBase.charToInt(inShift);
  }


  /**
   * Get the cipher key.
   *
   * @return This key.
   */
  @Override
  public ShiftKey getKey() {
    return this;
  }


  /**
   * Get the shift.
   *
   * @return The shift.
   */
  public int getShift() {
    return this.shift;
  }


  /**
   * Print the key to the console.
   */
  @Override
  public void printKey(String prefix, String suffix) {
    System.out.println(prefix + "The key is = [" + this.shift + "]");
  }

}
