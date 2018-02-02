package predictive;

public class Sigs2WordsList {

    public static void main(String[] args) {

        ListDictionary dictionary = new ListDictionary("dictionary");

        for (String signature : args) {

            System.out.println(signature + " " + dictionary.signatureToWords(signature));
        }
    }

}
