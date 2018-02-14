/**
 * A ListDictionary class that takes a file and stores words alongside their digit signatures in a list class.
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

public class ListDictionary implements Dictionary {

    private ArrayList<WordSig> wordsAndSignatures;

    /**
     * Constructor for the ListDictionary class
     *
     * @param path the path to the dictionary file
     */
    public ListDictionary(String path) {

        wordsAndSignatures = new ArrayList<>();

        readFromFileAndAddToList(path);
        sortAndRemoveDuplicates();

    }

    /**
     * Reads from a file and enters information into an ArrayList
     *
     * @param path the path to the file
     */
    private void readFromFileAndAddToList(String path) {

        try {
            File file = new File(path);
            Scanner in = new Scanner(file);

            while (in.hasNextLine()) {
                String line = in.nextLine();
                if (isValidWord(line) && !(wordsAndSignatures.contains(line))) {
                    WordSig toAdd = new WordSig(line.toLowerCase(), wordToSignature(line));
                    wordsAndSignatures.add(toAdd);
                }
            }

        } catch (FileNotFoundException e) {

            System.out.println("File not found");
        }
    }

    /**
     * Sorts and removes duplicates in an array
     */
    private void sortAndRemoveDuplicates() {

        wordsAndSignatures.sort(WordSig::compareTo);

        for (int i = 1; i < wordsAndSignatures.size(); i++) {

            if (wordsAndSignatures.get(i).getWord().equals(wordsAndSignatures.get(i - 1).getWord())) {
                wordsAndSignatures.remove(i - 1);
            }
        }
    }

    /**
     * Getter for the wordsAndSignatures ArrayList
     *
     * @return the wordsAndSignatures ArrayList
     */
    public ArrayList<WordSig> getWordsAndSignatures() {
        return wordsAndSignatures;
    }

    /**
     * Setter for the wordAndSignatures ArrayList
     *
     * @param wordsAndSignatures the new array
     */
    public void setWordsAndSignatures(ArrayList<WordSig> wordsAndSignatures) {
        this.wordsAndSignatures = wordsAndSignatures;
    }


    /**
     * toString method for the ListDictionary class
     *
     * @return string of the ListDictionary class
     */
    @Override
    public String toString() {

        StringBuffer toReturn = new StringBuffer();

        for (WordSig ws : wordsAndSignatures) {
            toReturn.append(ws.toString());
        }

        return toReturn.toString();
    }

    /**
     * Method finds from a dictionary words that match a mobile keypad signature
     *
     * @param signature the keypad signature to check
     * @return a set of the potential words that signature could equal
     */
    @Override
    public Set<String> signatureToWords(String signature) {

        Set<String> potentialWords = new HashSet<>();

        int index = Collections.binarySearch(wordsAndSignatures, new WordSig(null, signature), WordSig::compareToSearch);

        if (index < 0) {
            return potentialWords;
        }

        return addToSet(index, signature);
    }

    /**
     * Adds to a number set a particular set of values starting at a specified index and working around that index.
     * Assumes the list is sorted
     *
     * @param index     the index to start at
     * @param signature the signature to match
     * @return a set with the correct values present
     */
    public Set<String> addToSet(int index, String signature) {

        Set<String> potentialWords = new HashSet<>();

        int i = index;

        while (i < wordsAndSignatures.size() && wordsAndSignatures.get(i).getSignature().equals(signature)) {

            potentialWords.add(wordsAndSignatures.get(i).getWord());
            i++;
        }

        i = (index - 1);

        while (i >= 0 && wordsAndSignatures.get(i).getSignature().equals(signature)) {

            potentialWords.add(wordsAndSignatures.get(i).getWord());
            i--;
        }

        return potentialWords;
    }


}
