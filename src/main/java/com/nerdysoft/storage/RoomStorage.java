package com.nerdysoft.storage;

import com.nerdysoft.model.Room;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RoomStorage {
    private int id;
    private final List<Room> rooms;

    public RoomStorage() {
        id = 1;
        rooms = new ArrayList<>();
    }

    public Room getById(int id){
        Room room = new Room(id,null);
        if(rooms.contains(room)){
            int index = rooms.indexOf(room);
            return rooms.get(index);
        }
        return null;
    }

    public void add(Room room){
        room.setId(id++);
        rooms.add(room);

    }

    public void update(Room room){
        Room roomDB = rooms.stream().filter(room1 -> room1.getId()==room.getId()).findAny().orElse(null);
        if(roomDB!=null){
            roomDB.setRoom(room.getRoom());
        }else {
            add(room);
        }
    }


    public void delete(Room room){
        rooms.remove(room);
    }

    public List<Room> all(){
        return rooms;
    }


}
