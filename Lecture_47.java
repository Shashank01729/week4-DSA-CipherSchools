class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class Lecture_47 {

    // Method to find the intersection point of two Y-shaped linked lists
    public static Node findIntersection(Node head1, Node head2) {
        if (head1 == null || head2 == null)
            return null;

        int len1 = length(head1);
        int len2 = length(head2);

        int diff = Math.abs(len1 - len2);

        Node current1 = head1;
        Node current2 = head2;

        // Move current1 to a position where the lengths of both lists are same
        for (int i = 0; i < diff; i++) {
            if (len1 > len2)
                current1 = current1.next;
            else
                current2 = current2.next;
        }

        // Move both pointers until they meet or reach the end
        while (current1 != null && current2 != null) {
            if (current1 == current2)
                return current1; // Intersection point found

            current1 = current1.next;
            current2 = current2.next;
        }

        return null; // No intersection point found
    }

    // Method to calculate the length of a linked list
    public static int length(Node head) {
        int length = 0;
        Node current = head;
        while (current != null) {
            length++;
            current = current.next;
        }
        return length;
    }

    public static void main(String[] args) {
        // Construct the Y-shaped linked lists
        Node intersectNode = new Node(7);
        intersectNode.next = new Node(8);
        intersectNode.next.next = new Node(9);

        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = intersectNode;

        Node head2 = new Node(4);
        head2.next = new Node(5);
        head2.next.next = intersectNode;

        // Find the intersection point
        Node intersection = findIntersection(head1, head2);

        // Display the intersection point if found
        if (intersection != null) {
            System.out.println("Intersection point data: " + intersection.data);
        } else {
            System.out.println("No intersection point found.");
        }
    }
}
