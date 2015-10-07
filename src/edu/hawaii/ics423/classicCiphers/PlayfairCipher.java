/**
 * Copyright (c) Mark Nelson - 2015 - All rights reserved.
 */
package edu.hawaii.ics423.classicCiphers;

import edu.hawaii.ics423.math.Coordinate;


/**
 * The implementation of the Playfair Cipher.
 *
 * @author Mark Nelson
 */
public class PlayfairCipher {

  protected static final char PADDING_1 = 'x';
  // TODO: Create a PADDING_2.

  /** A pointer to the current position of the encoded or decoded text. */
  protected int index;

  protected String getPair(String cipherText) {
    // Check for the end of the string (termination condition)
    if (index >= cipherText.length()) {
      return null;
    }

    // Check for one remaining character at the end of the string
    if (index == cipherText.length() - 1) {
      cipherText = cipherText + PADDING_1;
    }

    String p = cipherText.substring(index, index + 2).toLowerCase();

    // Check for double character.
    if (p.charAt(0) == p.charAt(1)) {
      p = "" + p.charAt(0) + PADDING_1;
      index++;
      return p;
    }

    // Normal case
    index += 2;
    return p;
  }


  /**
   * Encrypt a message with the Playfair Cipher.
   *
   * @param clearText The message to encrypt.
   * @param key The encryption key.
   *
   * @return The encrypted message.
   */
  public String encrypt(final String clearText, final PlayfairKey key) {
    this.index = 0;
    String message = "";

    for (String p = getPair(clearText); p != null; p = getPair(clearText)) {
      // System.out.println("Current pair = " + p);

      Coordinate first = key.findKey(p.charAt(0));
      Coordinate second = key.findKey(p.charAt(1));

      // Implement same-row logic
      if (first.y == second.y) {
        // System.out.println("Same row");
        message += key.getKey((first.x + 1) % 5, first.y);
        message += key.getKey((second.x + 1) % 5, second.y);
      }

      // Implement same-column logic
      else if (first.x == second.x) {
        // System.out.println("Same column");
        message += key.getKey(first.x, (first.y + 1) % 5);
        message += key.getKey(second.x, (second.y + 1) % 5);
      }

      // Implement the nominal case
      else {
        message += key.getKey(second.x, first.y);
        message += key.getKey(first.x, second.y);
      }
    }

    return message;
  }


  /**
   * Decrypt the cipherText.
   *
   * @param cipherText The ciphertext to decrypt.
   * @param key The decryption key.
   *
   * @return The broken message.
   */
  public String decrypt(final String cipherText, final PlayfairKey key) {
    this.index = 0;
    String message = "";

    for (String p = getPair(cipherText); p != null; p = getPair(cipherText)) {
      // System.out.println("Current pair = " + p);

      Coordinate first = key.findKey(p.charAt(0));
      Coordinate second = key.findKey(p.charAt(1));

      // Implement same-row logic
      if (first.y == second.y) {
        // System.out.println("Same row");
        message += key.getKey(((first.x - 1) + 5) % 5, first.y);
        message += key.getKey(((second.x - 1) + 5) % 5, second.y);
      }

      // Implement same-column logic
      else if (first.x == second.x) {
        // System.out.println("Same column");
        message += key.getKey(first.x, ((first.y - 1) + 5) % 5);
        message += key.getKey(second.x, ((second.y - 1) + 5) % 5);
      }

      // Implement the nominal case
      else {
        message += key.getKey(second.x, first.y);
        message += key.getKey(first.x, second.y);
      }
    }

    return message;
  }

}
