package edu.hawaii.ics423.classicCiphers;

import org.junit.Test;

import edu.hawaii.ics423.coding.Base26;
import edu.hawaii.ics423.coding.BaseUtils;

public class AffineTest {

  @Test
  public void test() {
    // Exercise the Affine Cipher
    System.out.println("Exercise the Affine Cipher");

    BaseUtils base26 = new Base26();

    AffineKey affineEncryptionKey = new AffineKey(5, 8, base26);
    AffineKey affineDecryptionKey = new AffineKey(21, 8, base26);
    affineEncryptionKey.printKey("  Encryption: ", "");
    affineDecryptionKey.printKey("  Decryption: ", "");
    AffineCipher affineCipher = new AffineCipher(base26);
    String affineMessage = "stayhungrystayfoolish";
    String affineCipherText = affineCipher.encipher(affineMessage, affineEncryptionKey);
    System.out.println("  Affine Cipher ciphertext = [" + affineCipherText + "]");
    String affineClearText = affineCipher.decipher(affineCipherText, affineDecryptionKey);
    System.out.println("  Affine Cipher recovered text = [" + affineClearText + "]");
    org.junit.Assert.assertEquals(affineClearText, "stayhungrystayfoolish");

    affineEncryptionKey = new AffineKey("iamSam", "Sam", base26);
    affineEncryptionKey.printKey("  ", "");

    org.junit.Assert.assertEquals(affineEncryptionKey.getA(0), 8);
    org.junit.Assert.assertEquals(affineEncryptionKey.getA(6), 8);
    org.junit.Assert.assertEquals(affineEncryptionKey.getA(12), 8);
    org.junit.Assert.assertEquals(affineEncryptionKey.getB(2), 12);
    org.junit.Assert.assertEquals(affineEncryptionKey.getB(5), 12);
    org.junit.Assert.assertEquals(affineEncryptionKey.getB(8), 12);

    // affineCipherText = affineCipher.encipher(affineMessage,
    // affineEncryptionKey);

  }

}
