package Repository;

import Domain.AdmissionRoom;
import Domain.ExaminationRoom;
import Domain.HospitalRoom;

import java.util.ArrayList;

public class HospitalRoomRepository extends BaseRepository<HospitalRoom>{
    // ?? add HospitalFactory instance
    private ArrayList<HospitalRoom> roomsRepository;

    public HospitalRoomRepository() {
        super();
        this.roomsRepository = new ArrayList<>();
    }

    @Override
    public void add(HospitalRoom item) {
        roomsRepository.add(item);
    }

    @Override
    public boolean remove(int id) {
        for(HospitalRoom room:roomsRepository){
            if(room.getRoomID() == id){
                roomsRepository.remove(room);
                return true;
            }
        }
        return false;
    }

    @Override
    public ArrayList<HospitalRoom> getAll() {
        return roomsRepository;
    }

    public ArrayList<ExaminationRoom> getAllExaminationRooms(){
        ArrayList<ExaminationRoom> rooms = new ArrayList<>();
        for(HospitalRoom hospitalRoom: roomsRepository){
            if(hospitalRoom instanceof ExaminationRoom){
                rooms.add((ExaminationRoom) hospitalRoom);
            }
        }
        return rooms;
    }
    public ArrayList<AdmissionRoom> getAllAdmissionRooms(){
        ArrayList<AdmissionRoom> rooms = new ArrayList<>();
        for(HospitalRoom hospitalRoom: roomsRepository){
            if(hospitalRoom instanceof AdmissionRoom){
                rooms.add((AdmissionRoom) hospitalRoom);
            }
        }
        return rooms;
    }
}
