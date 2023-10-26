package Domain;

import java.util.ArrayList;
import java.util.Date;

public class Prescription {
    private static int nextID = 1;
    private int prescriptionID;
    private Doctor doctor;
    private Patient patient;
    private Date date;

    public Prescription(Doctor doctor, Patient patient, Date date) {
        this.doctor = doctor;
        this.patient = patient;
        this.date = date;
        this.prescriptionID = nextID++;
    }

    @Override
    public String toString() {
        return "Prescription{" +
                "prescriptionID=" + prescriptionID +
                ", doctor=" + doctor +
                ", patient=" + patient +
                ", date=" + date +
                '}';
    }

    public int getPrescriptionID() {
        return prescriptionID;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
