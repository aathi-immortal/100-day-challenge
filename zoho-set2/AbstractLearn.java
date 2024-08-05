
// interface AA {
//     public void doservice();

//     public void greeting();

// }

// abstract class BB implements AA {
//     BB(String name) {

//     }
// }
interface VV {

}

abstract class A implements VV {
    public void vanakkam() {
        System.out.println("vanakam from A");
    }

    static void heelo() {
        System.out.println("inside a");
    }
}

class B extends A {
    static void heelo() {
        System.out.println("inside b");
    }

    @Override
    public void vanakkam() {
        System.out.println("vanakam from B");
    }

    public void bHealth() {
        System.out.println("ssss");
    }

}

abstract public class AbstractLearn {
    public static void main(String[] args) {
        A a = new B();
        a.vanakkam();
    }

}
