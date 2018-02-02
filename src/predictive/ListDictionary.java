package predictive;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class ListDictionary implements Dictionary {

    private ArrayList<WordSig> wordsAndSignatures;
    private ArrayList<String> signatures;

    public ListDictionary(String path) {

        wordsAndSignatures = new ArrayList<>();
        signatures = new ArrayList<>();

        readFromFileAndAddToList(path);
        sortAndRemoveDuplicates();
        createSignaturesList();

    }

    private void readFromFileAndAddToList(String path) {

        try {
            File file = new File(path);
            Scanner in = new Scanner(file);

            while (in.hasNextLine()) {
                String line = in.nextLine();
                if (isValidWord(line) && !(wordsAndSignatures.contains(line))) {
                    WordSig toAdd = new WordSig(line, wordToSignature(line));
                    wordsAndSignatures.add(toAdd);
                }
            }

        } catch (FileNotFoundException e) {

            System.out.println("File not found");
        }
    }

    private void sortAndRemoveDuplicates() {

        wordsAndSignatures.sort(WordSig::compareTo);

        for (int i = 1; i < wordsAndSignatures.size(); i++) {

            if (wordsAndSignatures.get(i).getWord().equals(wordsAndSignatures.get(i - 1).getWord())) {
                wordsAndSignatures.remove(i - 1);
            }
        }
    }

    private void createSignaturesList() {

        for (WordSig ws : wordsAndSignatures) {
            signatures.add(ws.getSignature());
        }
    }

    public ArrayList<WordSig> getWordsAndSignatures() {
        return wordsAndSignatures;
    }

    public ArrayList<String> getSignatures() {
        return signatures;
    }

    public void setWordsAndSignatures(ArrayList<WordSig> wordsAndSignatures) {
        this.wordsAndSignatures = wordsAndSignatures;
    }


    @Override
    public String toString() {

        StringBuffer toReturn = new StringBuffer();

        for (WordSig ws : wordsAndSignatures) {
            toReturn.append(ws.toString());
        }

        return toReturn.toString();
    }

    @Override
    public Set<String> signatureToWords(String signature) {

        boolean isPresent = true;
        Set<String> potentialWords = new HashSet<>();

        int index = Collections.binarySearch(signatures, signature);

        for (int i = index; i < signatures.size(); i++) {

            if (wordsAndSignatures.get(i).getSignature().equals(signature)) {
                System.out.println(wordsAndSignatures.get(i).getWord());
                potentialWords.add(wordsAndSignatures.get(i).getWord());
            }
        }

        for (int i = index; 0 < i; i--) {

            if (wordsAndSignatures.get(i).getSignature().equals(signature)) {
                System.out.println(wordsAndSignatures.get(i).getWord());
                potentialWords.add(wordsAndSignatures.get(i).getWord());
            }
        }

        return potentialWords;
    }

    /**
     * Takes a string and converts it to the keypad entry that would have been typed on a traditional mobile phone
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
     * Takes a char and converts it into the correct number on the keypad
     *
     * @param charToConvert char to convert to keypad number
     * @return the number on the keypad associated with that particular char
     */
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

    public static boolean isValidWord(String wordToCheck) {

        return wordToCheck.matches("[a-zA-Z]+");
    }
}
