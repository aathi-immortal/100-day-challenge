package train.src.main.java.service;

public class BookingService implements Service {
    static int lowerBreath = 1;
    static int pperBreath = 1;
    static int middleBreath = 1;
    static int Rac = 1;
    static int waiting = 1;

    @Override
    public void doService() {
        askPassengerDetails();
    }

}
