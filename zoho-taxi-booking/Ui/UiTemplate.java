package Ui;

import java.util.Scanner;
import model.ride.*;
import model.ride.RideRequest;
import taxiservice.*;

public class UiTemplate implements Ui {
    Scanner scan;

    public UiTemplate() {
        scan = new Scanner(System.in);
    }

    @Override
    public void start() {

        int choice = 0;

        do {
            printCatalog();

            try {
                choice = scan.nextInt();

                pickService(choice).service();

            } catch (Exception e) {
                System.out.println(e.toString());
                scan.nextLine();
            }
        } while (choice != 3);

    }

    private Service pickService(int choice) {

        if (choice == 1) {
            return bookTaxi();

        } else if (choice == 2) {
            return taxiDetails();
        } else if (choice == 3)
            System.out.println("thank you");
        else
            System.out.println("please enter the valid option!!!!");
        return null;

    }

    private Service bookTaxi() {
        RideRequest rideRquest = taxiBooking();
        Service service = RideRequestService.getInstance(rideRquest);
        return service;
    }

    private void printCatalog() {
        System.out.println("\n\n-----------------------------------------------------------------");
        System.out.println("Taxi Booking - 1");
        System.out.println("Taxi Details - 2\n");
        System.out.println("exit - 3");
        System.out.println("-----------------------------------------------------------------");
        System.out.println("enter the choice");

    }

    @Override
    public RideRequest taxiBooking() {
        RideRequest rideRequest = new RideRequest();

        System.out.println(" \tCall Taxi Booking ");
        System.out.println("Customer Id :");
        rideRequest.setCustomerId(scan.nextInt());
        scan.nextLine();
        System.out.println("Pick up Point :");
        rideRequest.setFrom(scan.nextLine().trim().charAt(0));
        System.out.println("Drop point :");
        rideRequest.setTo(scan.nextLine().charAt(0));
        System.out.println("Pick up Time :");
        rideRequest.setPickUpTime(scan.nextInt());

        return rideRequest;

    }

    @Override
    public Service taxiDetails() {
        Service service = new RideDetailService();
        return service;
    }

}
