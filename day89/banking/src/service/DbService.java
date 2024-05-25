package service;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;

import model.NormalCustomer;

public class DbService implements IDbService {

    static String fileName = "bank_db.txt";

    @Override
    public ArrayList<NormalCustomer> getAllCustomerDetails() {

        ArrayList<NormalCustomer> customers = new ArrayList<>();
        try {

            FileInputStream fileInputStream = new FileInputStream(fileName);
            StringBuilder customerDetailsBuilder = new StringBuilder();

            int data = fileInputStream.read();
            while (data != -1) {
                if (data != 10) {
                    customerDetailsBuilder.append((char) data);
                } else {

                    customers.add(customerDetailsExtracter(customerDetailsBuilder.toString()));
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
}
