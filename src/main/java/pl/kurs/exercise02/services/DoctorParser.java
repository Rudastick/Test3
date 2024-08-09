package pl.kurs.exercise02.services;

import pl.kurs.exercise02.models.Doctor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DoctorParser {
    public static List<Doctor> parseDoctors(List<String> doctorsData) {
        List<Doctor> doctors = new ArrayList<>();
        Set<String> uniqueNips = new HashSet<>();

        for (String doctorsDatum : doctorsData) {
            String[] line = doctorsDatum.split("\\t");
            int id = Integer.parseInt(line[0]);
            String lastName = line[1];
            String firstName = line[2];
            String medicalPractice = line[3];
            LocalDate dateOfBirth = LocalDate.parse(line[4], DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            String nip = line[5];
            String pesel = line[6];

            if (!uniqueNips.contains(nip)) {
                uniqueNips.add(nip);
                doctors.add(new Doctor(id, firstName, lastName, medicalPractice, dateOfBirth, nip, pesel));
            }
        }
        return doctors;

    }
}
