package Repository;

import Domain.Medication;

import java.util.ArrayList;

public class MedicationRepository extends BaseRepository<Medication> {
    private ArrayList<Medication> medicationRepository;

    public MedicationRepository() {
        super();
        this.medicationRepository = new ArrayList<>();
    }
    public MedicationRepository(ArrayList<Medication> medications){
        super();
        medicationRepository = medications;
    }
    @Override
    public void add(Medication item) {
        medicationRepository.add(item);
    }

    @Override
    public boolean remove(Medication medication) {
        return medicationRepository.remove(medication);
    }

    public void updateName(Medication medication, String name) {
        medication.setName(name);
    }

    public void updateConcentration(Medication medication, int concentration) {
        medication.setConcentration(concentration);
    }

    @Override
    public ArrayList<Medication> getAll() {
        return medicationRepository;
    }
}
