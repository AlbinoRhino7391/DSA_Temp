package com.algorithms;

public class SinglyLinkedList<T> { // Modify to use generics, instead of int.

    private LinkedListNode<T> head; // Modify to use generics, instead of int.

    // Add a new node with the given item at the front of the linked list
    public void addFront(T item) { // Modify to use generics, instead of int.
        // 1. Create a new node with the given item and set its next node to the current head
        LinkedListNode<T> newNode = new LinkedListNode<>(item, head); // Modify to use generics, instead of int.
        // 2. Set the new node as the head of the linked list
        head = newNode;
    }

    // Append a new node with the given item to the end of the linked list
    public void appendToList(T item) { // Modify to use generics, instead of int.
        // 1. If the linked list is empty, add the item as the head
        if (head == null) {
            head = new LinkedListNode<>(item, null); // Modify to use generics, instead of int.
        } else {
            // 2. Find the last node in the linked list
            LinkedListNode<T> curNode = head; // Modify to use generics, instead of int.
            while (curNode.getNext() != null) {
                curNode = curNode.getNext();
            }
            // 3. Create a new node with the given item and set it as the next node of the last node
            curNode.setNext(new LinkedListNode<>(item, null)); // Modify to use generics, instead of int.
        }
    }

    // Delete the node at the front of the linked list
    public void deleteFront() {
        // 1. If the linked list is not empty
        if (head != null) {
            // 2. Move the head to the next node to delete the current head node
            head = head.getNext();
        }
    }

    // Reverse the linked list
    public void reverse() {
        // 1. Call the helper method to reverse the linked list starting from the head
        head = reverse(head);
    }

    // Helper method to reverse the linked list starting from the given node
    private LinkedListNode<T> reverse(LinkedListNode<T> node) { // Modify to use generics, instead of int.
        LinkedListNode<T> prev = null; // Modify to use generics, instead of int.
        LinkedListNode<T> current = node; // Modify to use generics, instead of int.
        LinkedListNode<T> next;

        // 2. Traverse the linked list
        while (current != null) {
            // 3. Store the next node in the next variable
            next = current.getNext();
            // 4. Reverse the pointer of the current node to the previous node
            current.setNext(prev);
            // 5. Move to the next nodes for the next iteration
            prev = current;
            current = next;
        }

        // 6. Return the new head (last node in the original list) as the head of the reversed list
        return prev;
    }

    // Traverse the linked list and print its nodes (if print is true)
    // Return the number of nodes in the linked list
    public int traverseList(boolean print) {
        int count = 0;
        LinkedListNode<T> curNode = head; // Modify to use generics, instead of int.
        // 1. Traverse the linked list
        while (curNode != null) {
            // 2. If print is true, print the current node
            if (print) {
                System.out.println(curNode);
            }
            // 3. Move to the next node
            curNode = curNode.getNext();
            // 4. Increment the count of nodes
            count++;
        }
        // 5. Return the total number of nodes in the linked list
        return count;
    }

    // Return the head of the linked list
    public LinkedListNode<T> getHead() { // Modify to use generics, instead of int.
        return head;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        LinkedListNode<T> cur = head; // Modify to use generics, instead of int.
        // Traverse the linked list
        while (cur != null) {
            // Append the current node's value to the string
            builder.append(cur);
            builder.append("\n");
            // Move to the next node
            cur = cur.getNext();
        }
        // Return the final string representation of the linked list
        return builder.toString();
    }
}


