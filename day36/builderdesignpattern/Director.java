package builderdesignpattern;

public class Director {

    public void makeSUV() {
        Builder carBuilder = new CarBuilder();
        Builder carManualBuilder = new CarManualBuilder();

        carBuilder.setAirBag(true)
                .setBrandName("SUV")
                .setColor("red")
                .setengine("4000hores power")
                .setgps(true)
                .setnumberOfSeat(4);

    }

}
