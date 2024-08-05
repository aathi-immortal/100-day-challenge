package train.src.main.java;

import java.util.Scanner;

import train.src.main.java.service.BookingService;
import train.src.main.java.service.CancelService;
import train.src.main.java.service.Service;

public class Client {

    public static void main(String[] args) {
        while (true) {
            Service service = displayOption();
            service.doService();
        }

    }

    private static Service displayOption() {
        Scanner scan = new Scanner(System.in);
        System.out.println("1. Book Ticket");
        System.out.println("2. Cancel Ticket");
        System.out.println("3. Available Ticket");
        System.out.println("4. Booked Ticket");
        System.out.println("5. Exit");
        int option = scan.nextInt();
        switch (option) {
            case 1:
                return new BookingService();

            case 2:
                return new CancelService();
            default:
                return null;
        }

    }
}
