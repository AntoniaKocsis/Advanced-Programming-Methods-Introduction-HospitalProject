package Repository;

import Domain.Department;

import java.util.ArrayList;

public class DepartmentRepository extends BaseRepository<Department>{
    private ArrayList<Department> departmentRepository;

    public DepartmentRepository() {
        super();
        this.departmentRepository = new ArrayList<>();
    }

    @Override
    public void add(Department item) {
     departmentRepository.add(item);
    }

    @Override
    public boolean remove(int id) {
        for(Department department:departmentRepository){
            if(department.getDepartmentID() == id)
            {
                departmentRepository.remove(department);
                return true;
            }
        }
        return false;
    }

    @Override
    public ArrayList<Department> getAll() {
        return departmentRepository;
    }

    public boolean updateName(int id,String name){
        for(Department department : departmentRepository){
            if(department.getDepartmentID() == id) {
                department.setName(name);
                return true;
            }
        }
        return false;
    }
}
