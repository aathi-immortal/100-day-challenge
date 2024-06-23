package model.ride;

public class RideRequest extends Ride {

    public RideRequest() {
        super();
    }

    public RideRequest(int customerId, Character from, Character to, int pickUpTime) {
        super(customerId, from, to, pickUpTime);

    }

}
