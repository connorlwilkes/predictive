package predictive;

import org.junit.Test;

import static org.junit.Assert.*;

public class WordSigTest {

    @Test
    public void Test1() {

        WordSig a = new WordSig("a", "123");
        WordSig b = new WordSig("b", "123");

        int expected = -1;
        int actual = a.compareTo(b);

        assertEquals(expected, actual);

    }

    @Test
    public void Test2() {

        WordSig a = new WordSig("a", "123");
        WordSig b = new WordSig("a", "123");

        int expected = 0;
        int actual = a.compareTo(b);

        assertEquals(expected, actual);

    }

    @Test
    public void Test3() {

        WordSig a = new WordSig("a", "1");
        WordSig b = new WordSig("a", "2");

        int expected = -1;
        int actual = a.compareTo(b);

        assertEquals(expected, actual);

    }

    @Test
    public void Test4() {

        WordSig a = new WordSig("", "100");
        WordSig b = new WordSig("", "10");

        int expected = 1;
        int actual = a.compareTo(b);

        assertEquals(expected, actual);

    }
    
}