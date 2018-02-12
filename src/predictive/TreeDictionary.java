/**
 * A TreeDictionary class that takes a file and stores words alongside their digit signatures in a tree class.
 * The class can then search for any particular signature input.
 *
 * @author Connor Wilkes
 * @version 12/2/2018
 */

package predictive;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import static predictive.HelperMethods.wordToSignature;

public class TreeDictionary implements Dictionary {

    TreeNode tree = new TreeNode();

    /**
     * Constructor for the TreeDictionary class
     *
     * @param path path to the list of words that are to be added to the dictionary
     */
    public TreeDictionary(String path) {

        tree.addChildren();

        try {

            File file = new File(path);
            Scanner in = new Scanner(file);

            while (in.hasNextLine()) {

                String line = in.nextLine().toLowerCase();
                createTree(line, 0, tree);

            }

        } catch (FileNotFoundException e) {

            System.out.println("File not found");
        }

        tree.getWords().clear();

    }

    /**
     * Method to add a node to a tree
     *
     * @param word     word to add
     * @param position position to look at within the word
     * @param node     the tree to edit
     */
    public void createTree(String word, int position, TreeNode node) {

        if (position == word.length()) {
            node.addWord(word);
            return;
        }

        String signature = wordToSignature(word);
        int currentIndex = Character.getNumericValue(signature.charAt(position)) - 2;


        if (node.getChildren()[currentIndex].isEmpty()) {
            node.addWord(word);
            TreeNode toAdd = new TreeNode();
            toAdd.addChildren();
            node.getChildren()[currentIndex] = toAdd;
        } else {
            node.addWord(word);
        }

        createTree(word, position + 1, node.getChildren()[currentIndex]);
    }

    /**
     * Getter for the tree
     *
     * @return the tree
     */
    public TreeNode getTree() {
        return tree;
    }

    /**
     * Takes a signature and matches it to a word in the dictionary
     *
     * @param signature signature to match
     * @return the list of potential words from the dictionary
     */
    @Override
    public Set<String> signatureToWords(String signature) {

        List<String> list = new ArrayList();
        StringBuffer signatureToProcess = new StringBuffer();

        int counter = signature.length();

        for (int i = 0; i <= signature.length(); i++) {
            int charsToCheck = signature.length() - i;

            for (int j = 0; j < counter; j++) {

                signatureToProcess.append(signature.charAt(j));
            }

            counter = counter - 1;
            signature = signatureToProcess.toString();
            signatureToProcess = new StringBuffer();

            list.addAll(findInTree(0, this.tree, convertToIndex(signature)));


        }

        return new HashSet<>(list);

    }

    /**
     * Finds the particular signature in the tree
     *
     * @param position  the position to look at in the word
     * @param tree      the tree to look in
     * @param signature the signature to look for
     * @return list of all the matches dependant on the signature entered from the tree
     */
    public static List<String> findInTree(int position, TreeNode tree, String signature) {

        if (position == signature.length()) {
            return tree.getWords();
        }

        int index = Character.getNumericValue(signature.charAt(position));

        if (tree.getChildren()[index] != null) {
            return findInTree(position + 1, tree.getChildren()[index], signature);
        } else {
            return tree.getWords();
        }

    }

    /**
     * Converts a signature string to a string of proper indexes
     *
     * @param s signature to convert
     * @return the signature as an index
     */
    public static String convertToIndex(String s) {

        StringBuffer toReturn = new StringBuffer();

        for (int i = 0; i < s.toCharArray().length; i++) {

            char toConvert = s.charAt(i);
            if (Character.getNumericValue(toConvert) >= 2) {
                int toAdd = Character.getNumericValue(toConvert) - 2;
                toReturn.append(toAdd);

            }
        }
        return toReturn.toString();
    }
}
