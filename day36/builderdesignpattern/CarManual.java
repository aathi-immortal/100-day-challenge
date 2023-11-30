package builderdesignpattern;

public class CarManual {
    
    String brandName;
    int numberOfSeat;
    String engine;
    boolean tripComputer;
    boolean gps;
    String color;
    boolean airbag;
    public CarManual(String brandName, int numberOfSeat, String engine, boolean tripComputer, boolean gps, String color,
            boolean airbag) {
        this.brandName = brandName;
        this.numberOfSeat = numberOfSeat;
        this.engine = engine;
        this.tripComputer = tripComputer;
        this.gps = gps;
        this.color = color;
        this.airbag = airbag;
    }


}
