package pl.kurs.exercise02.models;

import java.time.LocalDate;
import java.util.Objects;

public class Doctor {
    private int id;
    private String firstName;
    private String lastName;
    private String medicalPractice;
    private LocalDate dateOfBirth;
    private String nip;
    private String pesel;

    public Doctor(int id, String firstName, String lastName, String medicalPractice, LocalDate dateOfBirth, String nip, String pesel) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.medicalPractice = medicalPractice;
        this.dateOfBirth = dateOfBirth;
        this.nip = nip;
        this.pesel = pesel;
    }

    public int getIdentificationNumber() {
        return id;
    }

    public void setIdentificationNumber(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMedicalPractice() {
        return medicalPractice;
    }

    public void setMedicalPractice(String medicalPractice) {
        this.medicalPractice = medicalPractice;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Doctor doctor = (Doctor) o;
        return Objects.equals(id, doctor.id) && Objects.equals(firstName, doctor.firstName) && Objects.equals(lastName, doctor.lastName) && Objects.equals(medicalPractice, doctor.medicalPractice) && Objects.equals(dateOfBirth, doctor.dateOfBirth) && Objects.equals(nip, doctor.nip) && Objects.equals(pesel, doctor.pesel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, medicalPractice, dateOfBirth, nip, pesel);
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "identificationNumber='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", medicalPractice='" + medicalPractice + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", nip='" + nip + '\'' +
                ", pesel='" + pesel + '\'' +
                '}';
    }
}
