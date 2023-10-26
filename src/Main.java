import Controller.DoctorController;
import Controller.HospitalRoomController;
import Controller.MedicationController;
import Controller.PatientController;
import Domain.HospitalRoom;
import Domain.HospitalRoomFactory;
import Repository.DoctorRepository;
import Repository.HospitalRoomRepository;
import Repository.MedicationRepository;
import Repository.PatientRepository;
import UI.DoctorUI;
import UI.PatientUI;
import UI.UI;
import UI.MedicationUI;
import UI.HospitalRoomUI;

public class Main {
    public static void main(String[] args) {

        PatientRepository patientRepository = new PatientRepository();
        PatientController patientController = new PatientController(patientRepository);
        PatientUI patientUI = new PatientUI(patientController);

        DoctorRepository doctorRepository  = new DoctorRepository();
        DoctorController doctorController = new DoctorController(doctorRepository);
        DoctorUI doctorUI = new DoctorUI(doctorController);

        MedicationRepository medicationRepository = new MedicationRepository();
        MedicationController medicationController = new MedicationController(medicationRepository);
        MedicationUI medicationUI = new MedicationUI(medicationController);

        HospitalRoomRepository hospitalRoomRepository = new HospitalRoomRepository();
        HospitalRoomFactory hospitalRoomFactory = new HospitalRoomFactory();
        HospitalRoomController hospitalRoomController  = new HospitalRoomController(hospitalRoomRepository,hospitalRoomFactory);
        HospitalRoomUI hospitalRoomUI = new HospitalRoomUI(hospitalRoomController);

        UI ui = new UI(patientUI,medicationUI,doctorUI);
        ui.menu();
    }
}