package tdd;

import org.junit.Test;

import static org.junit.Assert.assertThat;

import static org.hamcrest.CoreMatchers.is;

public class NumberNamesTests {

    @Test
    public void shouldPrintOneFor1() {
        assertThat(stringify(1), is("one"));
    }

    @Test
    public void shouldPrintTwoFor2() {
        assertThat(stringify(2), is("two"));
    }

    @Test
    public void shouldPrintTwelveFor12() {
        assertThat(stringify(12), is("twelve"));
    }

    @Test
    public void shouldPrintFor100() {
        assertThat(stringify(100), is("one hundred"));
    }

    @Test
    public void shouldPrintFor124() {
        assertThat(stringify(124), is("one hundred twenty four"));
    }

    @Test
    public void shouldPrintFor102() {
        assertThat(stringify(102), is("one hundred two"));
    }

    @Test
    public void shouldPrintFor150() {
        assertThat(stringify(150), is("one hundred fifty"));
    }

    @Test
    public void shouldPrintFor1340() {
        assertThat(stringify(1340), is("one thousand three hundred fourty"));
    }

    @Test
    public void shouldPrintFor9469() {
        assertThat(stringify(9469), is("nine thousand four hundred sixty nine"));
    }

    @Test
    public void shouldPrintFor43112603() {
        assertThat(stringify(43112603), is("fourty three million one hundred twelve thousand six hundred three"));

    }

    public String stringify(int number) {
        String[] onesNames = { "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
        String[] teensNames = { "", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen",
                "eighteen", "nineteen" };
        String[] tensNames = { "", "ten", "twenty", "thirty", "fourty", "fifty", "sixty", "seventy", "eighty", "ninety" };

        int MILLION = 1000000;
        int THOUSAND = 1000;
        int HUNDRED = 100;
        int TEN = 10;
        int TWENTY = 20;

        StringBuffer sb = new StringBuffer();

        if (number >= MILLION) {
            return sb.append(stringify(number / MILLION)).append(" million ").append(stringify(number % MILLION))
                    .toString().trim();
        }
        if (number >= THOUSAND) {
            return sb.append(stringify(number / THOUSAND)).append(" thousand ").append(stringify(number % THOUSAND))
                    .toString().trim();
        }
        if (number >= HUNDRED) {
            return sb.append(stringify(number / HUNDRED)).append(" hundred ").append(stringify(number % HUNDRED))
                    .toString().trim();
        }
        if (number >= TEN) {
            if (number < TWENTY) {
                return teensNames[number % TEN];
            } else {
                return tensNames[number / TEN] + " " + stringify(number % TEN);
            }
        } else {
            return onesNames[number];
        }
    }

}
