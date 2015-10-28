package homework2;

import org.junit.Test;

import edu.hawaii.ics423.classicCiphers.ColumnarCipher;
import edu.hawaii.ics423.classicCiphers.ColumnarCipherKey;
import edu.hawaii.ics423.coding.Base26;
import edu.hawaii.ics423.coding.BaseUtils;

public class Exercise3 {

  @Test
  public void test() {
    System.out.println("Exercise 3");

    BaseUtils base26 = new Base26();
    // Start with key 'abcdefghi'
    ColumnarCipherKey key = new ColumnarCipherKey("edbgfiahc", base26);
    key.printKey("  ", "");

    ColumnarCipher cipher = new ColumnarCipher(base26);
    String cipherText = "OETSNYSTXLGNIHIMBRHNEATNREXNNINDPIAOOIFUNUDEFTATEMIOUEYSIVUDNOMTIHESAUHXWRERATTTR";

    System.out.println("  Columnar Cipher cipherText = [" + cipherText + "]");

    StringBuffer[] strips = cipher.makeStrips(cipherText, key);
    // int[] keyMap = key.getKeyMap();


    int columns = key.length();
    int rows = (cipherText.length() - 1) / key.length() + 1;

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++) {
        System.out.print(strips[j].charAt(i) + " ");
      }

      System.out.println("");
    }


    String clearText = cipher.decipher(cipherText, key);
    System.out.println("  Columnar Cipher clearText = [" + clearText + "]");
  }

}
