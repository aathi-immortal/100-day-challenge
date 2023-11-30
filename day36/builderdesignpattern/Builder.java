package builderdesignpattern;

public interface Builder {
    public Builder setBrandName(String brandName);

    public Builder setnumberOfSeat(int numberOfSeat);

    public Builder setengine(String engineName);

    public Builder setgps(Boolean gps);

    public Builder setColor(String color);

    public Builder setAirBag(Boolean airBag);

}
