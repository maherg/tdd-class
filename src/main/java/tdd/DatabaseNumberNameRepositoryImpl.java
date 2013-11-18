package tdd;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;

import tdd.data.NumberName;

public class DatabaseNumberNameRepositoryImpl implements NumberNameRepository {

    @Autowired
    EntityManager entityManager;

    @Override
    public String nameOf(int number) {
        NumberName numberName = entityManager.find(NumberName.class, number);
        if (numberName == null) {
            return "";
        } else {
            return numberName.getName();
        }
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

    @Override
    public void save(NumberName numberName) {
        try {
            entityManager.persist(numberName);
        } catch (EntityExistsException e) {
            entityManager.merge(numberName);
        }
    }

}
