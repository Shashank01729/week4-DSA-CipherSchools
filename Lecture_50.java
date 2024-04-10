import java.util.HashSet;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class Lecture_50 {

    // Method to detect and remove a loop in the linked list
    public static void removeLoop(Node head) {
        if (head == null || head.next == null)
            return;

        HashSet<Node> visitedNodes = new HashSet<>();
        Node prev = null;
        Node current = head;

        while (current != null) {
            if (visitedNodes.contains(current)) {
                // Loop detected, break the loop
                prev.next = null;
                break;
            }

            visitedNodes.add(current);
            prev = current;
            current = current.next;
        }
    }

    public static void main(String[] args) {
        // Construct a linked list with a loop
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = head.next; // Creating a loop

        // Remove loop in the linked list
        removeLoop(head);

        // Detect loop in the linked list after removal
        boolean hasLoop = hasLoop(head);

        // Display the result
        if (hasLoop) {
            System.out.println("Loop detected in the linked list after removal.");
        } else {
            System.out.println("No loop detected in the linked list after removal.");
        }
    }

    // Method to detect a loop in the linked list
    public static boolean hasLoop(Node head) {
        if (head == null || head.next == null)
            return false;

        HashSet<Node> visitedNodes = new HashSet<>();
        Node current = head;

        while (current != null) {
            if (visitedNodes.contains(current))
                return true; // Loop detected

            visitedNodes.add(current);
            current = current.next;
        }

        return false; // No loop detected
    }
}
