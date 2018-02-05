package predictive;

public class WordSig implements Comparable<WordSig> {

    private String word;
    private String signature;

    /**
     * Constructor for the WordSig class
     *
     * @param word      the word to associate with the signature
     * @param signature the signature to associate with the word
     */
    public WordSig(String word, String signature) {
        this.word = word;
        this.signature = signature;
    }

    /**
     * Getter for the word
     *
     * @return the word
     */
    public String getWord() {
        return word;
    }

    /**
     * Setter for the word
     *
     * @param word word to set
     */
    public void setWord(String word) {
        this.word = word;
    }

    /**
     * Getter for the signature
     *
     * @return the signature
     */
    public String getSignature() {
        return signature;
    }

    /**
     * Setter for the signature
     *
     * @param signature signature to set
     */
    public void setSignature(String signature) {
        this.signature = signature;
    }

    /**
     * toString method for the WordSig class
     *
     * @return the WordSig class as a string
     */
    @Override
    public String toString() {
        return this.word + " " + this.signature + "\n";
    }

    /**
     * Compares two members of the WordSig class by their name and signature for sorting
     *
     * @param ws other WordSig to compare
     * @return negative if this WordSig is smaller, 0 if equal and positive if this WordSig is greater
     */
    @Override
    public int compareTo(WordSig ws) {

        if (this.signature.compareTo(ws.getSignature()) != 0) {
            return this.signature.compareTo(ws.getSignature());
        } else {
            return this.getWord().compareTo(ws.getWord());
        }


    }

    /**
     * Compares two members of the WordSig class by their signatures to search
     *
     * @param ws other WordSig to compare
     * @return negative if this WordSig is smaller, 0 if equal and positive if this WordSig is greater
     */
    public int compareToSearch(WordSig ws) {

        return this.signature.compareTo(ws.getSignature());

    }
}
