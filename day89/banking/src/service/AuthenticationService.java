package service;

import model.Bank;

public class AuthenticationService implements IAuthenticationService {

    Bank bank;

    AuthenticationService() {
        bank = Bank.getBank();
    }

    @Override
    public boolean isValidCredentials(int customerId, String password) {
        
        if (bank.customers.containsKey(customerId) && bank.customers.get(customerId).getPassword().equals(password)) {
            return true;
        }
        return false;

    }

}
