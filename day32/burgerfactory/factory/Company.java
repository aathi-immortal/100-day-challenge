package burgerfactory.factory;

import java.util.Scanner;

import burgerfactory.products.Burger;


// factory class creator




public abstract class Company {

    public Burger orderBurger() {
        Burger burger = createBurger();
        burger.prepare();
        return burger;

    }

    protected abstract Burger createBurger();
}