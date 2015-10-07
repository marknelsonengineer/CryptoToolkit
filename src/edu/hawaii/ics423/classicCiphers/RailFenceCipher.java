/**
 * Copyright (c) Mark Nelson - 2015 - All rights reserved.
 */
package edu.hawaii.ics423.classicCiphers;

/**
 * Implementation of the Rail Fence Cipher.
 *
 * This particular implementation uses ICS 423's version which is a little
 * different than the standard version.  The standard version employs a zig
 * zag pattern.  This version employs a sawtooth pattern.
 *
 * @author Mark Nelson
 * @see https://en.wikipedia.org/wiki/Rail_fence_cipher
 */
public class RailFenceCipher {

  public String encipher(final String message, final RailFenceKey key) {

    String[] fence = new String[key.getRails()];

    for (int i = 0; i < message.length(); i++) {
      fence[i % key.getRails()] += message.charAt(i);
    }

    String encryptedText = "";

    for (int i=0; i < key.getRails(); i++) {
      encryptedText += fence[i];
    }

    return encryptedText.toUpperCase();
  }


  // THE RAIL FENCE CIPHER IS INCOMPLETE.

//  public String decipher(final String cipherText, final RailFenceKey key) {

//    String[] fence = new String[key.getRails()];

//    int fenceLength = ((int)(cipherText.length()/key.getRails())) + 1;

//    for (int i=0; i < key.getRails(); i++) {
//      fence[i] = cipherText.substring(i*, endIndex);
//    }



    //for (int i = 0; i < cipherText.length(); i++) {
    //  fence[i]
   // }

//    return "";
//  }

}
