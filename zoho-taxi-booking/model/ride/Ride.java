package model.ride;

public abstract class Ride {

    private int customerId;
    // pick up point
    private Character from;
    // drop point
    private Character to;
    // pick up time
    private int pickUpTime;

    public Ride() {

    }

    public Ride(int customerId, Character from, Character to, int pickUpTime) {
        this.customerId = customerId;
        this.from = from;
        this.to = to;
        this.pickUpTime = pickUpTime;
    }

    // drop time
    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public Character getFrom() {
        return from;
    }

    public void setFrom(Character from) {
        this.from = from;
    }

    public Character getTo() {
        return to;
    }

    public void setTo(Character to) {
        this.to = to;
    }

    public int getPickUpTime() {
        return pickUpTime;
    }

    public void setPickUpTime(int pickUpTime) {
        this.pickUpTime = pickUpTime;
    }

    @Override
    public String toString() {
        return "Ride [customerId=" + customerId + ", from=" + from + ", to=" + to + ", pickUpTime=" + pickUpTime;
    }

}
