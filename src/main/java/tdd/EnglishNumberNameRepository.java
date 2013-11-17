package tdd;

import java.io.IOException;
import java.util.Properties;

public class EnglishNumberNameRepository implements NumberNameRepository {

    private Properties props = new Properties();

    public EnglishNumberNameRepository() {
        try {
            props.load(getClass().getResourceAsStream("/numbers_en.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String nameOf(int number) {
        return props.getProperty(new Integer(number).toString());
    }

    @Override
    public String scaleOf(int number) {
        int numberOfDigits = new Integer(number).toString().length();
        if (numberOfDigits == 3) {
            return props.getProperty("hundred");
        }
        if (numberOfDigits >= 4 && numberOfDigits <= 6) {
            return props.getProperty("thousand");
        }
        if (numberOfDigits >= 7 && numberOfDigits <= 9) {
            return props.getProperty("million");
        }
        return "";
    }
}
