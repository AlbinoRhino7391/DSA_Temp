package com.algorithms;

public class Queue<V> {

    // DblLinkedListNode is provided
    // create a private Node for "head"
    // create a private Node for "tail"
    private DblLinkedListNode<V> head;
    private DblLinkedListNode<V> tail;

    public Queue() {
        head = null;
        tail = null;
    }

    public static void main(String[] args) {
        Queue<String> q = new Queue<>();
        q.enqueue("one");
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        q.enqueue("one");
        q.enqueue("two");
        q.enqueue("three");
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        q.enqueue("two");
        q.enqueue("three");
        System.out.println("2 values added to queue");
        System.out.println("Now try to remove both values");
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println("\nAll values removed, try to remove another");
        System.out.println(q.dequeue());
        System.out.println("\nQueue should be empty now, add a new item");
        q.enqueue("four");
        System.out.println("\nNow remove the one item");
        System.out.println(q.dequeue());
        System.out.println("\nAll items should be gone, try to remove one");
        System.out.println(q.dequeue());

    }

    public void enqueue(V item) {
        /*Create a new node with the provided item as its value.
                If the queue is empty, set both head and tail to the new node.
                Otherwise, set the next of the current tail to the new node, and set the previous of the new node to the current tail.
        Update the tail to point to the new node.
         */
        // Create a new node with the provided item as its value
        DblLinkedListNode<V> newNode = new DblLinkedListNode<>(item, null, null);

        // If the queue is empty, set both head and tail to the new node
        if (head == null) {
            head = newNode;
        } else {
            // Set the next of the current tail to the new node, and the previous of the new node to the current tail
            tail.setNext(newNode);
            newNode.setPrevious(tail);

            // Update the tail to point to the new node
        }
        tail = newNode;
    }

    public V dequeue() {
        /*
        If the queue is empty (head is null), return null.
        Otherwise, get the value of the node at the head.
        If the head has a next node, update the head to point to the next node and set the previous of the new head to null.
        If the head does not have a next node (i.e., it is the last node in the queue), set both head and tail to null (empty queue).
        Return the value obtained in step 2.
         */
        // If the queue is empty, return null
        if (head == null) {
            return null;
        }

        // Get the value of the node at the head
        V value = head.getValue();

        // If the head has a next node, update the head to point to the next node and set the previous of the new head to null
        if (head.getNext() != null) {
            head = head.getNext();
            head.setPrevious(null);
        } else {
            // If the head is the last node (i.e., it is the only node in the queue), set both head and tail to null
            head = null;
            tail = null;
        }

        // Return the value obtained in step 2
        return value;
    }
}
