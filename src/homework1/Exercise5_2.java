package homework1;

import org.junit.Test;

import edu.hawaii.ics423.classicCiphers.PlayfairCipher;
import edu.hawaii.ics423.classicCiphers.PlayfairKey;

public class Exercise5_2 {
  @Test
  public void test() {
    PlayfairKey playfairKey = new PlayfairKey(new char[][] {
      { 'k', 'd', 'w', 'r', 'o' }  // Row 0
     ,{ 'm', 'a', 'n', 'v', 'l' }  // Row 1
     ,{ 't', 'c', 'x', 'e', 'p' }  // Row 2
     ,{ 'u', 'h', 'g', 'b', 'z' }  // Row 3
     ,{ 's', 'q', 'f', 'i', 'y' }  // Row 4
      });

    PlayfairCipher playfairCipher = new PlayfairCipher();
    String cipherText = "CUFVRSXFRFNPLWPKEBDEKLXICVVISUCHESWLRFNP";
    String recoveredText = playfairCipher.decrypt(cipherText, playfairKey);

    System.out.println("  Playfair Cipher recovered text = [" + recoveredText + "]");
  }
}
