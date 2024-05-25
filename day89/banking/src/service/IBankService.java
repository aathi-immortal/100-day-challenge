package service;

import authenticatedservice.ATMService;
import model.CustomerStatus;

public interface IBankService {

    public void addCustomer();

    public void getAllCustomers();

    public String encrypter(String password);

    public void authenticatedService(ATMService service);

    public void printMenu();

    public CustomerStatus login();
}
