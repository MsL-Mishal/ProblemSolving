class LinkedList {
    Node head;  // head of list

    static class Node {
        int data;   
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    public void printLinkedList() {
        Node n = head; // start from head

        if(n == null) {
            System.out.println("List is empty");
            return;
        }

        while(n != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }

        // Print a new line at the end
        System.out.println();
    }

    // Insert a new node at the beginning
    public void push(int newData) {
        Node newNode = new Node(newData); // Create a new node with the given data

        newNode.next = head; // Link the old head to the new node

        head = newNode; // Move the head to point to the new node
    }

    // Insert a new node after a given node
    public void insertAfter(Node prevNode, int newData) {
        // Check if the given previous node is null
        if(prevNode == null) {
            System.out.println("Previous node cannot be null");
            return;
        }

        Node newNode = new Node(newData);   // Create a new node with the given data

        newNode.next = prevNode.next;   // Link the new node to the next of the previous node
        prevNode.next = newNode;    // Link the previous node to the new node
    }


    // Insert a new node at the end
    public void append(int newData) {
        if(head == null) {
            System.out.println("List is empty");
            head = new Node(newData);
            return;
        }

        Node newNode = new Node(newData); // Create a new node with the given data

        Node last = head;   // Start from the head

        // Traverse the list to find the last node
        while(last.next != null) {
            last = last.next;
        }

        last.next = newNode;    // Link the last node to the new node
    }

    // Delete a node by position
    public void deleteNodeByPosition(int position) {
        if(head == null) {
            System.out.println("Linkedlist is Empty");
            return;
        }

        // If the head needs to be removed
        if(position == 0) {
            head = head.next;
            return;
        }

        // Find the previous node of the node to be deleted
        Node temp = head;

        for(int i = 0; ( temp != null ) && ( i < position - 1 ); i++) {
            temp = temp.next;
        }

        // If the position is more than the number of nodes
        if(temp == null || temp.next == null) 
            return;
        
        // Node temp now points to the previous node of the node to be deleted
        temp.next = temp.next.next; // Unlink the node from the linked list

    }

    public void deleteNodeByPointer(Node ptr) {
        // Check if the linked list is empty or the pointer is null
        if(head == null || ptr == null) {
            System.out.println("Cannot delete node");
            return;
        }

        // If the node to be deleted is the last node
        if(ptr.next == null) {
            Node temp = head;

            while(temp.next != ptr) {
                temp = temp.next;
            }

            temp.next = null;
            return;
        }

        Node nextPtr = ptr.next;
        
        // Copy the data from the next node to the current node
        ptr.data = nextPtr.data;
        ptr.next = nextPtr.next;

        return;
    }

    // Delete a node by value
    public void deleteByValue(int d) {
        Node temp = head;

        if(head == null) {
            System.out.println("Linkedlist is Empty");
            return;
        }

        // If the head node itself holds the key to be deleted
        else if(head.data == d) {
            head = head.next;
            return;
        }

        // Traverse the list till the previous node of the node to be deleted, to find the node to be deleted 
        while(temp != null && temp.data != d) {
            // If the node to be deleted is found, i.e. the next node of the current node contains the data to be deleted
            if(temp.next != null && temp.next.data == d) {
                temp.next = temp.next.next;
                return;
            }
            temp = temp.next;
        }
    }

    // Remove duplicates from a linked list
    public void removeDuplicates() {

        // We maintain two pointers, temp and traverse
        Node temp = head;   // This pointer is used to point to the last unique node
        Node traverse = head;   // This pointer is used to traverse the list
        
        if(head == null) {
            System.out.println("List is empty");
            return;
        }

        if(head.next == null) {
            System.out.println("List has only one element");
            return;
        }

        // Traverse the list till the end
        while(traverse != null) {
            
            // If the value pointed by temp is not equal to the value pointed by traverse, we add the node to the list. i.e. we add the unique node to the list and update temp to point to the new node
            if(temp.data != traverse.data) {
                temp.next = traverse;
                temp = temp.next;
            }

            // If the value pointed by temp is equal to the value pointed by traverse, we skip the duplicate node

            traverse = traverse.next;
        }

        // To handle the case when the last node is a duplicate, we set the next pointer of temp to null
        if(temp != traverse)
            temp.next = null;
    }

    // Reverse the linked list
    public void reverseLinkedList() {

        //We keep three pointers: prevPtr, currentPtr and nextPtr
        Node prevPtr = null;    
        Node nextPtr = null;    
        Node currentPtr = head; 

        // Traverse the list and reverse the links
        while(currentPtr != null) {
            nextPtr = currentPtr.next;  // Store the next node
            currentPtr.next = prevPtr;  // Reverse the link
            prevPtr = currentPtr;   // Move prevPtr to current node
            currentPtr = nextPtr;   // Move currentPtr to next node
        }

        head = prevPtr;  // Update the head to point to the new first node
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();   // Create a new linked list

        linkedList.head = new Node(1);  // Initialize the head with the first node
        Node second = new Node(2);  // Create the second node
        Node third = new Node(3);   // Create the third node

        linkedList.head.next = second;  // Link the first node to the second node
        second.next = third;    // Link the second node to the third node

        linkedList.printLinkedList();

        linkedList.push(10);
        linkedList.printLinkedList();

        linkedList.insertAfter(second, 50);
        linkedList.printLinkedList();

        linkedList.append(40);
        linkedList.printLinkedList();

        linkedList.deleteNodeByPosition(1);
        linkedList.printLinkedList();

        linkedList.deleteNodeByPointer(third);
        linkedList.printLinkedList();

        linkedList.append(100);
        linkedList.append(100);
        linkedList.append(50);
        linkedList.append(20);
        linkedList.append(15);
        linkedList.printLinkedList();

        linkedList.deleteByValue(50);
        linkedList.printLinkedList();

        linkedList.deleteByValue(15);
        linkedList.printLinkedList();

        linkedList.append(70);
        linkedList.printLinkedList();

        linkedList.append(70);
        linkedList.printLinkedList();

        linkedList.append(70);
        linkedList.printLinkedList();

        linkedList.append(65);
        linkedList.printLinkedList();

        linkedList.append(65);
        linkedList.printLinkedList();

        linkedList.removeDuplicates();
        linkedList.printLinkedList();

        linkedList.reverseLinkedList();
        linkedList.printLinkedList();
    }
}
