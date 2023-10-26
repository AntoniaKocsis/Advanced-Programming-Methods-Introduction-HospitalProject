package Repository;

import Domain.Appointment;
import Domain.DoctorDashboard;
import Domain.PatientNotificationSystem;

import java.util.ArrayList;
import java.util.Date;

public class AppointmentRepository extends BaseRepository<Appointment> {
    private ArrayList<Appointment> appointmentRepository;

    public AppointmentRepository() {
        super();
        this.appointmentRepository = new ArrayList<>();
    }

    @Override
    public ArrayList<Appointment> getAll() {
        return appointmentRepository;
    }

    @Override
    public void add(Appointment appointment) {
        DoctorDashboard doctorDashboard = new DoctorDashboard(appointment.getDoctor());
        PatientNotificationSystem patientNotificationSystem = new PatientNotificationSystem(appointment.getPatient());
        appointment.registerObserver(doctorDashboard);
        appointment.registerObserver(patientNotificationSystem);
        appointment.notify();
        appointmentRepository.add(appointment);
    }

    @Override
    public boolean remove(int appointmentID) {
        for (Appointment appointment : appointmentRepository) {
            if (appointment.getAppointmentID() == appointmentID) {
                appointmentRepository.remove(appointment);
                return true;
            }
        }
        return false;
    }

    public boolean reschedule(int appointmentID, Date date) {
        for (Appointment appointment : appointmentRepository) {
            if (appointment.getAppointmentID() == appointmentID) {
                appointment.setDate(date);
                appointment.notify();
                return true;
            }
        }
        return false;
    }
}
