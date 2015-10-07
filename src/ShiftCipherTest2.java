import org.junit.Test;

import edu.hawaii.ics423.classicCiphers.ShiftCipher;
import edu.hawaii.ics423.classicCiphers.ShiftKey;
import edu.hawaii.ics423.coding.Base26;
import edu.hawaii.ics423.coding.BaseUtils;

public class ShiftCipherTest2 {

  @Test
  public void test() {
    BaseUtils base26 = new Base26();

    ShiftKey shiftKey = new ShiftKey('l', base26);
    System.out.println("  The key is = [" + shiftKey.getShift() + "]");

    ShiftCipher shiftCipher = new ShiftCipher(base26);
    String shiftCipherText = "XFDEDPPJZFZGPCNLOZRLYHPDENZXTYRLEZYNP";
    System.out.println("  Shift Cipher ciphertext = [" + shiftCipherText + "]");
    String shiftCipherRecoveredText = shiftCipher.decipher(shiftCipherText, shiftKey);
    System.out.println("  Shift Cipher recovered text = [" + shiftCipherRecoveredText + "]");
  }

}
