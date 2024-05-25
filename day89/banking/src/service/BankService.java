package service;

import java.util.Scanner;

import authenticatedservice.ATMService;
import authenticatedservice.DepositeService;
import authenticatedservice.MoneyTransfere;
import authenticatedservice.WithDrawalService;
import model.Bank;
import model.CustomerStatus;
import model.NormalCustomer;

public class BankService implements IBankService {

    private static int shift = 1;
    Bank bank;
    IDbService dbService;
    Scanner scan;
    IAuthenticationService authenticationService;

    public BankService() {
        scan = new Scanner(System.in);
        bank = Bank.getBank();
        dbService = new DbService();
        authenticationService = new AuthenticationService();
    }

    @Override
    public void addCustomer() {

        NormalCustomer customer = getDetailsFromConsole();
        dbService.addCustomer(customer);
        bank.customers.put(customer.getCustomerId(), customer);

        System.out.println("added successfully");

    }

    public void getAllCustomers() {

        System.out.println("\n\tcustomers");
        for (NormalCustomer customer : bank.customers.values()) {
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
        return encrypter(password);

    }

    private long getUniqueAccountNumber() {
        long accountNumber;
        if (bank.customers.size() == 0)
            accountNumber = 0;
        else {
            accountNumber = bank.customers.size();
            accountNumber = bank.customers.get((int) accountNumber).getAccountNumber();
        }

        return accountNumber + 1;
    }

    private int getUniqueCustomerId() {
        int customerId;
        if (bank.customers.size() == 0)
            customerId = 0;
        else {
            customerId = bank.customers.size();
            customerId = bank.customers.get(customerId).getCustomerId();
        }

        return customerId + 1;
    }

    @Override
    public String encrypter(String password) {
        int encrypterKey;
        int head;
        StringBuilder passwordBuilder = new StringBuilder(password);
        for (int index = 0; index < passwordBuilder.length(); index++) {
            int characterAscii = passwordBuilder.charAt(index);
            if (characterAscii < 58) {
                head = 48;
                encrypterKey = 58;
            } else if (characterAscii < 91) {
                encrypterKey = 91;
                head = 65;
            } else {
                encrypterKey = 123;
                head = 97;
            }
            passwordBuilder.setCharAt(index, shiftingAlgo(characterAscii, encrypterKey, head));
        }
        return passwordBuilder.toString();
    }

    private char shiftingAlgo(int characterAscii, int encrypterKey, int head) {
        int ciper = characterAscii + shift;
        if (ciper >= encrypterKey) {
            ciper = head + (ciper % encrypterKey);
        }
        return (char) (ciper);
    }

    @Override
    public void authenticatedService(ATMService service) {
        try {
            CustomerStatus customerStatus = login();
            if (customerStatus.verified)
                service.doService(customerStatus);
            else {
                System.out.println("wrong password or customer Id");
            }
        } catch (Exception e) {
            System.out.println("err");
        }

    }

    @Override
    public void printMenu() {

        Scanner scan = new Scanner(System.in);
        ATMService service = null;
        System.out.println("options");
        int option = 0;
        do {
            System.out.println("press 1 for deposit");
            System.out.println("press 2 for withdraw");
            System.out.println("press 3 for money transfer");
            System.out.println("press 4 to exit");
            System.out.println("enter the option");
            option = scan.nextInt();
            if (option == 1) {
                service = new DepositeService();
            } else if (option == 2) {
                service = new WithDrawalService();
            } else if (option == 3) {
                service = new MoneyTransfere();
            } else if (option != 4) {
                System.out.println("please enter the correct option");
                continue;
            } else {
                continue;
            }
            authenticatedService(service);

        } while (option != 4);

    }

    @Override
    public CustomerStatus login() {
        Scanner scan = new Scanner(System.in);
        int customerId;
        String password;
        System.out.println("enter customer id");
        customerId = scan.nextInt();
        scan.nextLine();
        System.out.println("enter your password :");
        password = scan.nextLine();
        password = encrypter(password);
        CustomerStatus customerStatus = new CustomerStatus();
        customerStatus.customerId = customerId;
        customerStatus.verified = authenticationService.isValidCredentials(customerId, password);
        return customerStatus;

    }

    // public static void main(String[] args) {
    // BankService bankService = new BankService();
    // String pas = bankService.encrypter("aath0129Az");
    // System.out.println();
    // System.out.println(pas);

    // }

}
