/**
 * Copyright (c) Mark Nelson - 2015 - All rights reserved.
 */
package edu.hawaii.ics423.classicCiphers;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import edu.hawaii.ics423.coding.CodingSystem;

/**
 * Key for the Columnar Cipher.
 *
 * @author Mark Nelson
 * @since 1.8
 */
public class ColumnarCipherKey implements Key {

  /** The minimum length of a Columnar Cipher Key. */
  public static final int MINIMUM_KEY_LENGTH = 2;


  /**
   * The key for this Columnar Cipher.  The length of the key determines
   * the number of columns in the cipher.
   */
  private String key;


  /**
   * The coding system to use for this cipher.
   */
  private CodingSystem codingSystem;


  /**
   * A static counter to populate the keyIndex.
   */
  protected int keySize = 0;


  /**
   * A holding class for each character in the key.
   */
  protected class KeyChar {
    /** The character in the key. */
    char character;
    /** The value of the character in the key. */
    int  keyValue;
    /** The original index of the character in the key. */
    int  keyIndex;

    /**
     * Construct a KeyChar.
     *
     * @param c A character in the key.
     */
    protected KeyChar(final char c) {
      character = c;
      keyValue = codingSystem.charToInt(c);
      keyIndex = keySize++;
    }

  }

  /** A list of KeyChars. */
  protected List<KeyChar> keyArray = new ArrayList<KeyChar>();


  /**
   * Get a mapping of the columnar indexes sorted by the value of the character
   * of the key.
   *
   * @return A mapping of the columnar index to the key index.
   */
  public int[] getKeyMap() {
    int[] keyMap = new int[key.length()];

    List<KeyChar> sortedArray = new ArrayList<KeyChar>();

    for (int i = 0; i < key.length(); i++) {
      sortedArray.add(i, keyArray.get(i));
    }

    Collections.sort(sortedArray,
                     (key1, key2) -> key1.keyValue - key2.keyValue);

    for (int i = 0; i < key.length(); i++) {
      keyMap[i] = sortedArray.get(i).keyIndex;
    }

    return keyMap;
  }


  /**
   * Construct a Columnar Cipher Key.
   *
   * Note:  The key is stored in lowercase and trimmed of whitespace at the
   *        beginning and end.
   *
   * TODO:  Build a key generator that takes a String as input.
   *
   * @param inKey The key as a string.
   * @param base The coding system used in this key.
   */
  public ColumnarCipherKey(final String inKey, final CodingSystem base) {
    if (inKey == null) {
      throw new IllegalArgumentException("Key can not be null");
    }

    if (inKey.trim().isEmpty()) {
      throw new IllegalArgumentException("Key [" + inKey
                                       + "] can not be empty");
    }

    if (inKey.trim().length() < MINIMUM_KEY_LENGTH) {
      throw new IllegalArgumentException("Key [" + inKey
          + "] is not long enough.  "
          + "Minumum key length is " + MINIMUM_KEY_LENGTH + " characters.");
    }

    this.key = inKey.trim().toLowerCase();

    if (base == null) {
      throw new IllegalArgumentException("The coding system can not be null");
    }

    this.codingSystem = base;

    for (int i = 0; i < key.length(); i++) {
      keyArray.add(i, new KeyChar(key.charAt(i)));
    }
  }


  @Override
  public Key getKey() {
    return this;
  }


  /**
   * Return the length of the key.
   *
   * @return The length of the key.
   */
  public int length() {
    return key.length();
  }


  /**
   * Print the key to the console.
   */
  public void printKey() {
    printKey("", "");
  }


  /**
   * Print the key to the console.
   *
   * @param prefix A string to print before printing the key.
   * @param suffix A string to print after printing the key.
   */
  @Override
  public void printKey(final String prefix, final String suffix) {
    System.out.println(prefix
                     + "The Columnar Cipher Key = [" + this.key + "]"
                     + suffix);

    DecimalFormat twoDigits = new DecimalFormat("00");

    int[] keyMap = getKeyMap();

    StringBuffer sbChar = new StringBuffer();
    StringBuffer sbValue = new StringBuffer();
    StringBuffer sbKeyIndex = new StringBuffer();
    StringBuffer sbSortedIndex = new StringBuffer();
    StringBuffer sbSortedChar = new StringBuffer();

    for (int i = 0; i < key.length(); i++) {
      sbChar.append("  " + keyArray.get(i).character);
      sbValue.append(" " + twoDigits.format(keyArray.get(i).keyValue));
      sbKeyIndex.append(" " + twoDigits.format(keyArray.get(i).keyIndex));
      sbSortedIndex.append(" " + twoDigits.format(keyMap[i]));
      sbSortedChar.append("  " + keyArray.get(keyMap[i]).character);
    }

    System.out.println(prefix + "Chars:        " + sbChar.toString());
    System.out.println(prefix + "Values:       " + sbValue.toString());
    System.out.println(prefix + "Key Index:    " + sbKeyIndex.toString());
    System.out.println(prefix + "Sorted Index: " + sbSortedIndex.toString());
    System.out.println(prefix + "Sorted Char:  " + sbSortedChar.toString());

  }

}
