package model;

import java.util.ArrayList;
import java.util.HashMap;

import service.DbService;

public class Bank {

    private static Bank bankObject;
    public HashMap<Integer, NormalCustomer> customers;

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
