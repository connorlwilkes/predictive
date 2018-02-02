package predictive;

import org.junit.Test;

import static org.junit.Assert.*;

public class ListDictionaryTest {

    @Test
    public void Test1() {

        ListDictionary dictionary = new ListDictionary("dictionary");

        System.out.println(dictionary);

        System.out.println(dictionary.signatureToWords("4663"));

    }

}