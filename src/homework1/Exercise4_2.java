package homework1;

import org.junit.Test;

import edu.hawaii.ics423.classicCiphers.AffineCipher;
import edu.hawaii.ics423.classicCiphers.AffineKey;
import edu.hawaii.ics423.coding.Base26;
import edu.hawaii.ics423.coding.BaseUtils;

public class Exercise4_2 {

  @Test
  public void test() {
    System.out.println("Exercise 3-2:  Break the following Affine Ciphertext using the key <X, Y>");

    BaseUtils base26 = new Base26();

    AffineKey affineDecryptionKey = new AffineKey(17, 24, base26);
    affineDecryptionKey.printKey("  Decryption: ");

    AffineCipher affineCipher = new AffineCipher(base26);
    String affineCipherText = "RMYPFMIFRMJZIOVMDALP";
    System.out.println("  Affine Cipher ciphertext = [" + affineCipherText + "]");
    String affineMessage = affineCipher.decipher(affineCipherText, affineDecryptionKey).toLowerCase();
    System.out.println("  Affine Cipher message = [" + affineMessage + "]");
  }

}
