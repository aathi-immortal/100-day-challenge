package taxiservice;

import java.util.ArrayList;
import java.util.List;

import model.car.Taxi;
import model.ride.RideRequest;

public interface Service {
    public void service();

    public static List<Taxi> generateTaxi(int size) {
        List<Taxi> taxis = new ArrayList<>();
        for (int time = 0; time < size; time++) {
            taxis.add(new Taxi(time));
        }
        return taxis;
    }

    public static int getLocationInIndex(Character location) {
        return ((int) Character.toUpperCase(location)) - 65;
    }

}
