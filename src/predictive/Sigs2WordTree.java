/**
 * A command line program that converts a list of input signatures from the command line to a tree of matching signatures
 *
 * @author Connor Wilkes
 * @version 7/2/2018
 */

package predictive;

public class Sigs2WordTree {

    public static void main(String[] args) {

        TreeDictionary dictionary = new TreeDictionary("/usr/share/dict/words");

        for (String signature : args) {

            System.out.println(signature + " " + dictionary.signatureToWords(signature));
        }
    }


}
