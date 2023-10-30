package Repository;

import Domain.Appointment;
import Domain.DoctorDashboard;
import Domain.PatientNotificationSystem;
import Interfaces.AppointmentObserver;

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
        appointmentRepository.add(appointment);
        appointment.notifyObservers();
    }
    public boolean remove(Appointment appointment) {
        return appointmentRepository.remove(appointment);
    }

    public void reschedule(Appointment appointment, Date date) {
        appointment.setDate(date);
        appointment.notifyObservers();
    }
    public ArrayList<AppointmentObserver> appointmentObservers(Appointment appointment){
        return appointment.getObservers();
    }
}
