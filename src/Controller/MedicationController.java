package Controller;

import Domain.Medication;
import Repository.MedicationRepository;

import java.util.ArrayList;

public class MedicationController extends BaseController<Medication> {
    private MedicationRepository medicationRepository;

    public MedicationController(MedicationRepository medicationRepository) {
        super();
        this.medicationRepository = medicationRepository;
    }

    public void add(String name, int concentration) {
        Medication medication = new Medication(name, concentration);
        medicationRepository.add(medication);
    }

    public boolean updateName(int id, String name) {
        for (Medication medication : medicationRepository.getAll()) {
            if (medication.getMedicationID() == id) {
                medicationRepository.updateName(medication,name);
            }
        }
        return false;
    }

    public boolean updateConcentration(int id, int concentration) {
        for (Medication medication : medicationRepository.getAll()) {
            if (medication.getMedicationID() == id) {
                medicationRepository.updateConcentration(medication,concentration);
            }
        }
        return false;
    }

    @Override
    public boolean remove(int id) {

        for (Medication medication : medicationRepository.getAll()) {
            if (medication.getMedicationID() == id) {
                return medicationRepository.remove(medication);
            }
        }
        return false;
    }

    @Override
    public ArrayList<Medication> getAll() {
        return medicationRepository.getAll();
    }
}

