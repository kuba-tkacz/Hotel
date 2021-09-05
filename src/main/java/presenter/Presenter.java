package presenter;

import exception.RoomAvailableException;
import exception.RoomUnavailableException;
import model.Room;
import service.HotelService;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Presenter {

    private HotelService service;
    private Scanner scanner = new Scanner(System.in);

    public Presenter(HotelService service) {
        this.service = service;
    }

    public void startMenu() {
        do {
            int decision = askForOption();
            executeOption(decision);
        } while (true);
    }

    private int askForOption() {
        System.out.println("Co chcesz zrobić?");
        System.out.println("1. Wyświetl pokoje");
        System.out.println("2. Wyświetl dostępne pokoje");
        System.out.println("3. Zarezerwuj pokój");
        System.out.println("4. Zwolnij pokój");
        int decision = scanner.nextInt();
        return decision;
    }

    private void executeOption(int decision) {
        switch (decision) {
            case 1:
                System.out.println("Wszystkie pokoje: ");
                showRooms(service.getAllRooms());
                break;
            case 2:
                System.out.println("Dostępne pokoje:");
                showRooms(service.getAvailableRooms());
                break;
            case 3:
                try {
                    System.out.println("Który pokój chcesz zarezerwować?");
                    int number = scanner.nextInt();
                    service.reserveRoom(number);
                    System.out.println("Zarezerwowałeś pokój");
                }catch (NoSuchElementException e){
                    System.err.println("Nie ma pokoju o takim numerze");
                }catch (RoomUnavailableException e){
                    System.err.println("Pokój jest już zajęty");
                }
                break;
            case 4:
                try {
                    System.out.println("Który pokój chcesz zwolnić");
                    int number = scanner.nextInt();
                    service.releaseRoom(number);
                    System.out.println("Zwolniłeś pokój");
                }catch (NoSuchElementException e){
                    System.err.println("Nie ma pokoju o takim numerze");
                }catch (RoomAvailableException e){
                    System.err.println("Pokój został już zwolniony");
                }
        }
    }

    private void showRooms(List<Room> rooms) {
        for (Room room : rooms) {
            System.out.println(room);
        }
    }

}
