class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class Lecture_48 {

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

    public static void main(String[] args) {
        // Construct a linked list with a loop
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = head.next; // Creating a loop

        // Detect loop in the linked list
        boolean hasLoop = hasLoop(head);

        // Display the result
        if (hasLoop) {
            System.out.println("Loop detected in the linked list.");
        } else {
            System.out.println("No loop detected in the linked list.");
        }
    }
}
