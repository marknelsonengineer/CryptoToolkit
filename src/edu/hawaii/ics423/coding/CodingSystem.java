/**
 * Copyright (c) Mark Nelson - 2015 - All rights reserved.
 */
package edu.hawaii.ics423.coding;

/**
 * Interface for generic coding systems.
 *
 * @author Mark Nelson
 */
public interface CodingSystem {


  /**
   * Get the modulo base for the coding system.
   *
   * @return The modulo base for the coding system.
   */
  int getCipherBase();


  /**
   * Convert a character into the coding system.
   *
   * @param inChar The character.
   * @return The code reperesenting the character.
   */
  public int charToInt(final char inChar);


  /**
   * Convert a codepoint into a character.
   *
   * @param inInt The codepoint to convert.
   * @return The character.
   */
  public char intToChar(final int inInt);


  /**
   * Convert from String to integer array.
   *
   * @param inString The string to convert.
   *
   * @return The converted integer array.
   */
  int[] stringToIntArray(final String inString);


  /**
   * Convert from an integer array to a String.
   *
   * @param inInts The integer array to convert.
   *
   * @return The converted string.
   */
   String intArrayToString(final int[] inInts);


   /**
    * Print this base conversion table.
    */
   public void printTable();

}