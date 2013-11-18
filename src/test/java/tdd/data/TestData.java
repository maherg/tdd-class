package tdd.data;

import java.util.Scanner;

public class TestData {

    public static String fileContents(String filename) {
        return new Scanner(TestData.class.getResourceAsStream(filename)).useDelimiter("\\A").next();
    }

}
