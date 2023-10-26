package Repository;

import Domain.Doctor;
import Interfaces.UpdatePersonInfoInterface;

import java.util.ArrayList;
import java.util.Date;

public class DoctorRepository extends BaseRepository<Doctor> implements UpdatePersonInfoInterface {
    private ArrayList<Doctor> doctorRepository;

    public DoctorRepository() {
        super();
        this.doctorRepository = new ArrayList<>();
    }

    @Override
    public void add(Doctor doctor) {
        doctorRepository.add(doctor);
    }

    @Override
    public boolean remove(int doctorID) {
        for (Doctor doctor : doctorRepository) {
            if (doctor.getDoctorID() == doctorID) {
                return doctorRepository.remove(doctor);
            }
        }
        return false;
    }

    @Override
    public ArrayList<Doctor> getAll() {
        return doctorRepository;
    }

    @Override
    public boolean updateFirstName(int ID, String name) {
        for (Doctor doctor : doctorRepository) {
            if (doctor.getDoctorID() == ID) {
                doctor.setFirstName(name);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean updateLastName(int ID, String name) {
        for (Doctor doctor : doctorRepository) {
            if (doctor.getDoctorID() == ID) {
                doctor.setLastName(name);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean updateContact(int ID, String contact) {
        for (Doctor doctor : doctorRepository) {
            if (doctor.getDoctorID() == ID) {
                doctor.setContact(contact);
                return true;
            }

        }
        return false;
    }

    @Override
    public boolean updateAddress(int ID, String address) {
        for (Doctor doctor : doctorRepository) {
            if (doctor.getDoctorID() == ID) {
                doctor.setAddress(address);
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean updateBirthDate(int ID, Date date) {
        for (Doctor doctor : doctorRepository) {
            if (doctor.getDoctorID() == ID) {
                doctor.setBirthDate(date);
                return true;
            }
        }
        return false;
    }
}
