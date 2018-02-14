/**
 * A command line program that converts a list of input signatures from the command line to a list of matching words
 *
 * @author Connor Wilkes
 * @version 7/2/2018
 */


package predictive;

import static predictive.PredictivePrototype.signatureToWords;

public class Sigs2WordsProto {

    public static void main(String[] args) {

        for (String signature : args) {

            System.out.println(signature + " " + signatureToWords(signature));
        }
    }
}
