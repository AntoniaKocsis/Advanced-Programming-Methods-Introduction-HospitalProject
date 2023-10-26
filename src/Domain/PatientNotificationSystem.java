package Domain;

import Domain.Appointment;
import Interfaces.AppointmentObserver;

public class PatientNotificationSystem implements AppointmentObserver {
    private Patient patient;

    public PatientNotificationSystem(Patient patient) {
        this.patient = patient;
    }

    @Override
    public void update(Appointment appointment) {
        System.out.println(patient.getFirstName() + patient.getLastName() + " - Latest appointment update: " + appointment);
    }
}
