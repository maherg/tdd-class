package tdd;

import java.util.HashMap;
import java.util.Map;

public class EnglishNumberNameRepository implements NumberNameRepository {

    private Map<Integer, String> names = new HashMap<Integer, String>() {
        {
            put(0, "");
            put(1, "one");
            put(2, "two");
            put(3, "three");
            put(4, "four");
            put(5, "five");
            put(6, "six");
            put(7, "seven");
            put(8, "eight");
            put(9, "nine");
            put(10, "ten");
            put(11, "eleven");
            put(12, "twelve");
            put(13, "thirteen");
            put(14, "fourteen");
            put(15, "fifteen");
            put(16, "sixteen");
            put(17, "seventeen");
            put(18, "eighteen");
            put(19, "nineteen");
            put(20, "twenty");
            put(30, "thirty");
            put(40, "fourty");
            put(50, "fifty");
            put(60, "sixty");
            put(70, "seventy");
            put(80, "eighty");
            put(90, "ninety");
        }
    };

    @Override
    public String nameOf(int number) {
        return names.get(number);
    }

    @Override
    public String scaleOf(int number) {
        int numberOfDigits = new Integer(number).toString().length();
        if (numberOfDigits == 3) {
            return "hundred";
        }
        if (numberOfDigits >= 4 && numberOfDigits <= 6) {
            return "thousand";
        }
        if (numberOfDigits >= 7 && numberOfDigits <= 9) {
            return "million";
        }
        return "";
    }
}
