package Domain;

public class HospitalRoomFactory {
    public HospitalRoom createExaminationRoom(int roomNumber) {
        return new ExaminationRoom(roomNumber);
    }

    public HospitalRoom createAdmissionRoom(int roomNumber) {
        return  new AdmissionRoom(roomNumber);
    }
}
