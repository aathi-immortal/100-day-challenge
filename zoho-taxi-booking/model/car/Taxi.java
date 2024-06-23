package model.car;

import java.util.ArrayList;
import java.util.List;

import model.ride.ConfirmedRide;
import model.ride.Ride;

/**
 * Taxi
 */
public class Taxi extends Car {

    public Taxi(int id) {
        this.id = id + 1;
        this.currentLocation = 0;
        this.freeAt = 0;
        this.totalEarning = 0;
        this.allocatedRidesHistories = new ArrayList<>();
    }

    public float totalEarning;
    public int freeAt;
    public List<ConfirmedRide> allocatedRidesHistories;
}