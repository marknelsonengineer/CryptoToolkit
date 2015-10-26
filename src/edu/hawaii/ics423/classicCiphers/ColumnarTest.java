/**
 * Copyright (c) Mark Nelson - 2015 - All rights reserved.
 */
package edu.hawaii.ics423.classicCiphers;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import edu.hawaii.ics423.coding.Base26;
import edu.hawaii.ics423.coding.BaseUtils;

public class ColumnarTest {

  @Test
  public void test() {
    BaseUtils base26 = new Base26();
    ColumnarCipherKey key = new ColumnarCipherKey("BLOB", base26);
  }

  @Test  (expected = IllegalArgumentException.class)
  public void testNullKey() {
    BaseUtils base26 = new Base26();
    ColumnarCipherKey key = new ColumnarCipherKey(null, base26);
  }

  @Test  (expected = IllegalArgumentException.class)
  public void testEmptyKey() {
    BaseUtils base26 = new Base26();
    ColumnarCipherKey key = new ColumnarCipherKey("", base26);
  }

  @Test  (expected = IllegalArgumentException.class)
  public void testSpaceKey() {
    BaseUtils base26 = new Base26();
    ColumnarCipherKey key = new ColumnarCipherKey(" ", base26);
  }

  @Test  (expected = IllegalArgumentException.class)
  public void testSmallKey() {
    BaseUtils base26 = new Base26();
    ColumnarCipherKey key = new ColumnarCipherKey("A", base26);
  }

  @Test
  public void testBasicColumnarCipher() {
    System.out.println("Exercise the Columnar Cipher");

    BaseUtils base26 = new Base26();
    ColumnarCipherKey key = new ColumnarCipherKey("dcba", base26);
    key.printKey("  ", "");

    String message = "abcdefghi";
    System.out.println("  Columnar Cipher message = [" + message + "]");

    ColumnarCipher cipher = new ColumnarCipher(base26);
    String cipherText = cipher.encipher(message,  key);

    System.out.println("  Columnar Cipher cipherText = [" + cipherText + "]");

    String clearText = cipher.decipher(cipherText, key);
    System.out.println("  Columnar Cipher clearText = [" + clearText + "]");
  }

  @Test
  public void testColumnarEncrypt() {
    BaseUtils base26 = new Base26();
    ColumnarCipher cipher = new ColumnarCipher(base26);

    ColumnarCipherKey key = new ColumnarCipherKey("ABCD", base26);
    assertEquals("AEIBFXCGXDHX", cipher.encipher("abcdefghi",  key));
    assertEquals("AXXX", cipher.encipher("a",  key));
    assertEquals("ABXX", cipher.encipher("ab",  key));
    assertEquals("ABCX", cipher.encipher("abc",  key));
    assertEquals("ABCD", cipher.encipher("abcd",  key));
    assertEquals("AEBXCXDX", cipher.encipher("abcde",  key));
    assertEquals("AEBFCXDX", cipher.encipher("abcdef",  key));
    assertEquals("AEBFCGDX", cipher.encipher("abcdefg",  key));
    assertEquals("AEBFCGDH", cipher.encipher("abcdefgh",  key));
  }


  /**
   * Exercise the cipher from:
   * http://practicalcryptography.com/ciphers/columnar-transposition-cipher/
   */
  @Test
  public void testSampleColumnarCipher() {
    BaseUtils base26 = new Base26();
    ColumnarCipherKey key = new ColumnarCipherKey("german", base26);

    String message = "defendtheeastwallofthecastle";
    ColumnarCipher cipher = new ColumnarCipher(base26);
    String cipherText = cipher.encipher(message,  key);
    assertEquals("NALCXEHWTTDTTFSEELEEDSOAXFEAHL", cipherText);

    assertEquals(message, cipher.decipher(cipherText,  key));
  }

}
