package Repository;

import Domain.Patient;

import java.util.ArrayList;
import java.util.Date;

public class PatientRepository extends BaseRepository<Patient> {
    private ArrayList<Patient> patientRepository;

    public PatientRepository() {
        super();
        this.patientRepository = new ArrayList<>();
    }
    public PatientRepository(ArrayList<Patient> patients){
        super();
        patientRepository = patients;
    }
    @Override
    public void add(Patient patient) {
        patientRepository.add(patient);
    }

    @Override
    public boolean remove(Patient patient) {
        return patientRepository.remove(patient);
    }


    public void updateFirstName(Patient patient, String name) {
        patient.setFirstName(name);

    }

    public void updateLastName(Patient patient, String name) {
        patient.setFirstName(name);
    }

    public void updateBirthDate(Patient patient, Date date) {
        patient.setBirthDate(date);
    }


    public void updateContact(Patient patient, String contact) {
        patient.setContact(contact);
    }

    public void updateAddress(Patient patient, String address) {
       patient.setAddress(address);
    }

    @Override
    public ArrayList<Patient> getAll() {
        return patientRepository;
    }
}