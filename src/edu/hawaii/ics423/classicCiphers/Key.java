/**
 * Copyright (c) Mark Nelson - 2015 - All rights reserved.
 */
package edu.hawaii.ics423.classicCiphers;

/**
 * Represent an encryption key used by a given cipher.
 *
 * @author Mark Nelson
 */
public interface Key {

  /**
   * Get the key.
   *
   * @return The key.
   */
  Key getKey();


  /**
   * Print the key.
   *
   * @param prefix A string to prepend to the printed output.
   * @param suffix A string to append to the printed output.
   */
  void printKey(final String prefix, String suffix);

}
