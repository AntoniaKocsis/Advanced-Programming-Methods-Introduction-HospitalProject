package Repository;

import Domain.Prescription;

import java.util.ArrayList;

public class PrescriptionRepository extends BaseRepository<Prescription> {
    private ArrayList<Prescription> prescriptionsRepository;

    public PrescriptionRepository() {
        super();
        this.prescriptionsRepository = new ArrayList<>();
    }

    @Override
    public void add(Prescription item) {
        prescriptionsRepository.add(item);
    }

    @Override
    public boolean remove(int id) {
        for (Prescription prescription : prescriptionsRepository) {
            if (prescription.getPrescriptionID() == id) {
                prescriptionsRepository.remove(prescription);
                return true;
            }
        }
        return false;
    }

    @Override
    public ArrayList<Prescription> getAll() {
        return prescriptionsRepository;
    }
}
