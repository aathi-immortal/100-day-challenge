import java.util.ArrayDeque;

/**
 * ArrayDeqeueLearning
 */
public class ArrayDeqeueLearning {
    public static void main(String[] args) {

        // queue
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        arrayDeque.offerLast(1);
        arrayDeque.offerLast(2);
        arrayDeque.offerLast(3);
        System.out.println(arrayDeque.pollFirst());
        System.out.println(arrayDeque.pollFirst());
        System.out.println(arrayDeque.pollFirst());
        // stack
        arrayDeque.offerFirst(1);
        arrayDeque.offerFirst(2);
        arrayDeque.offerFirst(3);
        System.out.println(arrayDeque.pollFirst());
        System.out.println(arrayDeque.pollFirst());
        System.out.println(arrayDeque.pollFirst());
    }

}