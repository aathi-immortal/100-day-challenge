package model;

import java.util.ArrayList;

import service.DbService;

public class Bank {

    private static Bank bankObject;
    public ArrayList<NormalCustomer> customers;

    private Bank() {

        this.customerInitializer();

    }

    public static Bank getBank() {
        if (bankObject == null) {
            bankObject = new Bank();
        }
        return bankObject;

    }

    private void customerInitializer() {
        DbService service = new DbService();
        this.customers = service.getAllCustomerDetails();
    }

}
