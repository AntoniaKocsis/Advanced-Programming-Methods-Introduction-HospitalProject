package Controller;

import Domain.*;
import Interfaces.AppointmentObserver;
import Repository.AppointmentRepository;
import Repository.DoctorRepository;
import Repository.HospitalRoomRepository;
import Repository.PatientRepository;

import java.util.ArrayList;
import java.util.Date;

public class AppointmentController extends BaseController<Appointment> {
    private AppointmentRepository appointmentRepository;
    private PatientRepository patientRepository;
    private DoctorRepository doctorRepository;
    private HospitalRoomRepository examinationRoomRepository;

    public AppointmentController(AppointmentRepository appointmentRepository, PatientRepository patientRepository, DoctorRepository doctorRepository, HospitalRoomRepository examinationRoomRepository) {
        super();
        this.doctorRepository = doctorRepository;
        this.patientRepository = patientRepository;
        this.examinationRoomRepository = examinationRoomRepository;
        this.appointmentRepository = appointmentRepository;
    }

    public void add(int patientID, int doctorID, Date date, int examinationRoomID) {
        Patient patient = patientRepository.findByID(patientID);
        Doctor doctor = doctorRepository.findByID(doctorID);
        HospitalRoom examinationRoom = examinationRoomRepository.findByID(examinationRoomID);
        Appointment appointment = new Appointment(patient, doctor, date, (ExaminationRoom)examinationRoom);
        appointmentRepository.add(appointment);
    }

    public boolean reschedule(int appointmentID, Date date) {
        return appointmentRepository.reschedule(appointmentID,date);
    }

    @Override
    public boolean remove(int appointmentID) {
        return appointmentRepository.remove(appointmentID);
    }
    @Override
    public ArrayList<Appointment> getAll() {
        return appointmentRepository.getAll();
    }

    public ArrayList<AppointmentObserver> appointmentObservers(int appointmentID) {
        return appointmentRepository.appointmentObservers(appointmentID);
    }
}
