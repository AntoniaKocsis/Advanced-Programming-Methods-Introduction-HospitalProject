package Repository;

import Domain.Department;
import Domain.Doctor;

import java.util.ArrayList;

public class DepartmentRepository extends BaseRepository<Department> {
    private ArrayList<Department> departmentRepository;

    public DepartmentRepository() {
        super();
        this.departmentRepository = new ArrayList<>();
    }

    public DepartmentRepository(ArrayList<Department> departments) {
        super();
        departmentRepository = departments;

    }

    @Override
    public void add(Department item) {
        departmentRepository.add(item);
    }

    public void enrollDoctor(Department department, Doctor doctor) {
        if (!department.getDoctors().contains(doctor))
            department.enrollDoctor(doctor);
        if (!doctor.getDepartments().contains(department))
            doctor.enrollInDepartment(department);
    }

    public void removeDoctor(Department department, Doctor doctor) {
        department.removeDoctor(doctor);
        doctor.removeDepartment(department);
    }

    @Override
    public boolean remove(Department department) {
        return departmentRepository.remove(department);
    }

    @Override
    public ArrayList<Department> getAll() {
        return departmentRepository;
    }

    public void updateName(Department department, String name) {
        department.setName(name);
    }

    public ArrayList<Doctor> getEnrolledDoctors(Department department) {
        return department.getDoctors();
    }
}
