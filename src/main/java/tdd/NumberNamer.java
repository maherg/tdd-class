package tdd;

public class NumberNamer {

    private final NumberNameRepository repository;

    private String[] onesNames = { "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
    private String[] teensNames = { "", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen",
            "eighteen", "nineteen" };
    private String[] tensNames = { "", "ten", "twenty", "thirty", "fourty", "fifty", "sixty", "seventy", "eighty",
            "ninety" };
    private int MILLION = 1000000;
    private int THOUSAND = 1000;
    private int HUNDRED = 100;
    private int TEN = 10;
    private int TWENTY = 20;

    public NumberNamer(NumberNameRepository repository) {
        this.repository = repository;
    }

    public String stringify(int number) {
        if (number >= MILLION) {
            return joinWithSpace(stringify(number / MILLION), "million", stringify(number % MILLION));
        }
        if (number >= THOUSAND) {
            return joinWithSpace(stringify(number / THOUSAND), "thousand", stringify(number % THOUSAND));
        }
        if (number >= HUNDRED) {
            return joinWithSpace(stringify(number / HUNDRED), "hundred", stringify(number % HUNDRED));
        }
        return repository.nameOf(number);

    }

    private String joinWithSpace(String... elements) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < elements.length; i++) {
            sb.append(elements[i]);
            int next = i + 1;
            if (next < elements.length && elements[next] != "") {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
