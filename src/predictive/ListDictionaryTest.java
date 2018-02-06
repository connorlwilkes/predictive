package predictive;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class ListDictionaryTest {

    @Test
    public void Test1() {

        ListDictionary dictionary = new ListDictionary("dictionary");

        Set<String> expected = new HashSet<>();


        expected.add("hood");
        expected.add("good");
        expected.add("hone");
        expected.add("hoof");
        expected.add("home");
        expected.add("gone");

        System.out.println(dictionary);

        Set<String> actual = dictionary.signatureToWords("4663");


        assertEquals(expected, actual);


    }

    @Test
    public void Test2() {

        ListDictionary dictionary = new ListDictionary("dictionary");

        Set<String> expected = new HashSet<>();

        expected.add("car");

        Set<String> actual = dictionary.signatureToWords("227");

        assertEquals(expected, actual);


    }

    @Test
    public void Test3() {

        ListDictionary dictionary = new ListDictionary("dictionary");

        Set<String> expected = new HashSet<>();

        Set<String> actual = dictionary.signatureToWords("123");
        assertEquals(expected, actual);

    }

    @Test
    public void Test4() {

        ListDictionary dictionary = new ListDictionary("dictionary");

        Set<String> expected = new HashSet<>();
        expected.add("zebra");

        Set<String> actual = dictionary.signatureToWords("93272");
        assertEquals(expected, actual);

    }
}