package homework1;

import org.junit.Test;

import edu.hawaii.ics423.classicCiphers.VigenereCipher;
import edu.hawaii.ics423.classicCiphers.VigenereKey;
import edu.hawaii.ics423.coding.Base26;
import edu.hawaii.ics423.coding.BaseUtils;

public class Exercise3_2 {

  @Test
  public void test() {
    BaseUtils base26 = new Base26();

    VigenereKey vigenereKey = new VigenereKey("penguin", base26);

    VigenereCipher vigenereCipher = new VigenereCipher(base26);
    String vigenereCipherText = "WEIKWWHGETKNWSDPYUQGBJVUKUZG";
    System.out.println("  Vigenere Cipher ciphertext = [" + vigenereCipherText + "]");
    String vigenereCipherRecoveredText = vigenereCipher.decipher(vigenereCipherText, vigenereKey);
    System.out.println(" Vigenere Cipher recovered text = [" + vigenereCipherRecoveredText + "]");
  }

}
