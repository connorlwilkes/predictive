package predictive;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

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

    public static String wordToSignature(String word) {

        char[] wordCharArray = word.toCharArray();
        StringBuffer stringBuffer = new StringBuffer();

        for (char character : wordCharArray) {

            stringBuffer.append(charToInt(character));
        }

        return stringBuffer.toString();
    }

    public static boolean isValidWord(String wordToCheck) {

        return wordToCheck.matches("[a-zA-Z]+");
    }

    public static char charToInt(char charToConvert) {

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
