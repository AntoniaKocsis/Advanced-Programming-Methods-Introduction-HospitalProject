package Repository;

import Domain.Patient;
import Interfaces.UpdatePersonInfoInterface;

import java.util.ArrayList;
import java.util.Date;

public class PatientRepository extends BaseRepository<Patient> implements UpdatePersonInfoInterface {
    private ArrayList<Patient> patientRepository;

    public PatientRepository() {
        super();
        this.patientRepository = new ArrayList<>();
    }

    @Override
    public void add(Patient patient) {
        patientRepository.add(patient);
    }

    @Override
    public boolean remove(int patientID) {
        for (Patient patient : patientRepository) {
            if (patient.getPatientID() == patientID) {
                return patientRepository.remove(patient);
            }
        }
        return false;
    }
    @Override
    public boolean updateFirstName(int ID, String name) {
        for (Patient patient2 : patientRepository) {
            if (patient2.getPatientID() == ID) {
                patient2.setFirstName(name);
                return true;
            }
        }
        return false;
    }
    @Override
    public boolean updateLastName(int ID, String name) {
        for (Patient patient2 : patientRepository) {
            if (patient2.getPatientID() == ID) {
                patient2.setLastName(name);
                return true;
            }
        }
        return false;
    }
    @Override
    public boolean updateBirthDate(int ID, Date date) {
        for (Patient patient2 : patientRepository) {
            if (patient2.getPatientID() == ID) {
                patient2.setBirthDate(date);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean updateContact(int ID, String contact) {
        for (Patient patient2 : patientRepository) {
            if (patient2.getPatientID() == ID) {
                patient2.setContact(contact);
                return true;
            }

        }
        return false;

    }
    @Override
    public boolean updateAddress(int ID, String address) {
        for (Patient patient2 : patientRepository) {
            if (patient2.getPatientID() == ID) {
                patient2.setAddress(address);
                return true;
            }
        }

        return false;
    }

    @Override
    public ArrayList<Patient> getAll() {
        return patientRepository;
    }
}