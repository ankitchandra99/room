package com.example.room.Controller;

import com.example.room.Entity.Room;
import com.example.room.Service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rooms")
public class RoomController {
    @Autowired
    private RoomService roomService;

    @PostMapping("/add")
    public ResponseEntity addRoom(@RequestBody Room room){
        String result=roomService.addRoom(room);
        return new ResponseEntity(result, HttpStatus.OK);
    }
    @GetMapping("/available")
    public List<Room> getAllAvailableRooms() {
        return roomService.getAllAvailableRooms();
    }

    @DeleteMapping("/{roomNumber}")
    public void deleteRoom(@PathVariable String roomNumber) throws Exception {
        roomService.deleteRoom(roomNumber);
    }

    @PutMapping("/book/{roomNumber}")
    public void bookRoom(@PathVariable String roomNumber) throws Exception {
        roomService.bookRoom(roomNumber);
    }
}
