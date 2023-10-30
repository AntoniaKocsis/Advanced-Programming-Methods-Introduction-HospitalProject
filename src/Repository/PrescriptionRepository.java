package Repository;

import Domain.Medication;
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
    public boolean remove(Prescription prescription) {
        return prescriptionsRepository.remove(prescription);
    }

    @Override
    public ArrayList<Prescription> getAll() {
        return prescriptionsRepository;
    }
    public void addMedication(Prescription prescription,Medication medication){
        prescription.addMedication(medication);

    }
    public boolean removeMedication(Prescription prescription,Medication medication){
        return prescription.removeMedication(medication);
    }
    public void setMedicationList(Prescription prescription, ArrayList<Medication> medications){
        prescription.setMedications(medications);
    }
}
