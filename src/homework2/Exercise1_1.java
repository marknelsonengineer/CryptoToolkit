package homework2;

import org.junit.Test;

import edu.hawaii.ics423.classicCiphers.ShiftCipher;
import edu.hawaii.ics423.classicCiphers.ShiftKey;
import edu.hawaii.ics423.coding.Base26;
import edu.hawaii.ics423.coding.BaseUtils;

public class Exercise1_1 {

  @Test
  public void test() {
    String cipherText = "UDWSJLZWSJWS";

    System.out.println("Exercise 1-1:  Decipher " + cipherText + " with the shift cipher");

    BaseUtils base26 = new Base26();

    for (int i = 0; i < Base26.CIPHER_BASE; i++) {
      ShiftKey key = new ShiftKey(i, base26);
      ShiftCipher shiftCipher = new ShiftCipher(base26);
      String shiftCipherRecoveredText = shiftCipher.decipher(cipherText, key);
      System.out.println("  The key is = [" + key.getShift() + "] or [" + base26.intToChar(key.getShift()) + "]  The recovered text is: [" + shiftCipherRecoveredText + "]");
    }
  }

}
