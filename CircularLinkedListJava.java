public class CircularLinkedListJava {
    /* A Circular Linked List is a linked list where all nodes are connected in a circular fashion. We'll be using only a single pointer to the last node of the list to traverse it. The last node points to the first node, making it circular. This makes it easier to traverse the list without needing a head pointer. Also, it makes adding element at the end of the list and adding element at the beginning of the list easier and taking only constant time. This makes it suitable for implementing data structures like queues and stacks. And this can also be used for implementing a circular queue. */

    // Node class to represent each node in the Circular linked list
    public static class Node {
        int data;
        Node next;
    }

    // Function to insert a node in a Circular linked list at the beginning
    public static Node addToEmpty(Node last, int data) {
        if(last == null) {
            Node newNode = new Node();
            newNode.data = data;

            newNode.next = newNode; // Pointing to itself
            last = newNode; // This is the only node in the list
        }

        return last;
    }

    // Function to insert a node in a Circular linked list at the beginning
    public static Node addBegin(Node last, int data) {
        if(last == null) {
            return addToEmpty(last, data);
        }

        Node newNode = new Node();
        newNode.data = data;

        newNode.next = last.next;   // Pointing to the first node
        last.next = newNode;    // Last node points to the new node

        return last;
    }

    // Function to insert a node in a Circular linked list at the end
    public static Node addEnd(Node last, int data) {
        if(last == null) {
            return addToEmpty(last, data);
        }

        Node newNode = new Node();
        newNode.data = data;

       newNode.next = last.next;    // Pointing to the first node
       last.next = newNode; // Current last node points to the new node
       last = newNode;  // Update last to point to the new node 

        return last;
    }

    // Function to insert a node in a Circular linked list after a given node
    public static Node addAfter(Node last, int data, int item) {
        if(last == null) {
            System.out.println("List is Empty & hence, item " + item + " was not found");

            return last;
        }

        Node temp = last;   // Start from the last node
        
        // Traverse the list to find the node after which we want to insert the new node
        while(temp.next != last) {
            // Check if the current node's data matches the item
            if(temp.data == item) {
                Node newNode = new Node();
                newNode.data = data;

                // Point the new node to the next node of the current node
                newNode.next = temp.next;
                // Point the current node to the new node
                temp.next = newNode;

                // Update the last node if the new node is inserted after the last node
                if(last == temp)
                    last = newNode;

                return last;
            }

            temp = temp.next;
        }

        // If we didn't find the item in the list, print a message
        System.out.println(item + " was not found. Hence, data was not inserted");

        return last;
    }

    // Function to traverse the Circular linked list
    public static void traverse(Node last) {
        if(last == null) {
            System.out.println("List is Empty");
            return;
        }

        // Since, we initialize the traversing pointer with the last node, `traverse.next` will point to the first node. So, that's our starting point.
        Node traverse = last;

        do {
            // Print the data of the current node
            System.out.print(traverse.next.data + " ");
            traverse = traverse.next;
        }while(traverse != last);   // Loop until we reach the last node again

        System.out.println();   // Print a new line for better readability
    }

    public static void main(String[] args) {
        Node last = null;

        last = addToEmpty(last, 10);
        traverse(last);

        last = addBegin(last, 20);
        traverse(last);

        last = addBegin(last, 30);
        traverse(last);

        last = addBegin(last, 40);
        traverse(last);

        last = addEnd(last, 50);
        traverse(last);

        last = addEnd(last, 60);
        traverse(last);

        last = addEnd(last, 70);
        traverse(last);

        last = addAfter(last, 55, 50);
        traverse(last);

        last = addAfter(last, 55, 45);
        traverse(last);
    }
}
