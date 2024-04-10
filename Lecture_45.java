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

    // Method to find the nth node from the end of the linked list
    public int findNthFromEnd(int n) {
        if (head == null || n <= 0) {
            return -1; // Return -1 if the list is empty or n is invalid
        }

        Node slow = head;
        Node fast = head;

        // Move the fast pointer n nodes ahead
        for (int i = 0; i < n; i++) {
            if (fast == null) {
                return -1; // Return -1 if n is greater than the number of nodes
            }
            fast = fast.next;
        }

        // Move both pointers until the fast pointer reaches the end
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // The slow pointer will be at the nth node from the end
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

public class Lecture_45 {
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

        // Finding the nth node from the end of the linked list
        int n = 2;
        int nthFromEnd = list.findNthFromEnd(n);
        if (nthFromEnd != -1) {
            System.out.println("The " + n + "th node from the end is: " + nthFromEnd);
        } else {
            System.out.println("Invalid input or node not found.");
        }
    }
}
