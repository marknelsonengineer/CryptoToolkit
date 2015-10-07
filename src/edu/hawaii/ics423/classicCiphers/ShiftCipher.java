/**
 * Copyright (c) Mark Nelson - 2015 - All rights reserved.
 */
package edu.hawaii.ics423.classicCiphers;

import edu.hawaii.ics423.coding.BaseUtils;
import edu.hawaii.ics423.coding.CodingSystem;

/**
 * Implementation of a Monoalphabetic (Ceasar) Shift Cipher.
 *
 * @author Mark Nelson
 *
 */
public class ShiftCipher {

  /**
   * The coding system to use for this cipher.
   */
  private BaseUtils codingSystem;


  /**
   * Construct a new Shift Cipher using a given codingSystem.
   *
   * @param inCodingSystem
   *          The coding system to use for this cipher.
   */
  public ShiftCipher(final CodingSystem inCodingSystem) {
    this.codingSystem = (BaseUtils) inCodingSystem;
  }


  /**
   * Encrypt using the Shift (Ceasar) Cipher.
   *
   * @param message
   *          The message to encrypt.
   * @param key
   *          The offset to give the message.
   *
   * @return A string representing the encrypted message.
   */
  public String encipher(final String message, final ShiftKey key) {
    int[] clearTextInts = codingSystem.stringToIntArray(message);
    int[] cipherTextInts = new int[message.length()];

    for (int i = 0; i < clearTextInts.length; i++) {
      cipherTextInts[i] = (clearTextInts[i] + key.getShift()) % codingSystem.getCipherBase();
    }

    return codingSystem.intArrayToString(cipherTextInts).toUpperCase();
  }


  /**
   * Decipher using the Shift Cipher.
   *
   * @param cipherText
   *          The ciphertext to decrypt.
   * @param key
   *          The key used to decrypt the ciphertext.
   *
   * @return The cleartext of the message.
   */
  public String decipher(final String cipherText, final ShiftKey key) {
    int[] cipherTextInts = codingSystem.stringToIntArray(cipherText);
    int[] clearTextInts = new int[cipherText.length()];

    for (int i = 0; i < cipherTextInts.length; i++) {
      clearTextInts[i] = (cipherTextInts[i] - key.getShift() + codingSystem.getCipherBase())
          % codingSystem.getCipherBase();
    }
    // codingSystem.printIntArray(clearTextInts, " ");
    return codingSystem.intArrayToString(clearTextInts).toLowerCase();
  }

}
