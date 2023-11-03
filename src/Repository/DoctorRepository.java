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
    public Doctor findByID(int doctorID){
        Doctor doctor = null;
        for(Doctor doctor1: doctorRepository){
            if(doctor1.getDoctorID() == doctorID){
                doctor = doctor1;
                break;
            }
        }
        return doctor;
    }

    public boolean enrollDoctor(int doctorID,int departmentID,DepartmentRepository departmentRepository) {
        Doctor doctor = findByID(doctorID);
        if(doctor == null){
            return false;
        }
        Department department = departmentRepository.findByID(departmentID);
        if(department == null)
            return false;

        if (!doctor.getDepartments().contains(department))
            doctor.enrollInDepartment(department);
        if (!department.getDoctors().contains(doctor))
            department.enrollDoctor(doctor);
        return true;
    }

    public boolean removeFromDepartment(int doctorID,int departmentID,DepartmentRepository departmentRepository) {
        Doctor doctor = findByID(doctorID);
        if(doctor == null){
            return false;
        }
        Department department = departmentRepository.findByID(departmentID);
        if(department == null)
            return false;
        doctor.removeDepartment(department);
        department.removeDoctor(doctor);
        return true;
    }

    @Override
    public void add(Doctor doctor) {
        doctorRepository.add(doctor);
    }

    @Override
    public boolean remove(int id) {
        for (Doctor doctor : doctorRepository) {
            if (doctor.getDoctorID() == id) {
                return doctorRepository.remove(doctor);
            }
        }
        return false;
    }

    @Override
    public ArrayList<Doctor> getAll() {
        return doctorRepository;
    }


    public boolean updateFirstName(int ID, String name) {
        for (Doctor doctor : doctorRepository) {
            if (doctor.getDoctorID() == ID) {
                doctor.setFirstName(name);
                return true;
            }
        }
        return false;

    }

    public boolean updateLastName(int ID, String name) {
        for (Doctor doctor : doctorRepository) {
            if (doctor.getDoctorID() == ID) {
                doctor.setLastName(name);
                return true;
            }
        }
        return false;

    }


    public boolean updateContact(int ID, String contact) {
        for (Doctor doctor : doctorRepository) {
            if (doctor.getDoctorID() == ID) {
                doctor.setContact(contact);
                return true;
            }
        }
        return false;

    }

    public boolean updateAddress(int ID, String address) {
        for (Doctor doctor : doctorRepository) {
            if (doctor.getDoctorID() == ID) {
                doctor.setAddress(address);
                return true;
            }
        }
        return false;

    }

    public boolean updateBirthDate(int ID, Date date) {
        for (Doctor doctor : doctorRepository) {
            if (doctor.getDoctorID() == ID) {
                doctor.setBirthDate(date);
                return true;
            }
        }
        return false;

    }
    public ArrayList<Department> getDepartments(int doctorID){
        Doctor doctor = null;
        for(Doctor doctor1: doctorRepository){
            if(doctor1.getDoctorID() == doctorID){
                doctor = doctor1;
                break;
            }
        }
        if(doctor == null){
            return new ArrayList<>();
        }
        return doctor.getDepartments();
    }
}
