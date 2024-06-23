package taxiservice;

import model.car.Taxi;
import model.ride.ConfirmedRide;
import model.ride.RideRequest;
import taxiapp.App;

public class RideRequestService implements Service {

    private static RideRequestService instance;
    private RideRequest rideRequest;

    private RideRequestService() {

    }

    public static RideRequestService getInstance(RideRequest rideRequest) {
        if (instance == null) {
            instance = new RideRequestService();

        }
        instance.setRideRequest(rideRequest);
        return instance;
    }

    public RideRequest getRideRequest() {
        return rideRequest;
    }

    public void setRideRequest(RideRequest rideReques) {
        this.rideRequest = rideReques;
    }

    @Override
    public void service() {
        Taxi taxi = allocateTaxiService();
        // check it is valid taxi or not
        if (taxi.id == -12) {
            System.out.println("booking rejected");
        } else {
            updateCurrentTaxi(taxi);
            System.out.println("Taxi can be allotted");
            System.out.println("Taxi-" + taxi.id + " is allotted ");

        }
    }

    private void updateCurrentTaxi(Taxi taxi) {
        // if it is valid taxi
        // change the location of taxi tp drop point of passenger
        // change the totalEanring = totalEarning + getCost(pickPOint,dropPoint)
        // change free at
        // add currentRides in history
        taxi.currentLocation = Service.getLocationInIndex(rideRequest.getTo());
        taxi.totalEarning += getCost();
        taxi.freeAt = rideRequest.getPickUpTime() + getTotalTimeInTravel();
        taxi.allocatedRidesHistories.add(new ConfirmedRide(rideRequest.getCustomerId(), rideRequest.getFrom(),
                rideRequest.getTo(), rideRequest.getPickUpTime(), taxi.freeAt, getCost()));
        // taxi updated
    }

    private int getTotalTimeInTravel() {
        int from = Service.getLocationInIndex(rideRequest.getFrom());
        int to = Service.getLocationInIndex(rideRequest.getTo());
        int time = Math.abs(from - to);
        return time;
    }

    private float getCost() {
        int from = Service.getLocationInIndex(rideRequest.getFrom());
        int to = Service.getLocationInIndex(rideRequest.getTo());
        int distance = Math.abs(to - from) * 15;
        return 100 + (distance - 5) * 10;
    }

    private Taxi allocateTaxiService() {
        Taxi nearByTaxi = new Taxi(-12);
        nearByTaxi.currentLocation = 100;
        nearByTaxi.totalEarning = 100000;
        // traverse all avaliable taxi
        for (Taxi taxi : App.taxis) {
            // if the taxi free at is greater than rideRequestPickup time ignore it
            // if both taxi are in same location pick which has minimum totalEarning
            if (taxi.freeAt <= rideRequest.getPickUpTime()
                    && getTaxiToPickUpPointDistance(nearByTaxi) >= getTaxiToPickUpPointDistance(taxi)
                    && (getTaxiToPickUpPointDistance(nearByTaxi) != getTaxiToPickUpPointDistance(taxi)
                            || nearByTaxi.totalEarning >= taxi.totalEarning)) {
                nearByTaxi = taxi;
            }
        }
        return nearByTaxi;
    }

    private int getTaxiToPickUpPointDistance(Taxi taxi) {

        // rideRequest -> pickup POint
        return Math.abs(taxi.currentLocation - Service.getLocationInIndex(rideRequest.getFrom()));
    }

}
