package pl.kurs.exercise02.models;

import java.time.LocalDate;

public class Appointment {
    private int doctorsId;
    private int patientsId;
    private LocalDate appointmentDate;

    public Appointment(int doctorsId, int patientsId, LocalDate appointmentDate) {
        this.doctorsId = doctorsId;
        this.patientsId = patientsId;
        this.appointmentDate = appointmentDate;
    }

    public int getDoctorsId() {
        return doctorsId;
    }

    public void setDoctorsId(int doctorsId) {
        this.doctorsId = doctorsId;
    }

    public int getPatientsId() {
        return patientsId;
    }

    public void setPatientsId(int patientsId) {
        this.patientsId = patientsId;
    }

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDate appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "doctorsId=" + doctorsId +
                ", patientsId=" + patientsId +
                ", appointmentDate=" + appointmentDate +
                '}';
    }
}
