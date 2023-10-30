package Controller;

import Domain.Department;
import Domain.Doctor;
import Repository.DepartmentRepository;
import Repository.DoctorRepository;

import java.util.ArrayList;

public class DepartmentController extends BaseController<Department> {
    private DepartmentRepository departmentRepository;
    private DoctorRepository doctorRepository;

    public DepartmentController(DepartmentRepository departmentRepository, DoctorRepository doctorRepository) {
        super();
        this.departmentRepository = departmentRepository;
        this.doctorRepository = doctorRepository;
    }

    public void add(String name) {
        Department department = new Department(name);
        departmentRepository.add(department);
    }

    public boolean enrollDoctor(int departmentID, int doctorID) {
        Department department = null;
        Doctor doctor = null;
        for (Department department1 : departmentRepository.getAll()) {
            if (department1.getDepartmentID() == departmentID)
                department = department1;
        }
        for (Doctor doctor1 : doctorRepository.getAll()) {
            if (doctor1.getDoctorID() == doctorID) {
                doctor = doctor1;
            }
        }
        if (doctor == null || department == null)
            return false;
        departmentRepository.enrollDoctor(department,doctor);
        return true;
    }

    public boolean removeDoctor(int departmentID, int doctorID) {
        Department department = null;
        Doctor doctor = null;
        for (Department department1 : departmentRepository.getAll()) {
            if (department1.getDepartmentID() == departmentID) {
                department = department1;
                break;
            }
        }
        for (Doctor doctor1 : doctorRepository.getAll()) {
            if (doctor1.getDoctorID() == doctorID) {
                doctor = doctor1;
                break;
            }
        }
        if (doctor == null || department == null) {
            return false;
        }
       departmentRepository.removeDoctor(department, doctor);
        return true;
    }

    public boolean updateName(int id, String name) {
        for(Department department : departmentRepository.getAll()){
            if(department.getDepartmentID() == id) {
                departmentRepository.updateName(department,name);
                return true;
            }
        }
        return false;

    }

    @Override
    public boolean remove(int id) {

        for (Department department : departmentRepository.getAll()) {
            if (department.getDepartmentID() == id) {
                return departmentRepository.remove(department);
            }
        }
        return false;
    }

    @Override
    public ArrayList<Department> getAll() {
        return departmentRepository.getAll();
    }

    public ArrayList<Doctor> getEnrolledDoctors(int departmentID) {
        Department department1 = null;
        for (Department department : getAll()) {
            if (department.getDepartmentID() == departmentID) {
                department1 = department;
                break;
            }
        }
        if (department1 == null)
            return new ArrayList<>();
        return departmentRepository.getEnrolledDoctors(department1);

    }
}
