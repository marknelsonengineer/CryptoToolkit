package homework2;

import org.junit.Test;

import edu.hawaii.ics423.classicCiphers.AffineCipher;
import edu.hawaii.ics423.classicCiphers.AffineKey;
import edu.hawaii.ics423.coding.Base26;
import edu.hawaii.ics423.coding.BaseUtils;
import edu.hawaii.ics423.math.Math;

public class Exercise_1_2_II {

  @Test
  public void test() {
    System.out.println("Exercise 1-2-ii:  Break the following Affine Ciphertext");

    BaseUtils base26 = new Base26();
    AffineCipher affineCipher = new AffineCipher(base26);

    String affineCipherText = "XKIJUPYEHUVJGU";

    System.out.println("Ciphertext = [" + affineCipherText + "]");

    int inverseOfi;
    for (int i = 0; i < Base26.CIPHER_BASE; i++) {
      try {
        inverseOfi = Math.multiplicativeInverse(i, Base26.CIPHER_BASE);
      } catch (ArithmeticException e) {
        System.out.println("[" + i + "] is not invertabe in base 26");
        continue;
      }
      AffineKey affineDecryptionKey = new AffineKey(inverseOfi, 'e', base26);
      affineDecryptionKey.printKey("  Decryption key: ");
      String affineMessage = affineCipher.decipher(affineCipherText, affineDecryptionKey).toLowerCase();
      System.out.println("  Affine Cipher message = [" + affineMessage + "]");
    }
  }

}
