/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tdd;

import org.hamcrest.Matcher;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.Test;
import org.mockito.ArgumentMatcher;

/**
 *
 * @author Gamal Shaban OLC
 */
public class NumberNamesTest {

    @Test
    public void isReadingOneDigit() throws Exception {
        assertThat("one", readNumber(1));
        assertThat("nine", readNumber(9));
    }

    /*@Test
    public void isReadingOneDigit2() throws Exception {
        
    }*/

    @Test
    public void isReadingTwoDigits() throws Exception {
        assertThat("twelve", readNumber(12));
    }

    @Test
    public void isReadingThreeDigits() throws Exception {
        assertThat("Three Hundred and forty five", readNumber(345));
    }

    @Test
    public void isReadingSixDigits() throws Exception {
        assertThat("forty three million, one hundred and twelve thousand, six hundred and three", readNumber(43112603));
    }

    private Matcher<String> readNumber(final Integer digit) {
        return new ArgumentMatcher<String>() {
            @Override
            public boolean matches(Object argument) {
                return NumberNames.read(digit).equalsIgnoreCase(argument.toString());
            }
        };
    }
}
