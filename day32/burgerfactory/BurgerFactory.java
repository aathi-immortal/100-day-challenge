package burgerfactory;

import java.util.Scanner;

// this factory class is responsible for creating products
public class BurgerFactory {
    public Burger createBurger(String user) {

        if ("cheeseBurger".equals(user)) {
            return new CheeseBurger();
        } else {
            return new ButterBurger();
        }
    }

}
