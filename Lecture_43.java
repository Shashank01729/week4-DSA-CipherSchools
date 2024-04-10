class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;

    public LinkedList() {
        this.head = null;
    }

    // Method to insert a new node at the end of the list
    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // Method to delete a node with a given value
    public void delete(int value) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (head.data == value) {
            head = head.next;
            return;
        }

        Node prev = null;
        Node current = head;

        while (current != null && current.data != value) {
            prev = current;
            current = current.next;
        }

        if (current == null) {
            System.out.println("Element not found in the list");
            return;
        }

        prev.next = current.next;
    }

    // Method to display the linked list
    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}

public class Lecture_43 {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        // Inserting elements into the linked list
        list.insert(1);
        list.insert(2);
        list.insert(3);

        // Displaying the linked list
        System.out.println("Linked List:");
        list.display();

        // Deleting an element from the linked list
        list.delete(2);

        // Displaying the linked list after deletion
        System.out.println("Linked List after deletion:");
        list.display();
    }
}
