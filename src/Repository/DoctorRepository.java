package Repository;

import Domain.Department;
import Domain.Doctor;

import java.util.ArrayList;
import java.util.Date;

public class DoctorRepository extends BaseRepository<Doctor> {
    private ArrayList<Doctor> doctorRepository;

    public DoctorRepository() {
        super();
        this.doctorRepository = new ArrayList<>();
    }

    public DoctorRepository(ArrayList<Doctor> doctors) {
        super();
        this.doctorRepository = doctors;

    }

    public void enrollDoctor(Doctor doctor, Department department) {
        if (!doctor.getDepartments().contains(department))
            doctor.enrollInDepartment(department);
        if (!department.getDoctors().contains(doctor))
            department.enrollDoctor(doctor);
    }

    public void removeFromDepartment(Doctor doctor, Department department) {
        doctor.removeDepartment(department);
        department.removeDoctor(doctor);
    }

    @Override
    public void add(Doctor doctor) {
        doctorRepository.add(doctor);
    }

    @Override
    public boolean remove(Doctor doctor) {
        return doctorRepository.remove(doctor);
    }

    @Override
    public ArrayList<Doctor> getAll() {
        return doctorRepository;
    }


    public void updateFirstName(Doctor doctor, String name) {
        doctor.setFirstName(name);
    }

    public void updateLastName(Doctor doctor, String name) {
        doctor.setLastName(name);
    }


    public void updateContact(Doctor doctor, String contact) {
        doctor.setContact(contact);
    }

    public void updateAddress(Doctor doctor, String address) {
        doctor.setAddress(address);
    }

    public void updateBirthDate(Doctor doctor, Date date) {
        doctor.setBirthDate(date);
    }
    public ArrayList<Department> getDepartments(Doctor doctor){
        return doctor.getDepartments();
    }
}
