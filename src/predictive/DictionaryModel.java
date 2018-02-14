package predictive;


import java.util.List;

public class DictionaryModel implements DictionaryModelInterface {

    TreeDictionary dictionary;


    public DictionaryModel(String dictionaryFile) {

        this.dictionary = new TreeDictionary(dictionaryFile);

    }

    public DictionaryModel() {

        this.dictionary = new TreeDictionary("dictionary");

    }

    @Override
    public List<String> getMessage() {
        return null;
    }

    @Override
    public void addCharacter(char key) {

    }

    @Override
    public void removeLastCharacter() {

    }

    @Override
    public void nextMatch() {

    }

    @Override
    public void acceptWord() {

    }
}
