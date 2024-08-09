package pl.kurs.exercise03.models;

import java.io.Serial;
import java.math.BigDecimal;

public class Student extends Person {
    @Serial
    private static final long serialVersionUID = 2L;

    private String group;
    private BigDecimal scholarship;

    public Student(String firstName, String lastName, String pesel, String city, String group, BigDecimal scholarship) {
        super(firstName, lastName, pesel, city);
        this.group = group;
        this.scholarship = scholarship;
    }
    @Override
    public BigDecimal getIncome() {
        return scholarship;
    }


    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public BigDecimal getScholarship() {
        return scholarship;
    }

    public void setScholarship(BigDecimal scholarship) {
        this.scholarship = scholarship;
    }

}
