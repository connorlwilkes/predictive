package predictive;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TreeNode {

    private List<String> words = new ArrayList<>();
    private TreeNode[] children;
    private int number;

    public TreeNode() {
        this.children = new TreeNode[8];

    }

    public List<String> getWords() {
        return words;
    }

    public void setWords(List<String> words) {
        this.words = words;
    }

    public TreeNode[] getChildren() {
        return children;
    }

    public void setChildren(TreeNode[] children) {
        this.children = children;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void addWord(String word) {
        words.add(word);
    }

    @Override
    public String toString() {

        StringBuffer toReturn = new StringBuffer();

        toReturn.append(words + "\n");

        for (int i = 0; i < children.length; i++) {

            toReturn.append(this.children[i].getWords().toString());


        }

        return toReturn.toString();
    }

    public void addChildren() {

        for (int i = 0; i < children.length; i++) {

            children[i] = new TreeNode();
        }
    }

    public void addChild(int index, String word) {
        children[index] = new TreeNode();
        children[index].addWord(word);
    }

    public boolean isEmpty() {

        for (int i = 0; i < children.length; i++) {

            if (children[i] != null) {
                return false;
            }
        }
        return true;
    }
}
