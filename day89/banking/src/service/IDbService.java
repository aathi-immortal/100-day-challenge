package service;

import java.util.ArrayList;
import java.util.HashMap;

import model.NormalCustomer;

public interface IDbService {

    public HashMap<Integer, NormalCustomer> getAllCustomerDetails();

    public void addCustomer(NormalCustomer normalCustomer);

    public void updateBalance();

}
