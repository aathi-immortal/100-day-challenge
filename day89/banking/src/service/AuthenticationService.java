package service;

import model.Bank;

public class AuthenticationService implements IAuthenticationService {

    Bank bank;

    AuthenticationService() {
        bank = Bank.getBank();
    }

    @Override
    public boolean isValidCredentials(int customerId, String password) {

        if (bank.customers.containsKey(customerId)) {

            if (bank.customers.get(customerId).getPassword().compareTo(password) == 0) {
                return true;
            }

        }
        return false;

    }

}
