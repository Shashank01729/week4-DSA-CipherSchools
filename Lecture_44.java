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

    // Method to find the middle element of the linked list
    public int findMiddle() {
        if (head == null) {
            return -1; // Return -1 if the list is empty
        }

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow.data;
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

public class Lecture_44 {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        // Inserting elements into the linked list
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);

        // Displaying the linked list
        System.out.println("Linked List:");
        list.display();

        // Finding the middle element of the linked list
        int middle = list.findMiddle();
        System.out.println("Middle element: " + middle);
    }
}
