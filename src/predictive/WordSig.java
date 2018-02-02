package predictive;

public class WordSig implements Comparable<WordSig> {

    private String word;
    private String signature;

    public WordSig(String word, String signature) {
        this.word =  word;
        this.signature = signature;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    @Override
    public int compareTo(WordSig otherToCompare) {
        return this.word.compareTo(otherToCompare.getWord());

    }
}
