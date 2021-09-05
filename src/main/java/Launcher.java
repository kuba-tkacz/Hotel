import presenter.Presenter;
import repository.Hotel;
import service.HotelService;

public class Launcher {
    public static void main(String[] args) {
        Hotel hotel = new Hotel();
        HotelService service = new HotelService(hotel);
        Presenter presenter = new Presenter(service);
        presenter.startMenu();
    }
}