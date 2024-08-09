package pl.kurs.exercise01.models;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Mom implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private String identifier;
    private String firstName;
    private int age;
    private List<Newborn> kids;

    public Mom(String identifier, String firstName, int age) {
        this.identifier = identifier;
        this.firstName = firstName;
        this.age = age;
        this.kids = new ArrayList<>();
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Newborn> getKids() {
        return kids;
    }

    public void addNewborn(Newborn newborn) {
        kids.add(newborn);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mom mom = (Mom) o;
        return age == mom.age && Objects.equals(identifier, mom.identifier) && Objects.equals(firstName, mom.firstName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identifier, firstName, age, kids);
    }

    @Override
    public String toString() {
        return "Mom{" +
                "identifier='" + identifier + '\'' +
                ", firstName='" + firstName + '\'' +
                ", age=" + age;
    }
}
