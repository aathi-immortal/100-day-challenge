import java.util.*;
import java.io.*;

class StackData

{
    int data;
    int minimumValue;
}

public class MinStack {

    Stack<StackData> stack;

    MinStack() {
        stack = new Stack<>();
    }

    void pushWithMin(int value,int minimum)
    {
        StackData data = new StackData();
        data.data = value;
        data.minimumValue = minimum;
        stack.add(data);
    }

    // Function to add another element equal to num at the top of stack.
    void push(int num) {
        
            if(top() == -1)
            {
                pushWithMin(num, num);
                return;
            }
            int minimum = stack.peek().minimumValue;
            if(num < minimum)
                pushWithMin(num, num);
            else
                pushWithMin(num, minimum);
            

                
    }

    // Function to remove the top element of the stack.
    int pop() {
        if (stack.isEmpty())
            return -1;
        return stack.pop().data;
    }

    // Function to return the top element of stack if it is present. Otherwise
    // return -1.
    int top() {
        if (stack.isEmpty())
            return -1;
        return stack.peek().minimumValue;
    }

    // Function to return minimum element of stack if it is present. Otherwise
    // return -1.
    int getMin() {

    }

}
