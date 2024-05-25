package model;

public class NormalCustomer {

    private int customerId;
    private long accountNumber;
    private String customerName;
    private float Balance;
    private String password;

    public NormalCustomer() {

    }

    public NormalCustomer(int customerId, long accountNumber, String customerName, float balance, String password) {
        this.customerId = customerId;
        this.accountNumber = accountNumber;
        this.customerName = customerName;
        Balance = balance;
        this.password = password;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public float getBalance() {
        return Balance;
    }

    public void setBalance(float balance) {
        Balance = balance;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return customerId + "," + accountNumber + ","
                + customerName + "," + Balance + "," + password + "\n";
    }

}
