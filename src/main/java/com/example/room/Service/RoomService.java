package com.example.room.Service;

import com.example.room.Entity.Room;
import com.example.room.Repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class RoomService {


    @Autowired
    private RoomRepository roomRepository;
    public String addRoom(Room room) {
        roomRepository.save(room);
        return "room added";
    }

    public List<Room> getAllAvailableRooms() {
        return roomRepository.findByBooked(false);
    }

    public void deleteRoom(String roomNumber) throws Exception {
        Optional<Room> room = roomRepository.findByRoomNumber(roomNumber);
        if (room.isPresent()) {
            roomRepository.delete(room.get());
        } else {
            throw new Exception("Room not found");
        }
    }
    public void bookRoom(String roomNumber) throws Exception {
        Optional<Room> room = roomRepository.findByRoomNumber(roomNumber);
        if (room.isPresent()) {
            if (!room.get().isBooked()) {
                room.get().setBooked(true);
                roomRepository.save(room.get());
            } else {
                throw new Exception("Room is already booked");
            }
        } else {
            throw new Exception("Room not found");
        }
    }
}
