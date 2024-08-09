package pl.kurs.exercise01.models;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class Newborn implements Serializable {
    @Serial
    private static final long serialVersionUID = 2L;

    private String identifier;
    private String gender;
    private String firstName;
    private LocalDate birthDate;
    private int weightGrams;
    private int heightCm;
    private Mom mom;

    public Newborn(String identifier, String gender, String firstName, LocalDate birthDate, int weightGrams, int heightCm, Mom mom) {
        this.identifier = identifier;
        this.gender = gender;
        this.firstName = firstName;
        this.birthDate = birthDate;
        this.weightGrams = weightGrams;
        this.heightCm = heightCm;
        this.mom = mom;

        if (mom != null) {
            mom.addNewborn(this);
        } else {
            throw new IllegalArgumentException("Mom cannot be null");
        }
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public int getWeightGrams() {
        return weightGrams;
    }

    public void setWeightGrams(int weightGrams) {
        this.weightGrams = weightGrams;
    }

    public int getHeightCm() {
        return heightCm;
    }

    public void setHeightCm(int heightCm) {
        this.heightCm = heightCm;
    }

    public Mom getMom() {
        return mom;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Newborn newborn = (Newborn) o;
        return Double.compare(weightGrams, newborn.weightGrams) == 0 && heightCm == newborn.heightCm && Objects.equals(identifier, newborn.identifier) && Objects.equals(gender, newborn.gender) && Objects.equals(firstName, newborn.firstName) && Objects.equals(birthDate, newborn.birthDate) && Objects.equals(mom, newborn.mom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identifier, gender, firstName, birthDate, weightGrams, heightCm, mom);
    }

    @Override
    public String toString() {
        return "Newborn{" +
                "identifier='" + identifier + '\'' +
                ", gender='" + gender + '\'' +
                ", firstName='" + firstName + '\'' +
                ", birthDate=" + birthDate +
                ", weight=" + weightGrams +
                ", height=" + heightCm +
                ", mom=" + mom +
                '}';
    }


}
