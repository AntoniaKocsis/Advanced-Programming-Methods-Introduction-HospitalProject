package Repository;

import Domain.Medication;

import java.util.ArrayList;

public class MedicationRepository extends BaseRepository<Medication> {
    private ArrayList<Medication> medicationRepository;

    public MedicationRepository() {
        super();
        this.medicationRepository = new ArrayList<>();
    }

    @Override
    public void add(Medication item) {
        medicationRepository.add(item);
    }

    @Override
    public boolean remove(int id) {
        for (Medication medication : medicationRepository) {
            if (medication.getMedicationID() == id) {
                medicationRepository.remove(medication);
                return true;
            }
        }
        return false;
    }

    public boolean updateName(int id, String name) {
        for (Medication medication : medicationRepository) {
            if (medication.getMedicationID() == id) {
                medication.setName(name);
            }
        }
        return false;
    }

    public boolean updateConcentration(int id, int concentration) {
        for (Medication medication : medicationRepository) {
            if (medication.getMedicationID() == id) {
                medication.setConcentration(concentration);
            }
        }
        return false;
    }

    @Override
    public ArrayList<Medication> getAll() {
        return medicationRepository;
    }
}
