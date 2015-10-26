/**
 * Copyright (c) Mark Nelson - 2015 - All rights reserved.
 */
package edu.hawaii.ics423.classicCiphers;

import edu.hawaii.ics423.coding.CodingSystem;

/**
 * Implementation of the Columnar Cipher.
 *
 * @author Mark Nelson
 * @see http://practicalcryptography.com/ciphers/columnar-transposition-cipher/
 *
 */
public class ColumnarCipher {

  /**
   * The coding system to use for this cipher.
   */
  private CodingSystem codingSystem;


  /**
   * Construct a new ColumnarCipher using a given codingSystem.
   *
   * @param inCodingSystem
   *          The coding system to use for this cipher.
   */
  public ColumnarCipher(final CodingSystem inCodingSystem) {
    this.codingSystem = inCodingSystem;
  }


  /**
   * Encrypt message using the Columnar Cipher.
   *
   * @param message
   *          The message to encrypt.
   * @param key
   *          The key used to encrypt the message.
   *
   * @return An encrypted message.
   */
  public String encipher(final String message, final ColumnarCipherKey key) {
    StringBuffer[] x = new StringBuffer[key.length()];
    StringBuffer cipherText = new StringBuffer();

    int columns = key.length();
    int rows = (message.length() - 1) / key.length() + 1;

    for (int i = 0; i < columns; i++) {
      x[i] = new StringBuffer();
    }

    int count = 0;
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++) {
        if (message.length() > count) {
          x[j].append(message.charAt(count++));
        } else {
          x[j].append(codingSystem.getPadding());
          count++;
        }
      }
    }

    int[] keyMap = key.getKeyMap();

    for (int i = 0; i < columns; i++) {
      cipherText.append(x[keyMap[i]]);
    }

    return cipherText.toString().toUpperCase();
  }


  /**
   * Decrypt message using Columnar Cipher.
   *
   * @param message The message to decrypt.
   * @param key The decryption key.
   * @return The broken message.
   */
  public String decipher(final String message, final ColumnarCipherKey key) {
    StringBuffer[] x = new StringBuffer[key.length()];
    StringBuffer clearText = new StringBuffer();

    int columns = key.length();
    int rows = (message.length() - 1) / key.length() + 1;

    int[] keyMap = key.getKeyMap();

    for (int i = 0; i < columns; i++) {
      x[i] = new StringBuffer();
    }

    for (int j = 0; j < columns; j++) {
      x[keyMap[j]].append(message.substring(j * rows, ((j + 1) * rows)));
    }

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++) {
        clearText.append(x[j].substring(i, i + 1));
      }
    }

    return codingSystem.trimPadding(clearText.toString()).toLowerCase();
  }

}
