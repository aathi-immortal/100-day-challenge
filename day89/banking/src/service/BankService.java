package service;

import java.util.Scanner;

import model.Bank;
import model.NormalCustomer;

public class BankService implements IBankService {

    Bank bank;
    IDbService dbService;
    Scanner scan;

    public BankService() {
        scan = new Scanner(System.in);
        bank = Bank.getBank();
        dbService = new DbService();
    }

    @Override
    public void addCustomer() {

        NormalCustomer customer = getDetailsFromConsole();
        dbService.addCustomer(customer);
        System.out.println(customer.toString());
        System.out.println("added successfully");

    }

    public void getAllCustomers() {

        System.out.println("\n\tcustomers");
        for (NormalCustomer customer : bank.customers) {
            System.out.println(customer.toString());
        }
    }

    private NormalCustomer getDetailsFromConsole() {
        String customerName;
        String password;
        int customerId;
        long accountNumber;

        System.out.println();
        System.out.println("enter the Your  Name :");
        customerName = scan.nextLine();
        password = getPassword();
        customerId = getUniqueCustomerId();
        accountNumber = getUniqueAccountNumber();
        return createCustomer(customerId, accountNumber, customerName, password);

    }

    private NormalCustomer createCustomer(int customerId, long accountNumber, String customerName, String password) {
        return new NormalCustomer(customerId, accountNumber, customerName, 10000, password);
    }

    private String getPassword() {

        String confrimPassword;
        System.out.println("enter account Password :");
        String password = scan.nextLine();

        do {
            System.out.println("reenter the account Password :");
            confrimPassword = scan.nextLine();
        } while (!password.equals(confrimPassword));
        return password;

    }

    private long getUniqueAccountNumber() {

        NormalCustomer lastCustomer = bank.customers.get(bank.customers.size() - 1);
        return lastCustomer.getAccountNumber() + 1;
    }

    private int getUniqueCustomerId() {
        NormalCustomer lastCustomer = bank.customers.get(bank.customers.size() - 1);
        return lastCustomer.getCustomerId() + 1;
    }

}
