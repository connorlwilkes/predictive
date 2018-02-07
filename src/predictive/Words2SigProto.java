/**
 * A command line program that converts a list of input words from the command line to a list of matching signatures
 *
 * @author Connor Wilkes
 * @version 7/2/2018
 */


package predictive;

import static predictive.PredictivePrototype.wordToSignature;

public class Words2SigProto {

    public static void main(String[] args) {

        for (String word : args) {

            if (word.matches("[a-zA-Z]+")) {

                System.out.println(word + " " + wordToSignature(word));
            }

        }
    }
}
