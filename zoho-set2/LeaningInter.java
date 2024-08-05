/**
 * LeaningInter
 */

/**
 * InnerLeaningInter
 */
class Living {
    Living() {
        System.out.println("parent");
    }
}

interface AA {

}

interface BB {

}

interface Animal extends AA, BB {

    public static void isbreath() {
        System.out.println("i am static");

    }

    default public void sound() {
        System.out.println("i am default");
    }

}

/**
 * InnerLeaningInter
 */
class Cow extends Living implements Animal {

    Cow() {
        System.out.println("child");

    }

    @Override
    public void sound() {
        System.out.println("child");
    }

}

public class LeaningInter {
    public static void main(String[] args) {
        // Animal.isbreath();
        Animal animal = new Cow();
        // animal.sound();
    }
}