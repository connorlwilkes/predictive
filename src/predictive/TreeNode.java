/**
 * TreeNode class to create a tree. Each node of the tree has children in the form of an array of other tree nodes. Each
 * node has a list of words associated with it.
 *
 * @author Connor Wilkes
 * @version 12/2/2018
 */
package predictive;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {

    private List<String> words = new ArrayList<>();
    private TreeNode[] children;

    /**
     * Constructor for the TreeNode class
     */
    public TreeNode() {
        this.children = new TreeNode[8];

    }

    /**
     * Getter for the words
     *
     * @return the list of words
     */
    public List<String> getWords() {
        return words;
    }

    /**
     * Setter for the words
     *
     * @param words the list to change the words to
     */
    public void setWords(List<String> words) {
        this.words = words;
    }

    /**
     * Getter for the children
     *
     * @return the children array
     */
    public TreeNode[] getChildren() {
        return children;
    }

    /**
     * Setter for the children
     *
     * @param children the array to change the children to
     */
    public void setChildren(TreeNode[] children) {
        this.children = children;
    }

    /**
     * Adds a word to the node's word list
     *
     * @param word word to add
     */
    public void addWord(String word) {
        words.add(word);
    }

    /**
     * toString method of the TreeNode class
     *
     * @return string interpretation of the TreeNode
     */
    @Override
    public String toString() {

        StringBuffer toReturn = new StringBuffer();

        toReturn.append(words + "\n");

        for (int i = 0; i < children.length; i++) {

            toReturn.append(this.children[i].getWords().toString());


        }

        return toReturn.toString();
    }

    /**
     * Adds children to the node
     */
    public void addChildren() {

        for (int i = 0; i < children.length; i++) {

            children[i] = new TreeNode();
        }
    }

    /**
     * Checks if the node's children are empty
     *
     * @return true if so, false otherwise
     */
    public boolean isEmpty() {

        for (int i = 0; i < children.length; i++) {

            if (children[i] != null) {
                return false;
            }
        }
        return true;
    }
}
