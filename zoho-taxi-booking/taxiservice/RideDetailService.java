package taxiservice;

import model.car.Taxi;
import model.ride.ConfirmedRide;
import taxiapp.App;

public class RideDetailService implements Service {

    @Override
    public void service() {
        displayTaxiDetails();
    }

    private void displayTaxiDetails() {
        for (Taxi taxi : App.taxis) {
            System.out.println("Taxi No  :" + taxi.id + "  TotalEarning : " + taxi.totalEarning);
            for (ConfirmedRide ride : taxi.allocatedRidesHistories) {
                System.out
                        .println(ride.getCustomerId() + " " + ride.getCustomerId() + " " + ride.getFrom() + " "
                                + ride.getTo() + " "
                                + ride.getPickUpTime() + " " + ride.getDropTime() + " " + ride.getAmount());
            }
        }
    }

}
