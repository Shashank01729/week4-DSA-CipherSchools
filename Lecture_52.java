class Node {
    int data;
    Node prev;
    Node next;

    public Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

public class Lecture_52 {
    Node head;
    Node tail;

    public Lecture_52() {
        this.head = null;
        this.tail = null;
    }

    // Method to insert a new node at the end of the list
    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    // Method to display the linked list in forward direction
    public void displayForward() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Method to display the linked list in reverse direction
    public void displayBackward() {
        Node current = tail;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.prev;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Lecture_52 list = new Lecture_52();

        // Inserting elements into the doubly linked list
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);

        // Displaying the doubly linked list in forward direction
        System.out.println("Doubly Linked List (Forward):");
        list.displayForward();

        // Displaying the doubly linked list in reverse direction
        System.out.println("Doubly Linked List (Backward):");
        list.displayBackward();
    }
}
