/**
 * Copyright (c) Mark Nelson - 2015 - All rights reserved.
 */
package edu.hawaii.ics423.classicCiphers;


/**
 * The key for a Rail Fence Cipher.
 *
 * @author Mark Nelson
 */
public class RailFenceKey implements Key{
  /** The number of rails. */
  private int rails;


  /**
   * Construct a new key.
   *
   * @param inRails The number of rails for this key.
   */
  RailFenceKey(final int inRails) {
    this.rails = inRails;
  }


  /**
   * Get the key.
   *
   * @return The key.
   */
  @Override
  public Key getKey() {
    return this;
  }


  /**
   * Get the number of 'rails' in the key.
   *
   * @return The number of 'rails' in the key.
   */
  public int getRails() {
    return this.rails;
  }


  /**
   * Print the key.
   *
   * @param prefix Text to prepend when the key is printed.
   */
  @Override
  public void printKey(String prefix, String suffix) {
    System.out.println(prefix + "The number of rails = [" + rails + "]");
  }

}
