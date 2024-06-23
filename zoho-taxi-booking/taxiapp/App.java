package taxiapp;
import java.util.ArrayList;
import java.util.List;

import Ui.Ui;
import Ui.UiTemplate;
import model.car.Car;
import model.car.Taxi;
import taxiservice.Service;

public class App {

    public static List<Taxi> taxis;

    public static void main(String[] args) {
        taxis = Service.generateTaxi(4);
        Ui ui = new UiTemplate();
        
        ui.start();

    }
}
