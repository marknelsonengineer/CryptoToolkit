/**
 * Copyright (c) Mark Nelson - 2015 - All rights reserved.
 */
package edu.hawaii.ics423.coding;

/**
 * @author Mark Nelson
 *
 */
public class Base26 extends BaseUtils implements CodingSystem {

  /**
   * The modulo base for this coding system.
   */
  public static final int CIPHER_BASE = 26;


  /**
   * The modulo base for this coding system.
   *
   * @return The modulo base for this coding system.
   */
  @Override
  public int getCipherBase() {
    return CIPHER_BASE;
  }


  /**
   * Convert a character to Base 26.
   *
   * @param inChar The character to convert.
   * @return A value from 0 to 25 representing the character.
   */
  @Override
  public int charToInt(final char inChar) {
    char theChar = Character.toUpperCase(inChar);

    if (theChar < 'A' || theChar > 'Z') {
      throw new UnsupportedOperationException(
          "The character [" + inChar + "] can not be converted to base 26.  "
        + "Valid values are from 'A' through 'Z' and 'a' through 'z'.");
    }

    char[] oneElement = new char[1];
    oneElement[0] = theChar;
    return Character.codePointAt(oneElement, 0) - "A".codePointAt(0);
  }


  /**
   * This class converts an integer into a lowercase character.
   *
   * @param inInt The integer to convert.
   * @return The converted character in lowercase.
   */
  @Override
  public char intToChar(final int inInt) {
    if (inInt >= CIPHER_BASE || inInt < 0) {
      throw new UnsupportedOperationException(
          "The integer [" + inInt + "] can not be converted to a character.  "
        + "Valid values are from 0 through " + CIPHER_BASE + ".");
    }

    return Character.toChars(inInt + 'a')[0];
  }


  /**
   * Base 26 conversion from String to an integer array.
   *
   * @param inString The string to convert into an integer array.
   * @return The integer array.
   */
  @Override
  public int[] stringToIntArray(final String inString) {

    int[] intArray = new int[inString.length()];

    for (int i = 0; i < inString.length(); i++) {
      intArray[i] = charToInt(inString.charAt(i));
    }

    return intArray;
  }


  /**
   * Simplistic (base 26) conversion from an integer array to a String.
   *
   * @param inInts The integer array to convert.
   * @return A string.
   */
  @Override
  public String intArrayToString(final int[] inInts) {
    String theString = "";

    for (int i : inInts) {
      theString += intToChar(i);
    }

    return theString;
  }


  /**
   * The character used for padding.
   *
   * @return The character used for padding.
   */
  @Override
  public char getPadding() {
    return 'X';
  }

}
