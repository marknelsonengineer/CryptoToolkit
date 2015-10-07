/**
 * Copyright (c) Mark Nelson - 2015 - All rights reserved.
 */
package edu.hawaii.ics423.classicCiphers;

import edu.hawaii.ics423.coding.BaseUtils;
import edu.hawaii.ics423.coding.CodingSystem;

/**
 * Implementation of a Polyalphabetic (Vigenere) Cipher.
 *
 * @author Mark Nelson
 * @see https://en.wikipedia.org/wiki/Vigenère_cipher
 *
 */
public class VigenereCipher {

  /**
   * The coding system to use for this cipher.
   */
  private BaseUtils codingSystem;


  /**
   * Construct a new Cipher using a given codingSystem.
   *
   * @param inCodingSystem
   *          The coding system to use for this cipher.
   */
  public VigenereCipher(final CodingSystem inCodingSystem) {
    this.codingSystem = (BaseUtils) inCodingSystem;
  }


  /**
   * Encrypt using the Vigenere Cipher.
   *
   * @param message
   *          The message to encrypt.
   * @param key
   *          The encryption key.
   *
   * @return A string representing the encrypted message.
   */
  public String encipher(final String message, final VigenereKey key) {
    int[] clearTextInts = codingSystem.stringToIntArray(message);
    int[] cipherTextInts = new int[message.length()];

    for (int i = 0; i < clearTextInts.length; i++) {
      cipherTextInts[i] = (clearTextInts[i] + key.getKeyIntArray()[i % key.keyLength()]) % codingSystem.getCipherBase();
    }

    return codingSystem.intArrayToString(cipherTextInts).toUpperCase();
  }


  /**
   * Decipher using the Vigenere Cipher.
   *
   * @param cipherText
   *          The ciphertext to decrypt.
   * @param key
   *          The key used to decrypt the ciphertext.
   *
   * @return The cleartext of the message.
   */
  public String decipher(final String cipherText, final VigenereKey key) {
    int[] cipherTextInts = codingSystem.stringToIntArray(cipherText);
    int[] clearTextInts = new int[cipherText.length()];

    for (int i = 0; i < cipherTextInts.length; i++) {
      clearTextInts[i] = ((cipherTextInts[i] - key.getKeyIntArray()[i % key.keyLength()])
          + codingSystem.getCipherBase()) % codingSystem.getCipherBase();
    }
    // codingSystem.printIntArray(clearTextInts, " ");
    return codingSystem.intArrayToString(clearTextInts).toLowerCase();
  }

}
