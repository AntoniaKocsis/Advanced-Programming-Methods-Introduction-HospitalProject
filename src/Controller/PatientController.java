package Controller;

import Domain.Patient;
import Repository.PatientRepository;

import java.util.ArrayList;
import java.util.Date;

public class PatientController extends BaseController<Patient> {
    private PatientRepository patientRepository;

    public PatientController(PatientRepository patientRepository) {
        super();
        this.patientRepository = patientRepository;
    }

    public void add(String firstName, String lastName, Date birthDate, String contact, String address) {
        Patient patient = new Patient(firstName, lastName, birthDate, contact, address);
        patientRepository.add(patient);
    }

    public boolean remove(int patientID) {

        for (Patient patient : patientRepository.getAll()) {
            if (patient.getPatientID() == patientID) {
                return patientRepository.remove(patient);
            }
        }
        return false;
    }



    public boolean updateFirstName(int ID, String name) {
        for (Patient patient2 : patientRepository.getAll()) {
            if (patient2.getPatientID() == ID) {
               patientRepository.updateFirstName(patient2,name);
                return true;
            }
        }
        return false;

    }


    public boolean updateLastName(int ID, String name) {
        for (Patient patient2 : patientRepository.getAll()) {
            if (patient2.getPatientID() == ID) {
                patientRepository.updateLastName(patient2,name);
                return true;
            }
        }
        return false;
    }

    public boolean updateBirthDate(int ID, Date date) {
        for (Patient patient2 : patientRepository.getAll()) {
            if (patient2.getPatientID() == ID) {
                patientRepository.updateBirthDate(patient2,date);
                return true;
            }
        }
        return false;
    }


    public boolean updateContact(int ID, String contact) {
        for (Patient patient2 : patientRepository.getAll()) {
            if (patient2.getPatientID() == ID) {
               patientRepository.updateContact(patient2,contact);
                return true;
            }
        }
        return false;
    }

    public boolean updateAddress(int ID, String address) {
        for (Patient patient2 : patientRepository.getAll()) {
            if (patient2.getPatientID() == ID) {
                patientRepository.updateAddress(patient2,address);
                return true;
            }
        }
        return false;

    }

    @Override
    public ArrayList<Patient> getAll() {
        return patientRepository.getAll();
    }


}
