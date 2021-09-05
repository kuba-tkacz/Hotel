package service;

import exception.RoomAvailableException;
import exception.RoomUnavailableException;
import model.Room;
import repository.Hotel;

import java.util.List;

public class HotelService {

    private Hotel hotel;

    public HotelService(Hotel hotel) {
        this.hotel = hotel;
    }

    public List<Room> getAllRooms() {
        return hotel.getRooms();
    }

    public List<Room> getAvailableRooms() {
        return hotel.getAvailableRooms();
    }

    public void reserveRoom(int number) throws RoomUnavailableException {
        Room room = hotel.findRoomByNumber(number);
        if (!room.isAvailable()) {
            throw new RoomUnavailableException();
        }
        room.reserve();
    }
    public void releaseRoom(int number) throws RoomAvailableException {
        Room room = hotel.findRoomByNumber(number);
        if (room.isAvailable()) {
            throw new RoomAvailableException();
        }
        room.release();
    }
}
