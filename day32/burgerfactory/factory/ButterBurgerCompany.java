package burgerfactory.factory;

import burgerfactory.products.Burger;
import burgerfactory.products.ButterBurger;


//  concreatCreator class product 1


public class ButterBurgerCompany extends Company {

    @Override
    protected Burger createBurger() {
        return new ButterBurger();
    }

}
