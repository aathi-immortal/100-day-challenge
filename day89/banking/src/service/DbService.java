package service;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;

import model.Bank;
import model.NormalCustomer;

public class DbService implements IDbService {

    static String fileName = "bank_db.txt";

    public DbService() {

    }

    @Override
    public HashMap<Integer, NormalCustomer> getAllCustomerDetails() {

        HashMap<Integer, NormalCustomer> customers = new HashMap<>();
        try {

            FileInputStream fileInputStream = new FileInputStream(fileName);
            StringBuilder customerDetailsBuilder = new StringBuilder();

            int data = fileInputStream.read();
            while (data != -1) {
                if (data != 10) {
                    customerDetailsBuilder.append((char) data);
                } else {

                    NormalCustomer customer = customerDetailsExtracter(customerDetailsBuilder.toString());

                    customers.put(customer.getCustomerId(), customer);
                    customerDetailsBuilder = new StringBuilder();
                }

                data = fileInputStream.read();

            }
            fileInputStream.close();

        } catch (Exception e) {
            System.out.println(e);
        }
        return customers;
    }

    private NormalCustomer customerDetailsExtracter(String customerDetailsString) {
        String[] customerDetailsArray = customerDetailsString.split(",");
        NormalCustomer customer = new NormalCustomer();
        customer.setCustomerId(Integer.parseInt(customerDetailsArray[0]));
        customer.setAccountNumber(Long.parseLong(customerDetailsArray[1]));
        customer.setCustomerName(customerDetailsArray[2]);
        customer.setBalance(Float.parseFloat(customerDetailsArray[3]));
        customer.setPassword(customerDetailsArray[4]);
        return customer;

    }

    @Override
    public void addCustomer(NormalCustomer customer) {

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(fileName, true);
            byte[] customerByte = customerToByte(customer);
            fileOutputStream.write(customerByte);
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (Exception e) {

        }
    }

    private byte[] customerToByte(NormalCustomer customer) {
        return customer.toString().getBytes();
    }

    @Override
    public void updateBalance() {
        Bank bank = Bank.getBank();
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(fileName);
            fileOutputStream.flush();
            for (NormalCustomer customer : bank.customers.values()) {
                addCustomer(customer);
            }
            fileOutputStream.close();
        } catch (Exception e) {

        }
    }

}
