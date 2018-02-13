package predictive;

import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class MapDictionaryTest {

    @Before

    @Test
    public void test1() {

        MapDictionary dictionary = new MapDictionary("dictionary");

        Set<String> expected = new HashSet<>();
        Set<String> actual = dictionary.signatureToWords("4663");

        expected.add("hood");
        expected.add("good");
        expected.add("hone");
        expected.add("hoof");
        expected.add("home");
        expected.add("gone");

        assertEquals(expected, actual);

    }

    @Test
    public void test2() {

        MapDictionary dictionary = new MapDictionary("dictionary");

        Set<String> expected = new HashSet<>();
        Set<String> actual = dictionary.signatureToWords("");

        assertEquals(expected, actual);

    }



}