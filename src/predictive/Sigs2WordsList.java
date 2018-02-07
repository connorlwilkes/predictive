/**
 * A command line program that converts a list of input signatures from the command line to a list of matching signatures
 *
 * @author Connor Wilkes
 * @version 7/2/2018
 */

package predictive;

public class Sigs2WordsList {

    public static void main(String[] args) {

        ListDictionary dictionary = new ListDictionary("dictionary");

        for (String signature : args) {

            System.out.println(signature + " " + dictionary.signatureToWords(signature));
        }
    }

}
