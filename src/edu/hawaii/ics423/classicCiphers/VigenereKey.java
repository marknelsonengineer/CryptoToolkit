/**
 * Copyright (c) Mark Nelson - 2015 - All rights reserved.
 */
package edu.hawaii.ics423.classicCiphers;

import edu.hawaii.ics423.coding.BaseUtils;

/**
 * The key for a Vigenere Cipher.
 *
 * @author Mark Nelson
 * @see https://en.wikipedia.org/wiki/Vigenère_cipher
 */

public class VigenereKey implements Key {

  /** The key for a Vigenere Cipher. */
  private int[] key;

  /** The number base of the key system. */
  private BaseUtils base;


  /**
   * Create a new Vigenere Key.
   *
   * @param inKey
   *          The key.
   * @param inBase
   *          The number system for this key.
   */
  public VigenereKey(final String inKey, final BaseUtils inBase) {
    if (inKey == null) {
      throw new UnsupportedOperationException("The key can not be null");
    }

    if (inKey.trim().isEmpty()) {
      throw new UnsupportedOperationException("The key can not be empty");
    }

    base = inBase;
    key = base.stringToIntArray(inKey);
  }


  /**
   * Get the cipher key.
   *
   * @return This key.
   */
  @Override
  public VigenereKey getKey() {
    return this;
  }


  /**
   * Return the key as an integer array.
   *
   * @return The key as an integer array.
   */
  public int[] getKeyIntArray() {
    return key;
  }


  /**
   * Get the length of the key.
   *
   * @return The length of the key.
   */
  public int keyLength() {
    return key.length;
  }


  /**
   * Print the Vigenere key.
   */
  @Override
  public void printKey(final String prefix, String suffix) {
    this.base.printIntArray(this.key, prefix + "The key is: ");
  }

}
