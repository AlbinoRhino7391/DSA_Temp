package com.algorithms;

public class LinkedListNode<T> { // Modify to use generics, instead of int.

    private T value; // Data member of the node
    private LinkedListNode<T> next; // Self-referential pointer

    public LinkedListNode(T value, LinkedListNode<T> next) {
        this.value = value;
        this.next = next;
    }

    public LinkedListNode<T> getNext() {
        return next;
    }

    public void setNext(LinkedListNode<T> next) {
        this.next = next;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "LinkedListNode{" +
                "value=" + value +
                '}';
    }
}

