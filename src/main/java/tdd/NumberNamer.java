package tdd;

import org.springframework.beans.factory.annotation.Autowired;

public class NumberNamer {

    @Autowired
    private NumberNameRepository repository;

    private int MILLION = 1000000;
    private int THOUSAND = 1000;
    private int HUNDRED = 100;
    private int TEN = 10;
    private int TWENTY = 20;

    public String stringify(int number) {
        if (number >= MILLION) {
            return joinWithSpace(stringify(number / MILLION), repository.scaleOf(number), stringify(number % MILLION));
        }
        if (number >= THOUSAND) {
            return joinWithSpace(stringify(number / THOUSAND), repository.scaleOf(number), stringify(number % THOUSAND));
        }
        if (number >= HUNDRED) {
            return joinWithSpace(stringify(number / HUNDRED), repository.scaleOf(number), stringify(number % HUNDRED));
        }
        if (number < TEN) {
            return repository.nameOf(number);
        } else {
            if (number > TEN && number <= TWENTY) {
                return repository.nameOf(number);
            } else {
                return joinWithSpace(repository.nameOf((number / TEN) * TEN), repository.nameOf(number % TEN));
            }
        }
    }

    private String joinWithSpace(String... elements) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < elements.length; i++) {
            sb.append(elements[i]);
            int next = i + 1;
            if (next < elements.length && !elements[next].equals("")) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
