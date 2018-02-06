package predictive;

import jdk.nashorn.api.tree.Tree;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Set;

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
    }

    public void createTree(String word, int position, TreeNode node) {

        if (position == word.length()) {
            return;
        }

        String signature = wordToSignature(word);
        int currentChar = Character.getNumericValue(signature.charAt(position)) - 2;


        if (node.getChildren()[currentChar].isEmpty()) {
            node.getChildren()[currentChar].addWord(word);
            TreeNode toAdd = new TreeNode();
            toAdd.addChildren();
            toAdd.addWord(word);
            node.getChildren()[currentChar] = toAdd;
            createTree(word, position + 1, node.getChildren()[currentChar]);
        } else {
            node.addWord(word);
            createTree(word, position + 1, node.getChildren()[currentChar]);
        }
    }

    public TreeNode getTree() {
        return tree;
    }

    @Override
    public Set<String> signatureToWords(String signature) {

        return null;
    }


    public static void main(String[] args) {

        TreeDictionary a = new TreeDictionary("ant");
        System.out.println(a.getTree());



    }
}
