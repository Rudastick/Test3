package pl.kurs.exercise02.services;

import pl.kurs.exercise02.models.Patient;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class PatientParser {
    public static List<Patient> parsePatients(List<String> patientsData) {
        List<Patient> patients = new ArrayList<>();

        for (String patientsDatum : patientsData) {
            String[] line = patientsDatum.split("\\t");
            int id = Integer.parseInt(line[0]);
            String lastName = line[1];
            String firstName = line[2];
            String pesel = line[3];
            LocalDate dateOfBirth = LocalDate.parse(line[4], DateTimeFormatter.ofPattern("yyyy-M-d"));

            patients.add(new Patient(id, lastName, firstName, dateOfBirth, pesel));
        }
        return patients;
    }
}
