

interface Calculation {
    int add();

    int sub();
}

@FunctionalInterface
interface Cal<T> {
    T operation(T first, T second);

}

class Learning {

    Calculation cal = new Calculation() {

        @Override
        public int add() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'add'");
        }

        @Override
        public int sub() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'sub'");
        }

    };

    public static void main(String[] args) {
        int addition = Calculator(1, 2, (first, second) -> {
            return first + second;
        });
        int subtraction = Calculator(20, 40, (first, second) -> {
            return first - second;
        });
        System.out.println("value " + addition);
        System.out.println(subtraction);

    }

    public static <T> T Calculator(T first, T second, Cal<T> calOperation) {
        return calOperation.operation(first, second);
    }

}
