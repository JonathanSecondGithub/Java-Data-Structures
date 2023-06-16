package Java;

public class StackArray {
    private int maxSize;
    private int[] stackArray;
    private int top;

    public StackArray(int size) {
        maxSize = size;
        stackArray = new int[maxSize];
        top = -1;
    }

    public void push(int value) {
        if (top == maxSize - 1) {
            System.out.println("Stack is full.");
            return;
        }
        top++;
        stackArray[top] = value;
    }

    public int pop() {
        if (top == -1) {
            System.out.println("Stack is empty.");
            return -1;
        }
        int value = stackArray[top];
        top--;
        return value;
    }

    public int peek() {
        if (top == -1) {
            System.out.println("Stack is empty.");
            return -1;
        }
        return stackArray[top];
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public static void main(String[] args) {
        StackArray myStack = new StackArray(5);
        myStack.push(10);
        myStack.push(20);
        myStack.push(30);
        System.out.println(myStack.pop()); // prints 30
        System.out.println(myStack.peek()); // prints 20
        System.out.println(myStack.isEmpty()); // prints false
    }
}
