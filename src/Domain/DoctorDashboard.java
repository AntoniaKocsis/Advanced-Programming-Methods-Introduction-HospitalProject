package Domain;

import Interfaces.AppointmentObserver;

public class DoctorDashboard implements AppointmentObserver {
    private Doctor doctor;

    public DoctorDashboard(Doctor doctor) {
        this.doctor = doctor;
    }

    @Override
    public void update(Appointment appointment) {
        System.out.println(doctor.getFirstName() + " " + doctor.getLastName() + " - Latest update: " + appointment);
    }
}
