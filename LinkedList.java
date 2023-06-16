package Java;

public class LinkedList {
    Node head;

    static class Node {
        int data;
        Node next;

        // constructor
        Node(int d) {
            data = d;
            next = null;
        }
    }

    // Adding a new node at the beginning of the linked list
    public void push(int new_data) {
        Node new_node = new Node(new_data);
        new_node.next = head;
        head = new_node;
    }

    // Adding a new node after a given node
    public void insertAfter(Node prev_node, int new_data) {
        if (prev_node == null) {
            System.out.println("The given previous node cannot be null");
            return;
        }
        Node new_node = new Node(new_data);
        new_node.next = prev_node.next;
        prev_node.next = new_node;
    }

    // Adding a new node at the end of the linked list
    public void append(int new_data) {
        Node new_node = new Node(new_data);
        if (head == null) {
            head = new_node;
            return;
        }
        Node last = head;
        while (last.next != null) {
            last = last.next;
        }
        last.next = new_node;
        return;
    }

    // Deleting a node with a given key
    public void deleteNode(int key) {
        Node temp = head, prev = null;
        if (temp != null && temp.data == key) {
            head = temp.next;
            return;
        }
        while (temp != null && temp.data != key) {
            prev = temp;
            temp = temp.next;
        }
        if (temp == null) {
            return;
        }
        prev.next = temp.next;
    }

    // Traversing the linked list
    public void printList() {
        Node curr_node = head;
        System.out.print("Linked List: ");
        while (curr_node != null) {
            System.out.print(curr_node.data + " ");
            curr_node = curr_node.next;
        }
    }

    public static void main(String[] args) {
        LinkedList llist = new LinkedList();

        // Adding nodes to the linked list
        llist.push(7);
        llist.append(8);
        llist.insertAfter(llist.head.next, 9);
        llist.push(6);
        llist.append(10);

        // Deleting a node with a given key
        llist.deleteNode(9);

        // Traversing the linked list
        llist.printList();
    }
}
