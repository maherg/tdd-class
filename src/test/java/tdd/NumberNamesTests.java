package tdd;

import org.junit.Test;

import static org.junit.Assert.assertThat;

import static org.hamcrest.CoreMatchers.is;

public class NumberNamesTests {

    private NumberNamer namer = new NumberNamer(new EnglishNumberNameRepository());

    @Test
    public void shouldPrintOneFor1() {
        assertThat(namer.stringify(1), is("one"));
    }

    @Test
    public void shouldPrintTwoFor2() {
        assertThat(namer.stringify(2), is("two"));
    }

    @Test
    public void shouldPrintTwelveFor12() {
        assertThat(namer.stringify(12), is("twelve"));
    }

    @Test
    public void shouldPrintFor100() {
        assertThat(namer.stringify(100), is("one hundred"));
    }

    @Test
    public void shouldPrintFor124() {
        assertThat(namer.stringify(124), is("one hundred twenty four"));
    }

    @Test
    public void shouldPrintFor102() {
        assertThat(namer.stringify(102), is("one hundred two"));
    }

    @Test
    public void shouldPrintFor150() {
        assertThat(namer.stringify(150), is("one hundred fifty"));
    }

    @Test
    public void shouldPrintFor1340() {
        assertThat(namer.stringify(1340), is("one thousand three hundred fourty"));
    }

    @Test
    public void shouldPrintFor9469() {
        assertThat(namer.stringify(9469), is("nine thousand four hundred sixty nine"));
    }

    @Test
    public void shouldPrintFor43112603() {
        assertThat(namer.stringify(43112603), is("fourty three million one hundred twelve thousand six hundred three"));

    }

}
