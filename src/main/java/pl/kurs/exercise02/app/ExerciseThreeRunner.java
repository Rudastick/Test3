package pl.kurs.exercise02.app;

import pl.kurs.exercise02.models.Appointment;
import pl.kurs.exercise02.models.Doctor;
import pl.kurs.exercise02.models.Patient;
import pl.kurs.exercise02.services.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExerciseThreeRunner {
    public static void main(String[] args) {
        List<Doctor> doctors = new ArrayList<>();
        List<Patient> patients = new ArrayList<>();
        List<Appointment> appointments = new ArrayList<>();

        try {
            List<Doctor> readDoctors = DoctorParser.parseDoctors(FileHandler.fileReader("C:\\Users\\Macie\\Downloads\\lekarze.txt")); // Put filePath here
            List<Patient> readPatients = PatientParser.parsePatients(FileHandler.fileReader("C:\\Users\\Macie\\Downloads\\pacjenci.txt"));  // Put filePath here
            List<Appointment> readAppointments = AppointmentsParser.parseAppointment(FileHandler.fileReader("C:\\Users\\Macie\\Downloads\\wizyty.txt")); // Put filePath here

            doctors.addAll(readDoctors);
            patients.addAll(readPatients);

            List<Appointment> validatedAppointments = AppointmentsParser.validateAppointments(readAppointments, doctors, patients);

            appointments.addAll(validatedAppointments);


            System.out.println("Zadania: ");

            System.out.println("1. Znajdź lekarza ktory miał najwięcej wizyt: ");
            Doctor doctorWithMostAppointments = HealthcareDataProcessor.getDoctorWithMostAppointments(appointments, doctors);
            System.out.println(doctorWithMostAppointments);
            System.out.println("------------------------------------------");

            System.out.println("2. Znajdź pacjenta który miał najwięcej wizyt");
            Patient patientWithMostAppointments = HealthcareDataProcessor.getPatientWithMostAppointments(appointments, patients);
            System.out.println(patientWithMostAppointments);
            System.out.println("------------------------------------------");

            System.out.println("3. Która specalizacja cieszy się największym powodzeniem?");
            String mostPopularSpecialization = HealthcareDataProcessor.getMostPopularSpecialization(doctors);
            System.out.println(mostPopularSpecialization);
            System.out.println("------------------------------------------");

            System.out.println("4. Którego roku było najwięcej wizyt?");
            int yearWithMostAppointments = HealthcareDataProcessor.findYearWithMostAppointments(appointments);
            System.out.println(yearWithMostAppointments);
            System.out.println("------------------------------------------");

            System.out.println("5. Wypisz top 5 najstarszych lekarzy");
            List<Doctor> fiveOldestDoctors = HealthcareDataProcessor.getFiveOldestDoctors(doctors);
            System.out.println(fiveOldestDoctors);
            System.out.println("------------------------------------------");

            System.out.println("6. Wypisz top 5 lekarzy co mieli najwiecej wizyt");
            List<Doctor> topFiveDoctorsWithMostAppointments = HealthcareDataProcessor.getTopFiveDoctorsWithMostAppointments(appointments, doctors);
            System.out.println(topFiveDoctorsWithMostAppointments);
            System.out.println("------------------------------------------");

            System.out.println("7. Zwroc pacientow ktorzy byli u minumum 5ciu roznych lekarzy");
            List<Patient> patientsWhoHaveBeenToAtLeastFiveDoctors = HealthcareDataProcessor.getPatientsWhoHaveBeenToAtLeastFiveDoctors(appointments, patients);
            System.out.println(patientsWhoHaveBeenToAtLeastFiveDoctors);
            System.out.println("------------------------------------------");


            System.out.println("8. Zwroc lekarzy ktorzy przyjeli tylko jednego pacjenta");
            List<Doctor> doctorsWithSinglePatient = HealthcareDataProcessor.getDoctorsWithSinglePatient(appointments, doctors);
            System.out.println(doctorsWithSinglePatient);
            System.out.println("------------------------------------------");


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
