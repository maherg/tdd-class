package tdd.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "number_names")
public class NumberName {

    @Id
    @GeneratedValue
    private int id;

    @Column
    private int value;

    @Column
    private String name;

    public NumberName() {

    }

    public NumberName(int value, String name) {
        this.value = value;
        this.name = name;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(value = " + value + ", name = " + name + ")";
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    public int getId() {
        return id;
    }
}
