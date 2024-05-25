
import model.Bank;
import service.BankService;

public class App {
    public static void main(String[] args) throws Exception {

        Bank bank = Bank.getBank();
        BankService bankService = new BankService();
        bankService.getAllCustomers();
        // bankService.addCustomer();
    }
}
