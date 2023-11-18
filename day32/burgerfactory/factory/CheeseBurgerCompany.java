package burgerfactory.factory;

import burgerfactory.products.Burger;
import burgerfactory.products.CheeseBurger;

//  concreatCreator class product 2

public class CheeseBurgerCompany extends Company {

    @Override
    protected Burger createBurger() {
        return new CheeseBurger();
    }

}
