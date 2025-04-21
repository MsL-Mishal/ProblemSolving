public class CircularLinkedList {
    /* A Circular Linked List is a linked list where all nodes are connected in a circular fashion. We'll be using only a single pointer to the last node of the list to traverse it. The last node points to the first node, making it circular. This makes it easier to traverse the list without needing a head pointer. Also, it makes adding element at the end of the list and adding element at the beginning of the list easier and taking only constant time. This makes it suitable for implementing data structures like queues and stacks. And this can also be used for implementing a circular queue. */
    
    // Node class to represent each node in the Circular linked list
    static class Node {
        int data;
        Node next;
    }

    // Function to insert a node in a Circular linked list at the end
    static Node addEnd(Node last, int d) {
        // If the list is empty, create a new node and point it to itself
        if(last == null) {
            Node newNode = new Node();
            newNode.data = d;

            last = newNode;
            last.next = last;

            return last;
        }

        // If the list is not empty, create a new node and insert it at the end
        Node newNode = new Node();
        newNode.data = d;

        newNode.next = last.next;
        last.next = newNode;
        last = newNode;

        return last;
    }

    // Function to traverse the Circular linked list
    static void traverse(Node last) {
        if(last == null) {
            System.out.println("List is Empty");
            return;
        }

        Node temp = last;

        do {
            System.out.print(temp.next.data + " ");
            temp = temp.next;
        }while(temp != last);

        System.out.println();
    }

    public static void main(String[] args) {
        Node last = null;

        last = addEnd(last, 10);
        last = addEnd(last, 20);
        last = addEnd(last, 30);
        last = addEnd(last, 40);
        last = addEnd(last, 50);
        last = addEnd(last, 60);

        traverse(last);
    }
}
