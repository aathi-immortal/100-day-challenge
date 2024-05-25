package authenticatedservice;

import java.util.Scanner;

import model.Bank;
import model.CustomerStatus;
import model.NormalCustomer;
import service.DbService;
import service.IDbService;

public class WithDrawalService implements ATMService {

    Bank bank;
    IDbService dbService;

    public WithDrawalService() {
        bank = Bank.getBank();
        dbService = new DbService();
    }

    @Override
    public void doService(CustomerStatus customerStatus) {
        Scanner scan = new Scanner(System.in);
        int amount;
        System.out.println("enter the withdraw amount :");
        amount = scan.nextInt();
        if (withdrawAmount(customerStatus.customerId, amount))
            System.out.println("amount credited successfully");
    }

    public boolean withdrawAmount(int customerId, float amount) {

        if (bank.customers.containsKey(customerId)) {
            NormalCustomer customer = bank.customers.get(customerId);

            float currentBalance = customer.getBalance() - amount;
            if (currentBalance >= 1000) {
                customer.setBalance(currentBalance);
                dbService.updateBalance();
                return true;
            } else {
                System.out.println("can't do withdraw minimum balance must be 1000");
            }

        } else {
            System.out.println("user not found");
        }
        return false;

    }

}
