package com.example.room.Repository;

import com.example.room.Entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoomRepository extends JpaRepository<Room,Integer> {
    List<Room> findByBooked(boolean booked);
    Optional<Room> findByRoomNumber(String roomNumber);
}
