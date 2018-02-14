package predictive;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static predictive.PredictivePrototype.signatureToWords;
import static predictive.PredictivePrototype.wordToSignature;

public class PredictivePrototypeTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }


    // Tests for wordToSignature method

    @Test
    public void test1() {

        String expected = "4663";
        String actual = wordToSignature("home");

        assertEquals(expected, actual);
    }

    @Test
    public void test2() {

        String expected = "43556 96753";
        String actual = wordToSignature("hello world");;

        assertEquals(expected, actual);
    }

    @Test
    public void test3() {

        String expected = " ";
        String actual = wordToSignature(" ");

        assertEquals(expected, actual);
    }

    @Test
    public void test4() {

        String expected = "";
        String actual = "";

        assertEquals(expected, actual);
    }

    // Tests for signatureToWords method

    @Test
    public void test5() {

        Set<String> actual = signatureToWords("4663");
        Set<String> expected = new HashSet<>();

        expected.add("home");
        expected.add("gone");

        assertEquals(expected, actual);

    }

    @Test
    public void test6() {

        Set<String> actual = signatureToWords("227");
        Set<String> expected = new HashSet<>();

        expected.add("car");

        assertEquals(expected, actual);

    }

    @Test
    public void test7() {

        Set<String> actual = signatureToWords("6767");
        Set<String> expected = new HashSet<>();

        assertEquals(expected, actual);

    }

}