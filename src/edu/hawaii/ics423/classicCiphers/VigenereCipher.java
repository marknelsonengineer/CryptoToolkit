/**
 * Copyright (c) Mark Nelson - 2015 - All rights reserved.
 */
package edu.hawaii.ics423.classicCiphers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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


  protected class KasisikiString {
    String substring;
    int index;

    protected KasisikiString(final String substring, final int index) {
      this.substring = substring;
      this.index = index;
    }
  }

  protected class KasisikiRepeat {
    String substring;
    int count;
    List<Integer> indexes;

    protected KasisikiRepeat(final String substring, final int count, final List<Integer> indexes) {
      this.substring = substring;
      this.count = count;
      this.indexes = indexes;
    }
  }

  public void kasiskiTest(final String cipherText, final int trialKeySize) {
    List<KasisikiString> s = new ArrayList<KasisikiString>();
    List<KasisikiRepeat> r = new ArrayList<KasisikiRepeat>();

    // Break the cipherText into substrings
    for (int i = 0; i <= cipherText.length() - trialKeySize; i++) {
      // System.out.println(cipherText.substring(i, i + trialKeySize) + " @ " + i );
      s.add(new KasisikiString(cipherText.substring(i, i + trialKeySize), i));
    }

    // Sort the substrings
    Collections.sort(s, (key1, key2) -> key1.substring.compareTo(key2.substring));

    String previous = "";
    int count = 0;
    List<Integer> indexList = new ArrayList<Integer>();

    // Count the sorted substrings, extracting duplicates
    for (int i = 0; i < s.size(); i++) {
      String current = s.get(i).substring;

      if (!current.equals(previous)) {
        if (count > 1) {
          System.out.println(previous + ": " + count + " ->" + indexList.toString());
          r.add(new KasisikiRepeat(previous, count, indexList));
        }
        count = 0;
        previous = current;
        indexList = new ArrayList<Integer>();
      }

      indexList.add(s.get(i).index);
      count++;
    }

    // Find interesting patterns in the repeats
    Collections.sort(r, (key1, key2) -> key2.count - key1.count);

    System.out.println("Substring: count --> indexes => delta between indexes");
    for (int i = 0; i < r.size(); i++) {
      KasisikiRepeat rr = r.get(i);
      System.out.print(rr.substring + ": " + rr.count + " --> " + rr.indexes.toString() + " => ");

      for (int j = 0; j < rr.indexes.size() - 1; j++) {
        if (j != 0 ) {System.out.print(" - "); }
        System.out.print(rr.indexes.get(j+1).intValue() - rr.indexes.get(j).intValue());
      }
      System.out.println("");
    }

  }

  public int countSubstrings(final String text, final String substring) {
    int count = 0;
    for (int i = 0; i <= text.length() - substring.length(); i++) {
      // System.out.println(cipherText.substring(i, i + trialKeySize) + " @ " + i );
      if (substring.equals(text.substring(i, i + substring.length()))) {
        count++;
      }
    }

    return count;
  }

}
