package homework2;

import org.junit.Test;

import edu.hawaii.ics423.classicCiphers.AffineCipher;
import edu.hawaii.ics423.classicCiphers.AffineKey;
import edu.hawaii.ics423.coding.Base26;
import edu.hawaii.ics423.coding.BaseUtils;
import edu.hawaii.ics423.math.Math;

public class Exercise1_2_i {

  @Test
  public void test() {
    System.out.println("Exercise 1-2-i:  Break the following Affine Ciphertext");

    BaseUtils base26 = new Base26();
    AffineCipher affineCipher = new AffineCipher(base26);

    String affineCipherText = "YDFLFJYLYLE";

    System.out.println("Ciphertext = [" + affineCipherText + "]");

    for (int i = 0; i < Base26.CIPHER_BASE; i++) {
      int inverseOfi = Math.multiplicativeInverse(base26.charToInt('h'), Base26.CIPHER_BASE);
      AffineKey affineDecryptionKey = new AffineKey(inverseOfi, i, base26);
      affineDecryptionKey.printKey("  Decryption key: ");
      String affineMessage = affineCipher.decipher(affineCipherText, affineDecryptionKey).toLowerCase();
      System.out.println("  Affine Cipher message = [" + affineMessage + "]");
    }
  }

}
