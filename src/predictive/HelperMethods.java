/**
 * Helper static methods for the predictive class
 *
 * @author Connor Wilkes
 * @version 7/2/2018
 */

package predictive;

import java.util.ArrayList;
import java.util.List;

public class HelperMethods {

    /**
     * Takes a string and converts it to the keypad entry that would have been typed on a traditional mobile phone
     *
     * @param word the word to convert
     * @return a string of the keys
     */
    protected static String wordToSignature(String word) {

        char[] wordCharArray = word.toCharArray();
        StringBuffer stringBuffer = new StringBuffer();

        for (char character : wordCharArray) {

            stringBuffer.append(charToInt(character));
        }

        return stringBuffer.toString();
    }


    /**
     * Checks if a word is valid and matches a signature
     *
     * @param wordToCheck word to check
     * @param signature   signature to compare it to
     * @return true if the word is valid and matches and false if otherwise
     */
    protected static boolean checkWord(String wordToCheck, String signature) {

        String wordSignature = PredictivePrototype.wordToSignature(wordToCheck);
        return wordSignature.equals(signature) && isValidWord(wordToCheck);

    }

    /**
     * Checks if a word is valid
     *
     * @param wordToCheck the word to check
     * @return true if valid, false if otherwise
     */
    protected static boolean isValidWord(String wordToCheck) {

        return wordToCheck.matches("[a-zA-Z]+");
    }

    /**
     * Takes a char and converts it into the correct number on the keypad
     *
     * @param charToConvert char to convert to keypad number
     * @return the number on the keypad associated with that particular char
     */
    protected static char charToInt(char charToConvert) {

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

    /**
     * Trims the Strings in a list to a particular length
     *
     * @param l               list to process
     * @param sizeOfSignature size to trim to
     * @return the list with the trimmed values
     */
    public static List<String> trimList(List<String> l, int sizeOfSignature) {

        List<String> toReturn = new ArrayList<>();

        for (int i = 0; i < l.size(); i++) {

            if (l.get(i).length() > sizeOfSignature) {

                toReturn.add(l.get(i).substring(0, sizeOfSignature));

            } else if (l.get(i).length() == sizeOfSignature) {

                toReturn.add(l.get(i));
            }

        }

        return toReturn;
    }


}
