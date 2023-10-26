package Controller;

import Domain.Doctor;
import Domain.Patient;
import Domain.Prescription;
import Repository.DoctorRepository;
import Repository.PatientRepository;
import Repository.PrescriptionRepository;

import java.util.ArrayList;
import java.util.Date;

public class PrescriptionController extends BaseController<Prescription>{
    private PrescriptionRepository prescriptionRepository;
    private PatientRepository patientRepository;
    private DoctorRepository doctorRepository;

    public PrescriptionController(PrescriptionRepository prescriptionRepository,PatientRepository patientRepository,DoctorRepository doctorRepository) {
        this.prescriptionRepository = prescriptionRepository;
        this.patientRepository = patientRepository;
        this.doctorRepository = doctorRepository;
    }

    public boolean add(int doctorID, int patientID, Date date){
        Patient patient2 = null;
        Doctor doctor2 = null;
        boolean foundP = false;
        boolean foundD = false;
        for(Patient patient: patientRepository.getAll()){
            if(patient.getPatientID() == patientID){
                patient2 = patient;
                foundP = true;
                break;
            }
        }
        for(Doctor doctor: doctorRepository.getAll()){
            if(doctor.getDoctorID() == doctorID){
                doctor2 = doctor;
                foundD = true;
                break;
            }
        }
        if(!foundP || !foundD)
            return false;
        Prescription prescription = new Prescription(doctor2,patient2,date);
        prescriptionRepository.add(prescription);
        return true;
    }


    @Override
    public boolean remove(int id) {
        return prescriptionRepository.remove(id);
    }

    @Override
    public ArrayList<Prescription> getAll() {
        return prescriptionRepository.getAll();
    }
}
