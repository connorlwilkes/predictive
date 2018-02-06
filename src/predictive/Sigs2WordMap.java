package predictive;

public class Sigs2WordMap {

    public static void main(String[] args) {

        MapDictionary dictionary = new MapDictionary("dictionary");

        for (String signature : args) {

            System.out.println(signature + " " + dictionary.signatureToWords(signature));

        }

    }
}
