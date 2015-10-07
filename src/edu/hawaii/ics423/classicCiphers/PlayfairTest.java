package edu.hawaii.ics423.classicCiphers;

import org.junit.Test;

public class PlayfairTest {

  @Test
  public void test() {
    PlayfairKey playfairKey = new PlayfairKey(new char[][] {
      { 'k', 'd', 'w', 'r', 'o' }  // Row 0
     ,{ 'm', 'a', 'n', 'v', 'l' }  // Row 1
     ,{ 't', 'c', 'x', 'e', 'p' }  // Row 2
     ,{ 'u', 'h', 'g', 'b', 'z' }  // Row 3
     ,{ 's', 'q', 'f', 'i', 'y' }  // Row 4
      });

    org.junit.Assert.assertEquals(playfairKey.findKey('x').x, 2);
    org.junit.Assert.assertEquals(playfairKey.findKey('x').y, 2);
    org.junit.Assert.assertEquals(playfairKey.findKey('k').x, 0);
    org.junit.Assert.assertEquals(playfairKey.findKey('k').y, 0);
    org.junit.Assert.assertEquals(playfairKey.findKey('y').x, 4);
    org.junit.Assert.assertEquals(playfairKey.findKey('y').y, 4);
    org.junit.Assert.assertEquals(playfairKey.findKey('o').x, 4);
    org.junit.Assert.assertEquals(playfairKey.findKey('o').y, 0);
    org.junit.Assert.assertEquals(playfairKey.findKey('s').x, 0);
    org.junit.Assert.assertEquals(playfairKey.findKey('s').y, 4);

    org.junit.Assert.assertEquals(playfairKey.getKey(0,0), 'k');
    org.junit.Assert.assertEquals(playfairKey.getKey(1,0), 'd');
    org.junit.Assert.assertEquals(playfairKey.getKey(0,1), 'm');

    PlayfairCipher playfairCipher = new PlayfairCipher();
    String message = "stayhungrystayfoolish";
    System.out.println("  Playfair Cipher message = [" + message + "]");

    String cipherText = playfairCipher.encrypt(message, playfairKey);
    System.out.println("  Playfair Cipher encrypted text = [" + cipherText.toUpperCase() + "]");

    String recoveredText = playfairCipher.decrypt(cipherText, playfairKey);
    System.out.println("  Playfair Cipher recovered text = [" + recoveredText + "]");
    org.junit.Assert.assertEquals(recoveredText, "stayhungrystayfoolishx");

  }

}
