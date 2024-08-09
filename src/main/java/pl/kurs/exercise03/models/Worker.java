package pl.kurs.exercise03.models;

import java.io.Serial;
import java.math.BigDecimal;

public class Worker extends Person {
    @Serial
    private static final long serialVersionUID = 3L;

    private String position;
    private BigDecimal salary;

    public Worker(String firstName, String lastName, String pesel, String city, String position, BigDecimal salary) {
        super(firstName, lastName, pesel, city);
        this.position = position;
        this.salary = salary;
    }

    @Override
    public BigDecimal getIncome() {
        return salary;
    }



    @Override
    public String toString() {
        return super.toString() + "Worker{" +
                "position='" + position + '\'' +
                ", salary=" + salary +
                '}';
    }
}
