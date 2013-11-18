package tdd;

import tdd.data.NumberName;

public interface NumberNameRepository {

    String nameOf(int number);

    String scaleOf(int number);

    void save(NumberName numberName);

}
