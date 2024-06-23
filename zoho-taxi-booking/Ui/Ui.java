package Ui;

import model.ride.RideRequest;
import taxiservice.Service;

public interface Ui {
    public void start();

    public RideRequest taxiBooking();

    public Service taxiDetails();
}
