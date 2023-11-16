package burgerfactory;

import java.util.Scanner;

public class Company {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (true) {
            String user = scanner.nextLine();
            Burger burger;
            BurgerFactory burgerFactory = new BurgerFactory();
            burger = burgerFactory.createBurger(user);
            burger.prepare();

        }
    }
}