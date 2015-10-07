package Practcium1;

import org.junit.Test;

import edu.hawaii.ics423.classicCiphers.AffineCipher;
import edu.hawaii.ics423.classicCiphers.AffineKey;
import edu.hawaii.ics423.coding.Base26;
import edu.hawaii.ics423.coding.BaseUtils;

public class Exercise3_1 {

  @Test
  public void test() {
    System.out.println("Exercise 3-1:  Encipher the following text using th ekey <D, L>");

    BaseUtils base26 = new Base26();

    AffineKey affineEncryptionKey = new AffineKey('D', 'L', base26);
    affineEncryptionKey.printKey("  Encryption: ");

    AffineCipher affineCipher = new AffineCipher(base26);
    String affineMessage = "renaissance";
    System.out.println("  Affine Cipher message = [" + affineMessage + "]");
    String affineCipherText = affineCipher.encipher(affineMessage, affineEncryptionKey);
    System.out.println("  Affine Cipher ciphertext = [" + affineCipherText + "]");
  }

}
