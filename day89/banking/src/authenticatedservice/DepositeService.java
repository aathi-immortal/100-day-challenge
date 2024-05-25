package authenticatedservice;

import java.util.Scanner;

import model.Bank;
import model.CustomerStatus;
import model.NormalCustomer;
import service.DbService;
import service.IDbService;

public class DepositeService implements ATMService {
    Scanner scan;
    Bank bank;
    IDbService dbService;

    public DepositeService() {
        scan = new Scanner(System.in);
        bank = Bank.getBank();
        dbService = new DbService();

    }

    @Override
    public void doService(CustomerStatus customerStatus) {

        float amount;
        System.out.print("enter the deposit amount : ");
        amount = scan.nextFloat();
        scan.nextLine();
        if (deposit(amount, customerStatus.customerId))
            System.out.println("amount " + amount + " deposited successfully");
    }

    public boolean deposit(float amount, int customerId) {
        try {
            if (bank.customers.containsKey(customerId)) {
                float currentBalance = bank.customers.get(customerId).getBalance() + amount;
                bank.customers.get(customerId).setBalance(currentBalance);
                dbService.updateBalance();

                return true;
            } else {
                System.out.println("no user found");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return false;

    }

}
