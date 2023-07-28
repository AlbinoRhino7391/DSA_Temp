package com.algorithms;


public class Stack<V> {

    private LinkedListNode<V> head;

    public void push(V item) {

        // Create a new node with the provided item as its value
        LinkedListNode<V> newNode = new LinkedListNode<>(item, null);

        // If the stack is empty, set the head to the new node
        // Otherwise, set the "next" of the new node to the current head
        // and update the head to point to the new node
        if (head == null) {
            head = newNode;
        } else {
            newNode.setNext(head);
            head = newNode;
        }
    }


    public V pop() {
        // If the stack is empty (head is null), return null
        if (head == null) {
            return null;
        }

        // Get the value of the node at the head
        V value = head.getValue();

        // Update the head to point to the next node in the stack
        head = head.getNext();

        // Return the value obtained in the previous step
        return value;
    }

    public static void main(String[] args) {
        // Test the Stack implementation
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack.pop()); // Output: 3
        System.out.println(stack.pop()); // Output: 2
        System.out.println(stack.pop()); // Output: 1
        System.out.println(stack.pop()); // Output: null (stack is empty)
    }

}
