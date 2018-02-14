/**
 * A PredictivePrototype class that reads from a file words and converts them to digit signatures allowing a user to
 * search the file for a particular signature that matches a particular word.
 *
 * @author Connor Wilkes
 * @version 6/2/2018
 */


package predictive;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import static predictive.HelperMethods.charToInt;
import static predictive.HelperMethods.checkWord;

public class PredictivePrototype {

    /**
     * Takes a string and converts it to the keypad entry that would have been typed on a traditional mobile phone. Uses
     * StringBuffer because it is more efficient as unlike using concatenation each time a new String is added to the
     * buffer there is not another variable added to the stack.
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
     * Takes a number signature akin to that from the numberpad mobile-phone texting
     *
     * @param signature
     * @return
     */
    public static Set<String> signatureToWords(String signature) {

        Set<String> potentialWords = new HashSet<>();

        try {
            String filename = "dictionary";

            File file = new File(filename);
            Scanner in = new Scanner(file);

            while (in.hasNextLine()) {

                String line = in.nextLine();
                if (checkWord(line, signature) && !(potentialWords.contains(line))) {

                    potentialWords.add(line.toLowerCase());
                }
            }

        } catch (FileNotFoundException e) {

            System.out.println("File not found");
        }

        return potentialWords;

    }

}
