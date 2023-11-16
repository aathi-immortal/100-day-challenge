package burgerfactory;

import java.util.Scanner;

public class Company {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String user = scanner.nextLine();
            Burger burger;
            if ("cheeseBurger".equals(user)) {
                burger = new CheeseBurger();
            } else {
                burger = new ButterBurger();
            }
            burger.prepare();
        }

    }
}