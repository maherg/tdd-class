package tdd;

public class EnglishNumberNameRepository implements NumberNameRepository {

    private String[] onesNames = { "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };

    private String[] teensNames = { "", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen",
            "eighteen", "nineteen" };

    private String[] tensNames = { "", "ten", "twenty", "thirty", "fourty", "fifty", "sixty", "seventy", "eighty",
            "ninety" };

    @Override
    public String nameOf(int number) {
        if (number < 10) {
            return onesNames[number];
        } else {
            if (number > 10 && number < 20) {
                return teensNames[number % 10];
            } else {
                return new String(tensNames[number / 10] + " " + onesNames[number % 10]).trim();
            }
        }
    }

}
