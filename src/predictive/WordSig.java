package predictive;

public class WordSig implements Comparable<WordSig> {

    private String word;
    private String signature;

    public WordSig(String word, String signature) {
        this.word = word;
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
    public String toString() {
        return this.word + " " + this.signature + "\n";
    }

    @Override
    public int compareTo(WordSig ws) {

        if (!(this.signature.compareTo(ws.getSignature()) == 0)) {
            return this.signature.compareTo(ws.getSignature());
        } else {
            return this.getWord().compareTo(ws.getWord());
        }

    }
}
