package edu.hawaii.ics423.classicCiphers;

import org.junit.Test;

public class RailFenceTest {

  @Test
  public void test() {
    System.out.println("Exercise Rail Fence Cipher");
    RailFenceKey railFenceKey = new RailFenceKey(3);
    railFenceKey.printKey("  ");

    String message = "thequickbrownfoxjumpsoverthelazydog";
    System.out.println("  Cipher message = [" + message + "]" );

    RailFenceCipher railFenceCipher = new RailFenceCipher();
    String cipherText = railFenceCipher.encipher(message, railFenceKey);
    System.out.println("  Encrypted message = [" + cipherText + "]");



  }

}
