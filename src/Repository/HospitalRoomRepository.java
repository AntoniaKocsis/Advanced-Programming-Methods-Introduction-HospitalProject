package Repository;

import Domain.AdmissionRoom;
import Domain.ExaminationRoom;
import Domain.HospitalRoom;

import java.util.ArrayList;

public class HospitalRoomRepository extends BaseRepository<HospitalRoom>{
    private ArrayList<HospitalRoom> roomsRepository;

    public HospitalRoomRepository() {
        super();
        this.roomsRepository = new ArrayList<>();
    }
    public HospitalRoomRepository(ArrayList<HospitalRoom> rooms){
        super();
        roomsRepository = rooms;

    }
    public HospitalRoom findByID(int id){
        HospitalRoom hospitalRoom = null;
        for(HospitalRoom room: roomsRepository){
            if(room.getRoomID() == id){
                hospitalRoom = room;
                break;
            }
        }
        return hospitalRoom;
    }
    @Override
    public void add(HospitalRoom item) {
        roomsRepository.add(item);
    }

    @Override
    public boolean remove(int hospitalRoomID) {
        HospitalRoom hospitalRoom = findByID(hospitalRoomID);
        if(hospitalRoom == null)
            return false;
        return roomsRepository.remove(hospitalRoom);
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
