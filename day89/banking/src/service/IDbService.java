package service;

import java.util.ArrayList;

import model.NormalCustomer;

public interface IDbService {

    public ArrayList<NormalCustomer> getAllCustomerDetails();

    public void addCustomer(NormalCustomer normalCustomer);
}
