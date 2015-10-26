package homework1;

import org.junit.Test;

import edu.hawaii.ics423.classicCiphers.AffineCipher;
import edu.hawaii.ics423.classicCiphers.AffineKey;
import edu.hawaii.ics423.coding.Base26;
import edu.hawaii.ics423.coding.BaseUtils;

public class Exercise4_3 {

  @Test
  public void test() {
    BaseUtils base26 = new Base26();

    AffineKey affineEncryptionKey = new AffineKey("tblf", "seal", base26);
    affineEncryptionKey.printKey("  Encryption: ", "");

    base26.printTable();

    AffineKey affineDecryptionKey = new AffineKey("lbtv", "seal", base26);
    affineDecryptionKey.printKey(" Decryption: ", "");

    AffineCipher affineCipher = new AffineCipher(base26);
    String affineMessage = "yourtimeislimited";
    String affineCipherText = affineCipher.encipher(affineMessage, affineEncryptionKey);
    System.out.println("  Affine Cipher ciphertext = [" + affineCipherText + "]");
    String affineClearText = affineCipher.decipher(affineCipherText, affineDecryptionKey);
    System.out.println("  Affine Cipher recovered text = [" + affineClearText + "]");
    org.junit.Assert.assertEquals(affineClearText, affineMessage);
  }

}
