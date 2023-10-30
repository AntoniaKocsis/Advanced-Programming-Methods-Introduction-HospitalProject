package Controller;

import Domain.Appointment;
import Domain.Doctor;
import Domain.ExaminationRoom;
import Domain.Patient;
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
        Patient patient = null;
        Doctor doctor = null;
        ExaminationRoom examinationRoom = null;
        for (Patient patient1 : patientRepository.getAll()) {
            if (patient1.getPatientID() == patientID) {
                patient = patient1;
                break;
            }
        }
        for (Doctor doctor1 : doctorRepository.getAll()) {
            if (doctor1.getDoctorID() == doctorID) {
                doctor = doctor1;
                break;
            }
        }
        for (ExaminationRoom examinationRoom1 : examinationRoomRepository.getAllExaminationRooms()) {
            if (examinationRoom1.getRoomID() == examinationRoomID) {
                examinationRoom = examinationRoom1;
                break;
            }
        }
        Appointment appointment = new Appointment(patient, doctor, date, examinationRoom);
        appointmentRepository.add(appointment);
    }

    public boolean reschedule(int appointmentID, Date date) {
        for (Appointment appointment : appointmentRepository.getAll()) {
            if (appointment.getAppointmentID() == appointmentID) {
                appointmentRepository.reschedule(appointment, date);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean remove(int appointmentID) {
        for (Appointment appointment : appointmentRepository.getAll()) {
            if (appointment.getAppointmentID() == appointmentID) {
                return appointmentRepository.remove(appointment);
            }
        }
        return false;
    }
    @Override
    public ArrayList<Appointment> getAll() {
        return appointmentRepository.getAll();
    }

    public ArrayList<AppointmentObserver> appointmentObservers(int appointmentID) {
        for (Appointment appointment1 : appointmentRepository.getAll()) {
            if (appointment1.getAppointmentID() == appointmentID) {
                return appointmentRepository.appointmentObservers(appointment1);
            }
        }
        return new ArrayList<>();
    }
}
