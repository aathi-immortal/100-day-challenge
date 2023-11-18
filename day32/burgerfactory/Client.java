package burgerfactory;

import burgerfactory.factory.ButterBurgerCompany;
import burgerfactory.factory.CheeseBurgerCompany;
import burgerfactory.factory.Company;

// client will create it requeseted concret factory object using this factoy client can create the products
public class Client {
    public static void main(String[] args) {

        Company company = new ButterBurgerCompany();
        company.orderBurger();
        Company company2 = new CheeseBurgerCompany();
        company2.orderBurger();
    }
}
