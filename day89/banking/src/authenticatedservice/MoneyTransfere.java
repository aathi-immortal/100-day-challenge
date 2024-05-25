package authenticatedservice;

import java.util.Scanner;

import model.CustomerStatus;

public class MoneyTransfere implements ATMService {

    @Override
    public void doService(CustomerStatus customerStatus) {
        Scanner scan = new Scanner(System.in);

        float amount;
        int reciverId;
        System.out.println("enter the amount to transfer");
        amount = scan.nextFloat();
        System.out.println("enter the reciver CustomerId");
        reciverId = scan.nextInt();
        scan.nextLine();
        transfere(customerStatus.customerId, reciverId, amount);

    }

    private void transfere(int customerId, int reciverId, float amount) {
        DepositeService depositeService = new DepositeService();
        WithDrawalService withDrawalService = new WithDrawalService();

        boolean statusOfWithdraw = withDrawalService.withdrawAmount(customerId, amount);
        boolean statusOfDeposite = false;
        if (statusOfWithdraw) {
            statusOfDeposite = depositeService.deposit(amount, reciverId);
        }
        if (!(statusOfWithdraw == statusOfDeposite)) {
            withDrawalService.withdrawAmount(customerId, amount);
        } else {
            System.out.println("amount transfer successfully ");
        }

    }

}
