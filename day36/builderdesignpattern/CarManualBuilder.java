package builderdesignpattern;

public class CarManualBuilder implements Builder {

    String brandName;
    int numberOfSeat;
    String engine;
    boolean tripComputer;
    boolean gps;
    String color;
    boolean airbag;

    @Override
    public Builder setBrandName(String brandName) {
        this.brandName = brandName;
        return this;
    }

    @Override
    public Builder setnumberOfSeat(int numberOfSeat) {
        this.numberOfSeat = numberOfSeat;
        return this;
    }

    @Override
    public Builder setengine(String engineName) {
        this.engine = engineName;
        return this;
    }

    @Override
    public Builder setgps(Boolean gps) {
        this.gps = gps;
        return this;
    }

    @Override
    public Builder setColor(String color) {
        this.color = color;
        return this;
    }

    @Override
    public Builder setAirBag(Boolean airBag) {
        this.airbag = airbag;
        return this;
    }

    public CarManual build() {
        return new CarManual(brandName, numberOfSeat, engine, tripComputer, gps, color, airbag);
    }

}
