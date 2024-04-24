
interface Parser {
    String parse(String str);
}

class Convertor {
    static String allUpperCase(String str) {
        return str.toUpperCase();
    }
}

class Printer

{
    void print(String str, Parser parser) {
        str = parser.parse(str);
        System.out.println();
        System.out.println("result " + str);
    }
}

public class MethodReference {

    public static void main(String[] args) {

        Printer print = new Printer();
        print.print("aathi", new Parser() {

            @Override
            public String parse(String str) {
                Convertor convertor = new Convertor();
                return convertor.allUpperCase(str);
            }

        });

        print = new Printer();
        print.print("vanakkam", (str) -> {
            Convertor convertor = new Convertor();
            return convertor.allUpperCase(str);
        });

        print = new Printer();
        print.print("munnar", Convertor::allUpperCase);

    }

}
