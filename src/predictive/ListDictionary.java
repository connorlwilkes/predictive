package predictive;

import java.util.ArrayList;
import java.util.Set;

public class ListDictionary implements Dictionary {

    private ArrayList<WordSig> wordsAndSignatures;

    public ListDictionary(String path) {

    }

    @Override
    public Set<String> signatureToWords(String signature) {
        return null;
    }

    /**
     * Takes a string and converts it to the keypad entry that would have been typed on a traditional mobile phone
     *
     * @param word the word to convert
     * @return a string of the keys
     */
    public static String wordToSignature(String word) {

        char[] wordCharArray = word.toCharArray();
        StringBuffer stringBuffer = new StringBuffer();

        for (char character : wordCharArray) {

            stringBuffer.append(charToInt(character));
        }

        return stringBuffer.toString();
    }

    /**
     * Takes a char and converts it into the correct number on the keypad
     *
     * @param charToConvert char to convert to keypad number
     * @return the number on the keypad associated with that particular char
     */
    private static char charToInt(char charToConvert) {

        int unicode = (int) charToConvert;

        if (unicode >= 65 && unicode <= 67 || unicode >= 97 && unicode <= 99) {
            return '2';
        } else if (unicode >= 68 && unicode <= 70 || unicode >= 100 && unicode <= 102) {
            return '3';
        } else if (unicode >= 71 && unicode <= 73 || unicode >= 103 && unicode <= 105) {
            return '4';
        } else if (unicode >= 74 && unicode <= 76 || unicode >= 106 && unicode <= 108) {
            return '5';
        } else if (unicode >= 77 && unicode <= 79 || unicode >= 109 && unicode <= 111) {
            return '6';
        } else if (unicode >= 80 && unicode <= 83 || unicode >= 112 && unicode <= 115) {
            return '7';
        } else if (unicode >= 84 && unicode <= 86 || unicode >= 116 && unicode <= 118) {
            return '8';
        } else if (unicode >= 87 && unicode <= 90 || unicode >= 119 && unicode <= 122) {
            return '9';
        } else {
            return ' ';
        }
    }
}
