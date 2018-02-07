package predictive;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import static predictive.HelperMethods.*;

public class TreeDictionary implements Dictionary {

    TreeNode tree = new TreeNode();

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

    public TreeNode getTree() {
        return tree;
    }

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

    public static boolean contains(List<String> l, String word) {

        for (int i = 0; i < l.size(); i++) {

            if (l.get(i).equals(word)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        TreeDictionary a = new TreeDictionary("ant");


        System.out.println(a.signatureToWords("228"));



    }
}
