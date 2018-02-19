/**
 * A model class for the predictive class GUI
 *
 * @author Connor Wilkes
 * @version 18/2/2018
 */

package predictive;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class DictionaryModel extends Observable implements DictionaryModelInterface {

    private TreeDictionary dictionary;
    private StringBuilder signature;
    private List<String> message;
    private List<String> matches;
    private String currentMatch;
    private int indexCounter;
    private int messageCounter;


    /**
     * Constructor for the model
     *
     * @param dictionaryFile the path to the dictionary file
     */
    public DictionaryModel(String dictionaryFile) {
        dictionary = new TreeDictionary(dictionaryFile);
        setUp();
    }

    /**
     * A secondary constructor that utilises the standard dictionary path
     */
    public DictionaryModel() {
        dictionary = new TreeDictionary("dictionary");
        setUp();
    }

    /**
     * Sets up the class
     */
    public void setUp() {
        signature = new StringBuilder();
        message = new ArrayList<>();
        matches = new ArrayList<>();
        indexCounter = 0;
        messageCounter = 0;

        setChanged();
        notifyObservers();
    }

    /**
     * Getter method for the message list
     *
     * @return message
     */
    @Override
    public List<String> getMessage() {
        return message;
    }

    /**
     * Adds a character to the signature on key press
     *
     * @param key key that is pressed
     */
    @Override
    public void addCharacter(char key) {

        if (key == '1') {
            return;
        }

        signature.append(key);

        setUpMatches();

        setChanged();
        notifyObservers();
    }

    /**
     * Removes last character in the string
     */
    @Override
    public void removeLastCharacter() {

        if (signature.length() == 0) {
            return;
        }

        signature.setLength(signature.length() - 1);

        setUpMatches();

        setChanged();
        notifyObservers();
    }

    /**
     * Sets up the matches
     */
    public void setUpMatches() {

        matches.clear();
        matches.addAll(dictionary.signatureToWords(signature.toString()));
        signature.trimToSize();

        if (matches.isEmpty()) {
            currentMatch = "";
        } else {
            currentMatch = matches.get(0);
        }

        if (message.isEmpty()) {
            message.add(currentMatch);
        } else {
            message.remove(messageCounter);
            message.add(currentMatch);
        }

        indexCounter = 0;

    }

    /**
     * Cycles through potential matches on key press
     */
    @Override
    public void nextMatch() {

        if (matches.isEmpty()) {
            return;
        }

        if (indexCounter == (matches.size() - 1)) {
            indexCounter = 0;
        } else {
            indexCounter++;
        }

        currentMatch = matches.get(indexCounter);
        message.remove(messageCounter);
        message.add(currentMatch);

        setChanged();
        notifyObservers();
    }

    /**
     * Accepts the current word and adds it to the message
     */
    @Override
    public void acceptWord() {

        signature.delete(0, signature.length());
        matches.clear();
        indexCounter = 0;
        message.add("");
        messageCounter++;

        setChanged();
        notifyObservers();
    }
}
