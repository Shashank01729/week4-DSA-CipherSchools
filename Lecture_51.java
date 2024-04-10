class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class Lecture_51 {

    // Method to detect and remove a loop in the linked list
    public static void removeLoop(Node head) {
        if (head == null || head.next == null)
            return;

        Node slow = head;
        Node fast = head;

        // Move slow and fast pointers until they meet or fast reaches the end
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            // Loop detected, break the loop
            if (slow == fast) {
                removeLoopAtNode(head, slow);
                return;
            }
        }
    }

    // Method to remove the loop at the given node
    public static void removeLoopAtNode(Node head, Node loopNode) {
        Node ptr1 = head;
        Node ptr2;

        // Move ptr1 and ptr2 with same speed until they meet at the node where loop starts
        while (true) {
            ptr2 = loopNode;
            while (ptr2.next != loopNode && ptr2.next != ptr1) {
                ptr2 = ptr2.next;
            }

            if (ptr2.next == ptr1) {
                break;
            }

            ptr1 = ptr1.next;
        }

        // Set the next pointer of the node where loop is detected to null
        ptr2.next = null;
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
