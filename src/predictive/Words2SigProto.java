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
