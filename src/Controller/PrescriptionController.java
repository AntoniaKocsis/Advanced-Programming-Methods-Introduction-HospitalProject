package Controller;

import Domain.Doctor;
import Domain.Medication;
import Domain.Patient;
import Domain.Prescription;
import Repository.DoctorRepository;
import Repository.MedicationRepository;
import Repository.PatientRepository;
import Repository.PrescriptionRepository;

import java.util.ArrayList;
import java.util.Date;

public class PrescriptionController extends BaseController<Prescription>{
    private PrescriptionRepository prescriptionRepository;
    private PatientRepository patientRepository;
    private DoctorRepository doctorRepository;
    private MedicationRepository medicationRepository;

    public PrescriptionController(PrescriptionRepository prescriptionRepository,PatientRepository patientRepository,DoctorRepository doctorRepository,MedicationRepository medicationRepository) {
        this.prescriptionRepository = prescriptionRepository;
        this.patientRepository = patientRepository;
        this.doctorRepository = doctorRepository;
        this.medicationRepository = medicationRepository;
    }
    public boolean addMedication(int prescriptionID,int medicationID){
        Prescription prescription = null;
        Medication medication = null;
        for(Prescription prescription1:prescriptionRepository.getAll()){
            if(prescription1.getPrescriptionID() == prescriptionID){
                prescription = prescription1;
                break;
            }
        }
        for(Medication medication1 : medicationRepository.getAll()){
            if(medication1.getMedicationID() == medicationID){
                medication = medication1;
                break;
            }
        }
        if(prescription == null || medication == null)
            return false;
        prescriptionRepository.addMedication(prescription,medication);
        return true;
    }
    public boolean removeMedication(int prescriptionID,int medicationID){
        Prescription prescription = null;
        Medication medication = null;
        for(Prescription prescription1:prescriptionRepository.getAll()){
            if(prescription1.getPrescriptionID() == prescriptionID){
                prescription = prescription1;
                break;
            }
        }
        for(Medication medication1 : medicationRepository.getAll()){
            if(medication1.getMedicationID() == medicationID){
                medication = medication1;
                break;
            }
        }
        if(prescription == null || medication == null)
            return false;
        prescriptionRepository.removeMedication(prescription,medication);
        return true;
    }
    public boolean setMedicationList(int prescriptionID,ArrayList<Integer> medicationIDList ){
        Prescription prescription = null;
        ArrayList<Medication> medications = new ArrayList<>();
        for(Prescription prescription1:prescriptionRepository.getAll()){
            if(prescription1.getPrescriptionID() == prescriptionID){
                prescription = prescription1;
                break;
            }
        }
        if(prescription == null)
            return false;
        ArrayList<Integer> ids = new ArrayList<>();
        for(Medication medication:medicationRepository.getAll()){
            if(medicationIDList.contains(medication.getMedicationID())){
                medications.add(medication);
            }
            ids.add(medication.getMedicationID());
        }
        for(Integer id: medicationIDList){
            if(!ids.contains(id)){
                return false;
            }
        }
        prescriptionRepository.setMedicationList(prescription,medications);
        return true;


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
        for (Prescription prescription : prescriptionRepository.getAll()) {
            if (prescription.getPrescriptionID() == id) {
                return prescriptionRepository.remove(prescription);
            }
        }
        return false;
    }

    @Override
    public ArrayList<Prescription> getAll() {
        return prescriptionRepository.getAll();
    }
}
