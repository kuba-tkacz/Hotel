package repository;

import model.Room;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Hotel {

    private List<Room> rooms = new ArrayList<>();

    public Hotel(){
        int size = 1;
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            if (i % 3 == 0 && i!= 0) {
                size++;
            }
            rooms.add(new Room(size,random.nextBoolean()));
        }
        //System.out.println(rooms);
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public List<Room> getAvailableRooms(){
        return rooms.stream()
                .filter(room -> room.isAvailable())
                .collect(Collectors.toList());
    }

    public Room findRoomByNumber(int number) {
        return  rooms.stream()
                .filter(room -> room.getNumber() == number)
                .findAny()
                .orElseThrow(); //throw NoSuchElementException()
    }

}
