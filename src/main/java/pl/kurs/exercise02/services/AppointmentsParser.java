package pl.kurs.exercise02.services;

import pl.kurs.exercise02.models.Appointment;
import pl.kurs.exercise02.models.Doctor;
import pl.kurs.exercise02.models.Patient;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class AppointmentsParser {

    public static List<Appointment> parseAppointment(List<String> appointmentsData) {
        List<Appointment> appointments = new ArrayList<>();

        for (String appointmentsDatum : appointmentsData) {
            String[] line = appointmentsDatum.split("\t");


            int doctorsId = Integer.parseInt(line[0]);
            int patientsId = Integer.parseInt(line[1]);
            LocalDate appointmentData = LocalDate.parse(line[2], DateTimeFormatter.ofPattern("yyyy-M-d"));
            appointments.add(new Appointment(doctorsId, patientsId, appointmentData));
        }
        return appointments;
    }

    public static List<Appointment> validateAppointments(List<Appointment> appointments, List<Doctor> doctors, List<Patient> patients) {
        return appointments.stream()
                .filter(appointment ->
                        doctors.stream().anyMatch(doctor -> doctor.getIdentificationNumber() == appointment.getDoctorsId()) &&
                                patients.stream().anyMatch(patient -> patient.getIdentificationNumber() == patient.getIdentificationNumber()))
                .toList();
    }
}


