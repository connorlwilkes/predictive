/**
 * A MapDictionary class that takes a file and stores words alongside their digit signatures in a map class.
 * The class can then search for any particular signature input.
 *
 * @author Connor Wilkes
 * @version 6/2/2018
 */

package predictive;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import static predictive.HelperMethods.isValidWord;
import static predictive.HelperMethods.wordToSignature;

public class MapDictionary implements Dictionary {

    private String path;
    private Map<String, Set<String>> wordsAndSignatures;

    /**
     * Constructor for the MapDictionary class
     *
     * @param path path to the dictionary to process
     */
    public MapDictionary(String path) {

        wordsAndSignatures = new HashMap<>();

        readFromFileAndAddToMap(path);

    }

    /**
     * Reads from a dictionary file and adds the corresponding information to a map class
     *
     * @param path path to the dictionary
     */
    private void readFromFileAndAddToMap(String path) {


        String signature;

        try {
            File file = new File(path);
            Scanner in = new Scanner(file);

            while (in.hasNextLine()) {
                String line = in.nextLine();

                if (isValidWord(line)) {

                    signature = wordToSignature(line);

                    Set<String> toAdd = new HashSet<>();


                    if (wordsAndSignatures.containsKey(signature)) {
                        addToExistingSet(line, signature);

                    } else {
                        toAdd.add(line);
                        wordsAndSignatures.put(signature, toAdd);
                    }

                    toAdd.clear();
                }
            }

        } catch (FileNotFoundException e) {

            System.out.println("File not found");
        }
    }

    /**
     * Adds a word to an existing set in the map class
     *
     * @param word      word to add
     * @param signature signature of the word
     */
    public void addToExistingSet(String word, String signature) {

        Set<String> set = wordsAndSignatures.get(signature);
        set.add(word);
        wordsAndSignatures.put(signature, set);

    }

    /**
     * Converts a signature to words
     *
     * @param signature signature to convert
     * @return set of the potential words that match the signature
     */
    @Override
    public Set<String> signatureToWords(String signature) {

        Set<String> possibleWords = new HashSet<>();

        if (wordsAndSignatures.containsKey(signature)) {

            possibleWords = wordsAndSignatures.get(signature);
        }

        return possibleWords;
    }

    /**
     * toString method for the MapDictionary class
     *
     * @return string interpretation of MapDictionary
     */
    @Override
    public String toString() {
        return super.toString();
    }

}
