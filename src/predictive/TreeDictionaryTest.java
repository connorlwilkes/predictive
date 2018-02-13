package predictive;

import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class TreeDictionaryTest {

    @Test
    public void test1() {

        TreeDictionary dictionary = new TreeDictionary("ant");

        Set<String> expected = new HashSet<>();
        Set<String> actual = dictionary.signatureToWords("");

        assertEquals(expected, actual);

    }

    @Test
    public void test2() {

        TreeDictionary dictionary = new TreeDictionary("ant");

        Set<String> expected = new HashSet<>();
        Set<String> actual = dictionary.signatureToWords("268");

        expected.add("a");
        expected.add("ant");
        expected.add("cat");
        expected.add("any");

        System.out.println(actual);

        assertEquals(expected, actual);

    }

}