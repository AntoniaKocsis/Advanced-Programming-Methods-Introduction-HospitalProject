package Controller;

import Domain.Doctor;
import Interfaces.UpdatePersonInfoInterface;
import Repository.DoctorRepository;

import java.util.ArrayList;
import java.util.Date;

public class DoctorController extends BaseController<Doctor> implements UpdatePersonInfoInterface {
    private DoctorRepository doctorRepository;

    public DoctorController(DoctorRepository repository) {
        super();
        doctorRepository = repository;
    }
    public void add(String firstName, String lastName, Date birthDate, String contact, String address) {
        Doctor doctor = new Doctor(firstName, lastName, birthDate, contact, address);
        doctorRepository.add(doctor);
    }
    @Override
    public boolean updateFirstName(int ID, String name) {
        return doctorRepository.updateFirstName(ID,name);
    }

    @Override
    public boolean updateLastName(int ID, String name) {
        return doctorRepository.updateLastName(ID,name);
    }

    @Override
    public boolean updateContact(int ID, String contact) {
        return doctorRepository.updateContact(ID,contact);
    }

    @Override
    public boolean updateAddress(int ID, String address) {
        return doctorRepository.updateAddress(ID,address);
    }

    @Override
    public boolean updateBirthDate(int ID, Date date) {
        return doctorRepository.updateBirthDate(ID,date);
    }

    @Override
    public boolean remove(int id) {
        return doctorRepository.remove(id);
    }

    @Override
    public ArrayList<Doctor> getAll() {
        return doctorRepository.getAll();
    }
}
