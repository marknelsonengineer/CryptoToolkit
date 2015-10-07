/**
 * Copyright (c) Mark Nelson - 2015 - All rights reserved.
 */
package edu.hawaii.ics423.classicCiphers;

import edu.hawaii.ics423.math.Coordinate;

/**
 * Key for the Playfair Cipher.
 *
 * x is the column position.
 * y is the row position.
 *
 * @author Mark Nelson
 */
public class PlayfairKey implements Key {

  /**
   * A 5x5 char array key.  Each of the characters should be unique.  The
   * letter 'q' should be omitted.
   */
  private char[][] key;


  /**
   * Construct a Playfair Key.
   *
   * TODO:  Needs validation checks.
   * TODO:  Needs a key generator that takes a String as input.
   * TODO:  Convert uppercase to lowercase.
   *
   * @param inKey The key as a 5x5 array.
   */
  public PlayfairKey(final char[][] inKey) {
    this.key = inKey;
  }


  /**
   * Return the x, y position of the key.
   *
   * TODO:  Do case conversion.
   *
   * @param inKey
   *          The value to search for.
   * @return The x, y position of the value in the key.
   */
  public Coordinate findKey(final char inKey) {
    for (int i = 0; i < 5; i++) {
      for (int j = 0; j < 5; j++) {
        if (this.key[i][j] == inKey) {
          return new Coordinate(j, i);
        }
      }
    }

    throw new RuntimeException("The key [" + inKey + "] can not be found in the key.");
  }


  @Override
  public Key getKey() {
    // TODO Auto-generated method stub
    return null;
  }


  /**
   * Get a character from the key.
   *
   * @param x The column position.
   * @param y The row position.
   *
   * @return The character at this key position.
   */
  public char getKey(final int x, final int y) {
    return key[y][x];
  }


  @Override
  public void printKey(String prefix) {
    // TODO Auto-generated method stub

  }

}
