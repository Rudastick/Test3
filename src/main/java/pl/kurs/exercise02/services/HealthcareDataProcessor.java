package pl.kurs.exercise02.services;

import pl.kurs.exercise02.models.Appointment;
import pl.kurs.exercise02.models.Doctor;
import pl.kurs.exercise02.models.Patient;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class HealthcareDataProcessor {
    public static Doctor getDoctorWithMostAppointments(List<Appointment> appointmentList, List<Doctor> doctors) {
        return doctors.stream()
                .max(Comparator.comparingInt(doctor -> (int) appointmentList.stream()
                        .filter(appointment -> appointment.getDoctorsId() == doctor.getIdentificationNumber())
                        .count()))
                .orElse(null);
    }

    public static Patient getPatientWithMostAppointments(List<Appointment> appointmentList, List<Patient> patients) {
        return patients.stream()
                .max(Comparator.comparingInt(patient -> (int) appointmentList.stream()
                        .filter(appointment -> appointment.getPatientsId() == patient.getIdentificationNumber())
                        .count())
                ).orElse(null);
    }

    public static String getMostPopularSpecialization(List<Doctor> doctors) {
        Map<String, Long> specialisationAndCount = doctors.stream()
                .map(Doctor::getMedicalPractice)
                .collect(Collectors.groupingBy(spec -> spec, Collectors.counting()));

        return specialisationAndCount.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("");
    }

    public static int findYearWithMostAppointments(List<Appointment> appointmentList) {
        Map<Integer, Long> yearsAndCounting = appointmentList.stream()
                .collect(Collectors.groupingBy(appointment -> appointment.getAppointmentDate().getYear(), Collectors.counting()));

        return yearsAndCounting.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(0);
    }

    public static List<Doctor> getFiveOldestDoctors(List<Doctor> doctors) {
        return doctors.stream()
                .sorted(Comparator.comparing(Doctor::getDateOfBirth))
                .limit(5)
                .toList();
    }

    public static List<Doctor> getTopFiveDoctorsWithMostAppointments(List<Appointment> appointmentList, List<Doctor> doctors) {
        Map<Integer, Long> doctorAppointmentCount = appointmentList.stream()
                .collect(Collectors.groupingBy(Appointment::getDoctorsId, Collectors.counting()));


        return doctors.stream()
                .sorted((d1, d2) -> Long.compare(
                        doctorAppointmentCount.getOrDefault(d2.getIdentificationNumber(), 0L),
                        doctorAppointmentCount.getOrDefault(d1.getIdentificationNumber(), 0L)
                )).limit(5)
                .toList();
    }

    public static List<Patient> getPatientsWhoHaveBeenToAtLeastFiveDoctors(List<Appointment> appointmentList, List<Patient> patients) {
        Map<Integer, Patient> patientMap = patients.stream()
                .collect(Collectors.toMap(Patient::getIdentificationNumber, patient -> patient));

        return appointmentList.stream()
                .collect(Collectors.groupingBy(Appointment::getPatientsId, Collectors.mapping(Appointment::getDoctorsId, Collectors.toSet())))
                .entrySet().stream()
                .filter(e -> e.getValue().size() >= 5)
                .map(Map.Entry::getKey)
                .map(patientMap::get)
                .collect(Collectors.toList());
    }

    public static List<Doctor> getDoctorsWithSinglePatient(List<Appointment> appointmentList, List<Doctor> doctors) {
        Map<Integer, Doctor> doctorMap = doctors.stream()
                .collect(Collectors.toMap(Doctor::getIdentificationNumber, d -> d));

        Map<Integer, Long> doctorVisitCount = appointmentList.stream()
                .collect(Collectors.groupingBy(Appointment::getDoctorsId, Collectors.counting()));

        return doctorVisitCount.entrySet()
                .stream()
                .filter(e -> e.getValue() == 1)
                .map(e -> doctorMap.get(e.getKey()))
                .collect(Collectors.toList());
    }
}
