package homework2;

import org.junit.Test;

import edu.hawaii.ics423.classicCiphers.AffineCipher;
import edu.hawaii.ics423.classicCiphers.AffineKey;
import edu.hawaii.ics423.coding.Base26;
import edu.hawaii.ics423.coding.BaseUtils;
import edu.hawaii.ics423.math.Math;

public class Exercise_1_2_iii {

  @Test
  public void test() {
    System.out.println("Exercise 1-2-iii:  Break the following Affine Ciphertext");

    BaseUtils base26 = new Base26();
    AffineCipher affineCipher = new AffineCipher(base26);

    String affineCipherText = "RMJIQUYYKIIB";

    System.out.println("Ciphertext = [" + affineCipherText + "]");

    AffineKey affineDecryptionKey = null;
    for (int x = 0; x < Base26.CIPHER_BASE; x++) {
      for (int y = 0; y < Base26.CIPHER_BASE; y++) {
        affineDecryptionKey = null;
        try {
          int inverseOfi = Math.multiplicativeInverse(x, Base26.CIPHER_BASE);
          affineDecryptionKey = new AffineKey(inverseOfi, y, base26);
          affineDecryptionKey.printKey("  Decryption key: ", "");
        } catch (ArithmeticException e) {
          //System.out.println("[" + x + "] is not invertabe in base 26");
          continue;
        }
        String affineMessage = affineCipher.decipher(affineCipherText, affineDecryptionKey).toLowerCase();
        System.out.println("  Affine Cipher message = [" + affineMessage + "]");
      }
    }
  }

}
