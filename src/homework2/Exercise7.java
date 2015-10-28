package homework2;

import org.junit.Test;

import edu.hawaii.ics423.classicCiphers.VigenereCipher;
import edu.hawaii.ics423.classicCiphers.VigenereKey;
import edu.hawaii.ics423.coding.Base26;
import edu.hawaii.ics423.coding.BaseUtils;

public class Exercise7 {

  @Test
  public void conductKasiskiTest() {
    String cipherText = "FYRPLVLZCZIRWEVEWINNVWRUHLBLVFATRAJFWPJAVPTYSPLVBLMKJCNQSYEEGPTNIVFYRXIRZEWBYCGFHSIYFGSHSJYEVAARDRFAIUMLGLSZXZBAHDJYGOSLQDVWWSFCFEGRIPRPLVBZFHHNNEVDEKJSOOKFTDSOXVUASZYJNYHKQZXPFUEEIMZKSUXSSZAVMLJAHVAPZKTVIDDAIUGFHSIYFGSOLLYZINWVQGSOMERLQDMEJCMPLRYRWRIJFMIJHRSNSDEJQPTPYJNYKWRKTFFGRFBWSZKVMLGIEUJFGYCENNOHSLWNZAZVWYSOWYFCRWRUZYYERUBPHDMEPECKQLHSOJHWJPZPSFQTHPPVRZFAXYFYAWGYNYSNCNJYSAHYZXOJMKDXCNIKMLBYPVAPFJIJXHSJIVIVWJHEJDGWRULPBPICSPGOAZYSCQXKMPGAULFWWPMVXWWBINNWZXIMNZZARKFYRWPCBTZHFVQZGP";
    //String cipherText = "IFEDHGFEDCBA";

    BaseUtils base26 = new Base26();
    VigenereCipher vigenereCipher = new VigenereCipher(base26);

    vigenereCipher.kasiskiTest(cipherText, 9);
  }

  //@Test
  public void bruteForceAttempt() {
    BaseUtils base26 = new Base26();
    VigenereCipher vigenereCipher = new VigenereCipher(base26);
    String vigenereCipherText = "FYRPLVLZCZIRWEVEWINNVWRUHLBLVFATRAJFWPJAVPTYSPLVBLMKJCNQSYEEGPTNIVFYRXIRZEWBYCGFHSIYFGSHSJYEVAARDRFAIUMLGLSZXZBAHDJYGOSLQDVWWSFCFEGRIPRPLVBZFHHNNEVDEKJSOOKFTDSOXVUASZYJNYHKQZXPFUEEIMZKSUXSSZAVMLJAHVAPZKTVIDDAIUGFHSIYFGSOLLYZINWVQGSOMERLQDMEJCMPLRYRWRIJFMIJHRSNSDEJQPTPYJNYKWRKTFFGRFBWSZKVMLGIEUJFGYCENNOHSLWNZAZVWYSOWYFCRWRUZYYERUBPHDMEPECKQLHSOJHWJPZPSFQTHPPVRZFAXYFYAWGYNYSNCNJYSAHYZXOJMKDXCNIKMLBYPVAPFJIJXHSJIVIVWJHEJDGWRULPBPICSPGOAZYSCQXKMPGAULFWWPMVXWWBINNWZXIMNZZARKFYRWPCBTZHFVQZGP";
    VigenereKey vigenereKey  = null;
    String vigenereCipherRecoveredText = null;
    int score;

    for (int k1 = 0; k1 < Base26.CIPHER_BASE; k1++) {
      for (int k2 = 0; k2 < Base26.CIPHER_BASE; k2++) {
        for (int k3 = 0; k3 < Base26.CIPHER_BASE; k3++) {
          for (int k4 = 0; k4 < Base26.CIPHER_BASE; k4++) {
            for (int k5 = 0; k5 < Base26.CIPHER_BASE; k5++) {
              for (int k6 = 0; k6 < Base26.CIPHER_BASE; k6++) {
                String key = "" + base26.intToChar(k1)
                                + base26.intToChar(k2)
                                + base26.intToChar(k3)
                                + base26.intToChar(k4)
                                + base26.intToChar(k5)
                                + base26.intToChar(k6);

                vigenereKey = new VigenereKey(key, base26);

                vigenereCipherRecoveredText = vigenereCipher.decipher(vigenereCipherText, vigenereKey);

                score = vigenereCipher.countSubstrings(vigenereCipherRecoveredText, "the");
                score += vigenereCipher.countSubstrings(vigenereCipherRecoveredText, "and");
                score += vigenereCipher.countSubstrings(vigenereCipherRecoveredText, "tha");
                score += vigenereCipher.countSubstrings(vigenereCipherRecoveredText, "ent");
                score += vigenereCipher.countSubstrings(vigenereCipherRecoveredText, "ion");

                if( score > 3) {
                  System.out.println(score + ": (" + key + "): " + vigenereCipherRecoveredText);
                }

              }
            }
          }
          System.out.println("  " + k3);
        }
        System.out.println(" " + k2);
      }
      System.out.println(k1);
    }
  }


  @Test
  public void bruteForceAttempt2() {
    BaseUtils base26 = new Base26();
    VigenereCipher vigenereCipher = new VigenereCipher(base26);
    String vigenereCipherText = "FYRPLVLZCZIRWEVEWINNVWRUHLBLVFATRAJFWPJAVPTYSPLVBLMKJCNQSYEEGPTNIVFYRXIRZEWBYCGFHSIYFGSHSJYEVAARDRFAIUMLGLSZXZBAHDJYGOSLQDVWWSFCFEGRIPRPLVBZFHHNNEVDEKJSOOKFTDSOXVUASZYJNYHKQZXPFUEEIMZKSUXSSZAVMLJAHVAPZKTVIDDAIUGFHSIYFGSOLLYZINWVQGSOMERLQDMEJCMPLRYRWRIJFMIJHRSNSDEJQPTPYJNYKWRKTFFGRFBWSZKVMLGIEUJFGYCENNOHSLWNZAZVWYSOWYFCRWRUZYYERUBPHDMEPECKQLHSOJHWJPZPSFQTHPPVRZFAXYFYAWGYNYSNCNJYSAHYZXOJMKDXCNIKMLBYPVAPFJIJXHSJIVIVWJHEJDGWRULPBPICSPGOAZYSCQXKMPGAULFWWPMVXWWBINNWZXIMNZZARKFYRWPCBTZHFVQZGP";
    VigenereKey vigenereKey  = null;
    String vigenereCipherRecoveredText = null;
    int c;

    for (int k1 = 0; k1 < Base26.CIPHER_BASE; k1++) {
      for (int k2 = 0; k2 < Base26.CIPHER_BASE; k2++) {
        for (int k3 = 0; k3 < Base26.CIPHER_BASE; k3++) {
                String key = "" + base26.intToChar(k1)
                                + base26.intToChar(k2)
                                + base26.intToChar(k3)
                                + "wer";

                vigenereKey = new VigenereKey(key, base26);

                vigenereCipherRecoveredText = vigenereCipher.decipher(vigenereCipherText, vigenereKey);

                c = vigenereCipher.countSubstrings(vigenereCipherRecoveredText, "the");
                c += vigenereCipher.countSubstrings(vigenereCipherRecoveredText, "and");
                c += vigenereCipher.countSubstrings(vigenereCipherRecoveredText, "tha");
                c += vigenereCipher.countSubstrings(vigenereCipherRecoveredText, "ent");
                c += vigenereCipher.countSubstrings(vigenereCipherRecoveredText, "ion");

                if( c > 12) {
                  System.out.println(c + ": (" + key + "): " + vigenereCipherRecoveredText);
                }

          // System.out.println("  " + k3);
        }
        //System.out.println(" " + k2);
      }
      //System.out.println(k1);
    }
  }


}
