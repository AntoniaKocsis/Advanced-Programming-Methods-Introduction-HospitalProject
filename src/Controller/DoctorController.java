package Controller;

import Domain.Department;
import Domain.Doctor;
import Repository.DepartmentRepository;
import Repository.DoctorRepository;

import java.util.ArrayList;
import java.util.Date;

public class DoctorController extends BaseController<Doctor> {
    private DoctorRepository doctorRepository;
    private DepartmentRepository departmentRepository;

    public DoctorController(DoctorRepository repository,DepartmentRepository departmentRepository) {
        super();
        doctorRepository = repository;
        this.departmentRepository = departmentRepository;
    }
    public void add(String firstName, String lastName, Date birthDate, String contact, String address) {
        Doctor doctor = new Doctor(firstName, lastName, birthDate, contact, address);
        doctorRepository.add(doctor);
    }

    public boolean updateFirstName(int ID, String name) {
        for (Doctor doctor : doctorRepository.getAll()) {
            if (doctor.getDoctorID() == ID) {
                doctorRepository.updateFirstName(doctor,name);
                return true;
            }
        }
        return false;
    }


    public boolean updateLastName(int ID, String name) {
        for (Doctor doctor : doctorRepository.getAll()) {
            if (doctor.getDoctorID() == ID) {
                doctorRepository.updateLastName(doctor,name);
                return true;
            }
        }
        return false;
    }


    public boolean updateContact(int ID, String contact) {
        for (Doctor doctor : doctorRepository.getAll()) {
            if (doctor.getDoctorID() == ID) {
                doctorRepository.updateContact(doctor,contact);
                return true;
            }
        }
        return false;
    }


    public boolean updateAddress(int ID, String address) {
        for (Doctor doctor : doctorRepository.getAll()) {
            if (doctor.getDoctorID() == ID) {
                doctorRepository.updateAddress(doctor,address);
                return true;
            }
        }
        return false;
    }


    public boolean updateBirthDate(int ID, Date date) {
        for (Doctor doctor : doctorRepository.getAll()) {
            if (doctor.getDoctorID() == ID) {
                doctorRepository.updateBirthDate(doctor,date);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean remove(int doctorID) {
        for (Doctor doctor : doctorRepository.getAll()) {
            if (doctor.getDoctorID() == doctorID) {
                return doctorRepository.remove(doctor);
            }
        }
        return false;
    }

    @Override
    public ArrayList<Doctor> getAll() {
        return doctorRepository.getAll();
    }
    public boolean enrollDoctor(int doctorID,int departmentID){
        Doctor doctor = null;
        Department department = null;
        for(Doctor doctor1: doctorRepository.getAll()){
            if(doctor1.getDoctorID() == doctorID){
                doctor = doctor1;
                break;
            }
        }
        if(doctor == null){
            return false;
        }
        for(Department department1: departmentRepository.getAll()){
            if(department1.getDepartmentID() == departmentID){
                department = department1;
                break;
            }
        }
        if(department == null)
            return false;
        doctorRepository.enrollDoctor(doctor,department);
        return true;
    }
    public boolean removeFromDepartment(int doctorID,int departmentID){
        Doctor doctor = null;
        Department department = null;
        for(Doctor doctor1: doctorRepository.getAll()){
            if(doctor1.getDoctorID() == doctorID){
                doctor = doctor1;
                break;
            }
        }
        if(doctor == null){
            return false;
        }
        for(Department department1: departmentRepository.getAll()){
            if(department1.getDepartmentID() == departmentID){
                department = department1;
                break;
            }
        }
        if(department == null)
            return false;
        doctorRepository.removeFromDepartment(doctor,department);
        return true;
    }
    public ArrayList<Department> getDepartments(int doctorID){
        Doctor doctor = null;
        for(Doctor doctor1: doctorRepository.getAll()){
            if(doctor1.getDoctorID() == doctorID){
                doctor = doctor1;
                break;
            }
        }
        if(doctor == null){
            return new ArrayList<>();
        }
        return doctorRepository.getDepartments(doctor);
    }
}
