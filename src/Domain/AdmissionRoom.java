package Domain;

public class AdmissionRoom extends HospitalRoom{
    public AdmissionRoom(int roomNumber) {
        super(roomNumber);
    }
    @Override
    public String toString() {
        return "AdmissionRoom{" +
                "roomID=" + this.getRoomID()+
                ", roomNumber=" + this.getRoomNumber() +
                '}';
    }
}
