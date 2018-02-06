package predictive;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Set;

import static predictive.HelperMethods.*;

public class TreeDictionary implements Dictionary {

    public TreeDictionary(String path) {

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
    
    @Override
    public Set<String> signatureToWords(String signature) {
        return null;
    }
}
