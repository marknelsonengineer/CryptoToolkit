
/**
 * Copyright (c) Mark Nelson - 2015 - All rights reserved.
 */

import edu.hawaii.ics423.classicCiphers.ShiftCipher;
import edu.hawaii.ics423.classicCiphers.ShiftKey;
import edu.hawaii.ics423.classicCiphers.VigenereCipher;
import edu.hawaii.ics423.classicCiphers.VigenereKey;
import edu.hawaii.ics423.coding.Base26;
import edu.hawaii.ics423.coding.BaseUtils;

/**
 * Entry point used to test and utilize ICS423 packages.
 *
 * @author Mark Nelson
 */
public final class Main {

  /**
   * Utility classes should not be able to be instantiated.
   */
  private Main() {
    // Do nothing
  }


  /**
   * The entry point for this program.
   *
   * @param args
   *          Unused.
   */
  public static void main(final String[] args) {
    System.out.println("Begin Crypto Toolkit");

    System.out.println("Exercise Base26");
    BaseUtils base26 = new Base26();

    String codingMessage = "ABCXYZabcxyz";
    System.out.println("  Original Message = [" + codingMessage + "]");

    int[] intArray = base26.stringToIntArray(codingMessage);

    base26.printIntArray(intArray, "  ");

    System.out.println("  Recovered from intArray = [" + base26.intArrayToString(intArray) + "]");

    // Exercise Shift Cipher
    System.out.println("Exercise the Shift Cipher");
    ShiftKey shiftKey = new ShiftKey('B', base26);
    shiftKey.printKey("  ");

    String shiftMessage = "ABCXYZabcxyz";
    System.out.println("  Original Message = [" + shiftMessage + "]");

    ShiftCipher shiftCipher = new ShiftCipher(base26);
    String shiftCipherText = shiftCipher.encipher(shiftMessage, shiftKey);
    System.out.println("  Shift Cipher ciphertext = [" + shiftCipherText + "]");
    String shiftCipherRecoveredText = shiftCipher.decipher(shiftCipherText, shiftKey);
    System.out.println("  Shift Cipher recovered text = [" + shiftCipherRecoveredText + "]");

    // Exercise Vigenere Cipher
    System.out.println("Exercise the Vigenere Cipher");
    VigenereKey vigenereKey = new VigenereKey("abc", base26);
    vigenereKey.printKey("  ");

    String vigenereMessage = "ABCXYZabcxyz";
    System.out.println("  Original Message = [" + vigenereMessage + "]");

    VigenereCipher vigenereCipher = new VigenereCipher(base26);
    String vigenereCipherText = vigenereCipher.encipher(vigenereMessage, vigenereKey);
    System.out.println("  Vigenere Cipher ciphertext = [" + vigenereCipherText + "]");
    String vigenereCipherRecoveredText = vigenereCipher.decipher(vigenereCipherText, vigenereKey);
    System.out.println("  Vigenere Cipher recovered text = [" + vigenereCipherRecoveredText + "]");

  }

}
