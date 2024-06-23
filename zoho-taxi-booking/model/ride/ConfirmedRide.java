package model.ride;

public class ConfirmedRide extends Ride {

    private int dropTime;
    private float amount;

    public ConfirmedRide() {
        super();
    }

    public int getDropTime() {
        return dropTime;
    }

    public void setDropTime(int dropTime) {
        this.dropTime = dropTime;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public ConfirmedRide(int customerId, Character from, Character to, int pickUpTime, int dropTime, float amount) {
        super(customerId, from, to, pickUpTime);
        this.dropTime = dropTime;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return super.toString() + " dropTime=" + dropTime + ", amount=" + amount + "]";
    }

}
