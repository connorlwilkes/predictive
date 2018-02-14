package predictive;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import static predictive.HelperMethods.wordToSignature;

public class DictionaryModel extends Observable implements DictionaryModelInterface {

    private TreeDictionary dictionary;
    private StringBuilder word;
    private List<String> message;
    private List<String> matches;
    private String currentMatch;
    private int indexCounter;


    public DictionaryModel(String dictionaryFile) {
        dictionary = new TreeDictionary(dictionaryFile);
        setUp();
    }

    public DictionaryModel() {
        dictionary = new TreeDictionary("dictionary");
        setUp();
    }

    public void setUp() {
        word = new StringBuilder();
        message = new ArrayList<>();
        matches = new ArrayList<>();
        indexCounter = 0;
    }

    @Override
    public List<String> getMessage() {
        return message;
    }

    @Override
    public void addCharacter(char key) {
        word.append(key);
        matches.addAll(dictionary.signatureToWords(wordToSignature(word.toString())));
        matches.sort(String::compareTo);
        indexCounter = 0;
    }

    @Override
    public void removeLastCharacter() {
        word.delete(word.length() - 1, word.length() - 1);
        matches.addAll(dictionary.signatureToWords(wordToSignature(word.toString())));
        matches.sort(String::compareTo);
        indexCounter = 0;
    }

    @Override
    public void nextMatch() {
        currentMatch = matches.get(indexCounter);

        if (indexCounter == (matches.size() - 1)) {
            indexCounter = 0;
        } else {
            indexCounter =+ 1;
        }
    }

    @Override
    public void acceptWord() {
        message.add(word.toString());
    }
}
