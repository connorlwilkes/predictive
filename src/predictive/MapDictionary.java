package predictive;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import static predictive.HelperMethods.*;

public class MapDictionary implements Dictionary {

    private String path;
    private Map<String, Set<String>> wordsAndSignatures;

    public MapDictionary(String path) {

        wordsAndSignatures = new HashMap<>();

        readFromFileAndAddToList(path);

    }

    private void readFromFileAndAddToList(String path) {

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

    public void addToExistingSet(String word, String signature) {

        Set<String> set = wordsAndSignatures.get(signature);
        set.add(word);
        wordsAndSignatures.put(signature, set);

    }


    @Override
    public Set<String> signatureToWords(String signature) {

        Set<String> possibleWords = new HashSet<>();

        if (wordsAndSignatures.containsKey(signature)) {

            possibleWords = wordsAndSignatures.get(signature);
        }

        return possibleWords;
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
