package homework1;

import org.junit.Test;

import edu.hawaii.ics423.classicCiphers.VigenereCipher;
import edu.hawaii.ics423.classicCiphers.VigenereKey;
import edu.hawaii.ics423.coding.Base26;
import edu.hawaii.ics423.coding.BaseUtils;

public class Exercise3_1 {

  @Test
  public void test() {
    BaseUtils base26 = new Base26();

    VigenereKey vigenereKey = new VigenereKey("lion", base26);

    String vigenereMessage = "yourtimeislimited";
    System.out.println("  Original Message = [" + vigenereMessage + "]");

    VigenereCipher vigenereCipher = new VigenereCipher(base26);
    String vigenereCipherText = vigenereCipher.encipher(vigenereMessage, vigenereKey);
    System.out.println("  Vigenere Cipher ciphertext = [" + vigenereCipherText + "]");
    String vigenereCipherRecoveredText = vigenereCipher.decipher(vigenereCipherText, vigenereKey);
    System.out.println(" Vigenere Cipher recovered text = [" + vigenereCipherRecoveredText + "]");
  }

}
