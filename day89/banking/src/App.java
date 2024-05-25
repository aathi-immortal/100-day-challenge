
import java.util.Scanner;

import model.Bank;
import service.BankService;
import service.*;

public class App {
    public static void main(String[] args) throws Exception {

        try {
            Bank bank = Bank.getBank();
            IBankService bankService = new BankService();

            // bankService.addCustomer();

            // bankService.getAllCustomers();

            bankService.printMenu();
        } catch (Exception e) {
            System.out.println("error");
        }

    }

}
