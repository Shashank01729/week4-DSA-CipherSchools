class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class Lecture_49 {

    // Method to detect and remove a loop in the linked list
    public static void removeLoop(Node head) {
        if (head == null || head.next == null)
            return;

        Node slow = head;
        Node fast = head;

        // Detect the loop using Floyd's Cycle Detection Algorithm
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast)
                break; // Loop detected
        }

        // If loop exists, find the starting point of the loop
        if (slow == fast) {
            slow = head;
            while (slow.next != fast.next) {
                slow = slow.next;
                fast = fast.next;
            }

            // Break the loop
            fast.next = null;
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

        Node slow = head;
        Node fast = head.next;

        // Move slow and fast pointers until they meet or fast reaches the end
        while (fast != null && fast.next != null) {
            if (slow == fast)
                return true; // Loop detected

            slow = slow.next;
            fast = fast.next.next;
        }

        return false; // No loop detected
    }
}
