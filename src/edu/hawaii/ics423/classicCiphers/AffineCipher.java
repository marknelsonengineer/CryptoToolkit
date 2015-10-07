/**
 * Copyright (c) Mark Nelson - 2015 - All rights reserved.
 */
package edu.hawaii.ics423.classicCiphers;

import edu.hawaii.ics423.coding.CodingSystem;

/**
 * Implementation of the Affine Cipher.
 *
 * Note: This implementation does not calculate inverse of an encryption key.
 * Therefore, the user of this class is expected to do so.
 *
 * Consequently, users will create two AffineKeys. One used for encryption and
 * another used for decryption.
 *
 * @author Mark Nelson
 * @see https://en.wikipedia.org/wiki/Affine_cipher
 */
public class AffineCipher {

  /**
   * The coding system to use for this cipher.
   */
  private CodingSystem codingSystem;


  /**
   * Construct a new AffineCipher using a given codingSystem.
   *
   * @param inCodingSystem
   *          The coding system to use for this cipher.
   */
  public AffineCipher(final CodingSystem inCodingSystem) {
    this.codingSystem = inCodingSystem;
  }


  /**
   * This implementation will encrypt using the Affine cipher.
   *
   * @param message
   *          The message to encrypt.
   * @param key
   *          The key used to encrypt the message.
   *
   * @return An encrypted message.
   */
  public String encipher(final String message, final AffineKey key) {
    int[] clearTextInts = codingSystem.stringToIntArray(message);
    int[] cipherTextInts = new int[message.length()];

    for (int i = 0; i < clearTextInts.length; i++) {
      cipherTextInts[i] = ((clearTextInts[i] * key.getA(i)) + key.getB(i)) % codingSystem.getCipherBase();
    }

    return codingSystem.intArrayToString(cipherTextInts).toUpperCase();
  }


  /**
   * This implementation will decrypt using the Affine cipher.
   *
   * @param ciphertext
   *          The message to decrypt.
   * @param key
   *          The key used to decrypt the message.
   *
   * @return A cleartext message.
   */
  public String decipher(final String ciphertext, final AffineKey key) {
    int[] cipherTextInts = codingSystem.stringToIntArray(ciphertext);
    int[] clearTextInts = new int[ciphertext.length()];

    for (int i = 0; i < cipherTextInts.length; i++) {
      clearTextInts[i] = ((cipherTextInts[i] - key.getB(i) + codingSystem.getCipherBase()) * key.getA(i))
          % codingSystem.getCipherBase();
    }

    return codingSystem.intArrayToString(clearTextInts).toLowerCase();
  }

}
