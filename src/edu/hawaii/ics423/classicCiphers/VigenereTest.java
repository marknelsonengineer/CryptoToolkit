package edu.hawaii.ics423.classicCiphers;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import edu.hawaii.ics423.coding.Base26;
import edu.hawaii.ics423.coding.BaseUtils;

public class VigenereTest {

  @Test
  public void test() {
    String cipherText = "FYRPLVLZCZIRWEVEWINNVWRUHLBLVFATRAJFWPJAVPTYSPLVBLMKJCNQSYEEGPTNIVFYRXIRZEWBYCGFHSIYFGSHSJYEVAARDRFAIUMLGLSZXZBAHDJYGOSLQDVWWSFCFEGRIPRPLVBZFHHNNEVDEKJSOOKFTDSOXVUASZYJNYHKQZXPFUEEIMZKSUXSSZAVMLJAHVAPZKTVIDDAIUGFHSIYFGSOLLYZINWVQGSOMERLQDMEJCMPLRYRWRIJFMIJHRSNSDEJQPTPYJNYKWRKTFFGRFBWSZKVMLGIEUJFGYCENNOHSLWNZAZVWYSOWYFCRWRUZYYERUBPHDMEPECKQLHSOJHWJPZPSFQTHPPVRZFAXYFYAWGYNYSNCNJYSAHYZXOJMKDXCNIKMLBYPVAPFJIJXHSJIVIVWJHEJDGWRULPBPICSPGOAZYSCQXKMPGAULFWWPMVXWWBINNWZXIMNZZARKFYRWPCBTZHFVQZGP";
    //String cipherText = "IFEDHGFEDCBA";

    BaseUtils base26 = new Base26();
    VigenereCipher vigenereCipher = new VigenereCipher(base26);

    vigenereCipher.kasiskiTest(cipherText, 9);

  }


  @Test
  public void testBasicVigenere() {
    BaseUtils base26 = new Base26();

    VigenereKey vigenereKey = new VigenereKey("lion", base26);

    String vigenereMessage = "yourtimeislimited";
    // System.out.println("  Original Message = [" + vigenereMessage + "]");

    VigenereCipher vigenereCipher = new VigenereCipher(base26);
    String vigenereCipherText = vigenereCipher.encipher(vigenereMessage, vigenereKey);
    // System.out.println("  Vigenere Cipher ciphertext = [" + vigenereCipherText + "]");
    String vigenereCipherRecoveredText = vigenereCipher.decipher(vigenereCipherText, vigenereKey);
    // System.out.println("  Vigenere Cipher recovered text = [" + vigenereCipherRecoveredText + "]");
    assertEquals(vigenereMessage, vigenereCipher.decipher(vigenereCipherText, vigenereKey));
  }


}
