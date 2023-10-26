package Controller;
import Domain.HospitalRoom;
import Domain.HospitalRoomFactory;
import Repository.HospitalRoomRepository;

import java.util.ArrayList;
import java.util.Objects;

public class HospitalRoomController extends BaseController<HospitalRoom>{
    private HospitalRoomRepository hospitalRoomRepository;
    private HospitalRoomFactory hospitalRoomFactory;

    public HospitalRoomController(HospitalRoomRepository hospitalRoomRepository,HospitalRoomFactory hospitalRoomFactory) {
        super();
        this.hospitalRoomRepository = hospitalRoomRepository;
        this.hospitalRoomFactory = hospitalRoomFactory;
    }
    public void add(int number,String roomType){
        if(Objects.equals(roomType, "ExaminationRoom")) {
            hospitalRoomRepository.add(hospitalRoomFactory.createExaminationRoom(number));
            return;
        }
        if(Objects.equals(roomType, "AdmissionRoom")){
            hospitalRoomRepository.add(hospitalRoomFactory.createAdmissionRoom(number));
            return;
        }
    }

    @Override
    public boolean remove(int id) {
        return hospitalRoomRepository.remove(id);
    }

    @Override
    public ArrayList<HospitalRoom> getAll() {
        return hospitalRoomRepository.getAll();
    }
}
