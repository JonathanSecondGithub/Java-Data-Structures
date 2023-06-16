package Java;

public class StackLinkedList {
    private Node top;

    private class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
            next = null;
        }
    }

    public StackLinkedList() {
        top = null;
    }

    public void push(int value) {
        Node newNode = new Node(value);
        newNode.next = top;
        top = newNode;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return -1;
        }
        int value = top.value;
        top = top.next;
        return value;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return -1;
        }
        return top.value;
    }

    public boolean isEmpty() {
        return (top == null);
    }

    public static void main(String[] args) {
        StackLinkedList myStack = new StackLinkedList();
        myStack.push(10);
        myStack.push(20);
        myStack.push(30);
        System.out.println(myStack.pop()); // prints 30
        System.out.println(myStack.peek()); // prints 20
        System.out.println(myStack.isEmpty()); // prints false
    }
}
