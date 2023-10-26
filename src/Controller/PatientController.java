package Controller;

import Domain.Patient;
import Interfaces.UpdatePersonInfoInterface;
import Repository.PatientRepository;

import java.util.ArrayList;
import java.util.Date;

public class PatientController extends BaseController<Patient> implements UpdatePersonInfoInterface {
    private PatientRepository patientRepository;

    public PatientController(PatientRepository patientRepository) {
        super();
        this.patientRepository = patientRepository;
    }

    public void add(String firstName, String lastName, Date birthDate, String contact, String address) {
        Patient patient = new Patient(firstName, lastName, birthDate, contact, address);
        patientRepository.add(patient);
    }

    @Override
    public boolean remove(int ID) {
        return patientRepository.remove(ID);
    }

    @Override
    public boolean updateFirstName(int ID, String name) {
        return patientRepository.updateFirstName(ID, name);

    }

    @Override
    public boolean updateLastName(int ID, String name) {
        return patientRepository.updateLastName(ID, name);
    }

    @Override
    public boolean updateBirthDate(int ID, Date date) {
        return patientRepository.updateBirthDate(ID, date);
    }

    @Override
    public boolean updateContact(int ID, String contact) {
        return patientRepository.updateContact(ID, contact);
    }

    @Override
    public boolean updateAddress(int ID, String address) {
        return patientRepository.updateAddress(ID, address);

    }

    @Override
    public ArrayList<Patient> getAll() {
        return patientRepository.getAll();
    }


}
