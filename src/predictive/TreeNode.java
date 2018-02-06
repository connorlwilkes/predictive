package predictive;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {

    private List<String> words = new ArrayList<>();
    private TreeNode[] children;

    public TreeNode(List<String> words, TreeNode[] children) {
        this.words = words;
        this.children = children;
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
}
