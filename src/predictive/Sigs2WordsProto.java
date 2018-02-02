package predictive;
import static predictive.PredictivePrototype.signatureToWords;

public class Sigs2WordsProto {

    public static void main(String[] args) {

        for (String signature : args) {

            System.out.println(signature + " " + signatureToWords(signature));
        }
    }
}
