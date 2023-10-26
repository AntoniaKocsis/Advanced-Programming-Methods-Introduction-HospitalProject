package Controller;

import Domain.Department;
import Repository.DepartmentRepository;

import java.util.ArrayList;

public class DepartmentController extends BaseController<Department>{
    private DepartmentRepository departmentRepository;

    public DepartmentController(DepartmentRepository departmentRepository) {
        super();
        this.departmentRepository = departmentRepository;
    }
    public void add(String name){
        Department department = new Department(name);
        departmentRepository.add(department);
    }
    public boolean updateName(int id,String name){
        return departmentRepository.updateName(id,name);
    }

    @Override
    public boolean remove(int id) {
        return departmentRepository.remove(id);
    }

    @Override
    public ArrayList<Department> getAll() {
        return departmentRepository.getAll();
    }
}
