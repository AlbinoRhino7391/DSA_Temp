package com.algorithms;

import static org.junit.jupiter.api.Assertions.*;

class SinglyLinkedListTest {

    @org.junit.jupiter.api.Test
    void addInPosition() {
        // Test case 1: Insert at the beginning (index = 0)
        SinglyLinkedList<Card> cardList = new SinglyLinkedList<>();
        Card card1 = new Card("Ace", "Hearts");
        Card card2 = new Card("King", "Spades");
        cardList.addFront(card1);
        cardList.addFront(card2);

        assertEquals(card2, cardList.getHead().getValue(), "The first card should be the added card2.");

        // Test case 2: Insert in the middle (index = 1)
        Card card3 = new Card("Queen", "Diamonds");
        cardList.addInPosition(card3, 1);

        assertEquals(card3, cardList.getHead().getNext().getValue(), "The second card should be the added card3.");
        assertEquals(card1, cardList.getHead().getNext().getNext().getValue(), "The third card should be the added card1.");
    }

    @org.junit.jupiter.api.Test
    void addFront() {
        SinglyLinkedList<Card> cardList = new SinglyLinkedList<>();
        Card card1 = new Card("Ace", "Hearts");
        cardList.addFront(card1);

        assertEquals(card1, cardList.getHead().getValue(), "The first card should be the added card1.");

        Card card2 = new Card("King", "Spades");
        cardList.addFront(card2);

        assertEquals(card2, cardList.getHead().getValue(), "The first card should be the added card2.");
    }

    @org.junit.jupiter.api.Test
    void appendToList() {
        SinglyLinkedList<Card> cardList = new SinglyLinkedList<>();
        Card card1 = new Card("Ace", "Hearts");
        cardList.appendToList(card1);

        assertEquals(card1, cardList.getHead().getValue(), "The first card should be the added card1.");

        Card card2 = new Card("King", "Spades");
        cardList.appendToList(card2);

        assertEquals(card1, cardList.getHead().getValue(), "The first card should still be card1 after adding card2.");
        assertEquals(card2, cardList.getHead().getNext().getValue(), "The second card should be the added card2.");
    }

    @org.junit.jupiter.api.Test
    void deleteFront() {
        SinglyLinkedList<Card> cardList = new SinglyLinkedList<>();
        Card card1 = new Card("Ace", "Hearts");
        Card card2 = new Card("King", "Spades");
        cardList.addFront(card1);
        cardList.addFront(card2);

        assertEquals(card2, cardList.getHead().getValue(), "The first card should be card2.");

        cardList.deleteFront();

        assertEquals(card1, cardList.getHead().getValue(), "After deleting the front, the first card should be card1.");
    }

    @org.junit.jupiter.api.Test
    void reverse() {
        SinglyLinkedList<Card> cardList = new SinglyLinkedList<>();
        Card card1 = new Card("Ace", "Hearts");
        Card card2 = new Card("King", "Spades");
        Card card3 = new Card("Queen", "Diamonds");
        cardList.addFront(card1);
        cardList.addFront(card2);
        cardList.appendToList(card3);

        assertEquals(card2, cardList.getHead().getValue(), "The first card should be card2 before reversing.");

        cardList.reverse();

        assertEquals(card3, cardList.getHead().getValue(), "After reversing, the first card should be card3.");
    }

    @org.junit.jupiter.api.Test
    void traverseList() {
        SinglyLinkedList<Card> cardList = new SinglyLinkedList<>();
        Card card1 = new Card("Ace", "Hearts");
        Card card2 = new Card("King", "Spades");
        Card card3 = new Card("Queen", "Diamonds");
        cardList.addFront(card1);
        cardList.addFront(card2);
        cardList.appendToList(card3);

        int count = cardList.traverseList(true);

        assertEquals(3, count, "The number of cards in the linked list should be 3.");
    }

    @org.junit.jupiter.api.Test
    void getHead() {
        SinglyLinkedList<Card> cardList = new SinglyLinkedList<>();
        Card card1 = new Card("Ace", "Hearts");
        Card card2 = new Card("King", "Spades");
        cardList.addFront(card1);
        cardList.addFront(card2);

        assertEquals(card2, cardList.getHead().getValue(), "The first card should be card2.");
    }

}

class Card {
    private String rank;
    private String suit;

    public Card(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }
}
