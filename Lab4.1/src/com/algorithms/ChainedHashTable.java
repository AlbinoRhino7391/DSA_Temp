package com.algorithms;

import java.util.LinkedList;

public class ChainedHashTable<K, V> implements HashTable<K, V> {

    private final HashProvider<K> hashProvider;
    private final LinkedList<Pair<K, V>>[] array; // array of linkedLists --> linkedList node is Values (Pair)

    public ChainedHashTable(int capacity, HashProvider<K> hashProvider) {
        //noinspection unchecked
        array = new LinkedList[capacity];  // array = new int[capacity]
        // initiating an array of likedlists
        for (int i = 0; i < capacity; i++) {
            array[i] = new LinkedList<>();
        }
        this.hashProvider = hashProvider;
    }

    public static void main(String args[]) {
        ChainedHashTable<Integer, String> chainedHashTable = new ChainedHashTable<>(10,
                new RemainderHashing());

        chainedHashTable.put(12, "Isabel");
        chainedHashTable.put(22, "Ruth");
        chainedHashTable.put(32, "Michelle");
        chainedHashTable.put(11, "James");
        chainedHashTable.put(21, "John");
        chainedHashTable.put(31, "Peter");

        System.out.println(chainedHashTable.get(12));
        System.out.println(chainedHashTable.get(22));
        System.out.println(chainedHashTable.get(32));
        System.out.println(chainedHashTable.get(11));
        chainedHashTable.remove(11);
        System.out.println(chainedHashTable.get(11));
        System.out.println(chainedHashTable.get(21));
        System.out.println(chainedHashTable.get(31));
        System.out.println(chainedHashTable.get(42));
        System.out.println(chainedHashTable.get(45));
        chainedHashTable.remove(31);
        System.out.println(chainedHashTable.get(31));
    }

    /*
     Changed back to my implementation instead of the instructors, ran multiple side by side tests to get the same output on every single test.
     The reason being:
        Both implementations perform the same essential operations and correctly add a new Pair<K, V> to the appropriate linked list at the index determined by the hash code.
        The differences are purely in the order of the operations for better understanding.
        The order of operations doesn't affect the functionality of the method.
        The implementations are effectively equivalent, and either one would work correctly.
     */
    public void put(K key, V value) {
        // 1. Get the hash code by calling the hashKey() method of the hashProvider,
        //    passing to it the key argument and the length of the array.
        //    This will return a number between 0 and the length of the array.
        int index = hashProvider.hashKey(key, array.length);

        // 2. Use the obtained index to find the appropriate linked list in the array.
        LinkedList<Pair<K, V>> list = array[index];

        // 3. Add a new Pair (key, value) to the beginning of the linked list.
        Pair<K, V> newPair = new Pair<>(key, value);
        list.addFirst(newPair);


    }



    public V get(K key) {
        // 1. If the key is null, return null
        if (key == null) {
            return null;
        }

        // 2. Get the int hash value by calling the hashKey() method of the hashProvider, passing
        //    to it the key argument and the length of the array.
        //    Because this is a remainder hash, this method will return a number between 0 and the length of the array.
        int index = hashProvider.hashKey(key, array.length);

        // 3. Get a linked list of Pair<K, V> using the hashValue as the index off the array.
        LinkedList<Pair<K, V>> list = array[index];

        // 4. For each Pair<K, V> from the list:
        for (Pair<K, V> pair : list) {
            // a. Get the key k from the Pair.
            K k = pair.getKey();

            // b. If k is equal to the value of the key parameter, return the value v from the Pair.
            if (key.equals(k)) {
                return pair.getValue();
            }
        }

        // 5. If not found, return null.
        return null;
    }


    public void remove(K key) {
        if (key == null) {
            return;
        }
        int hashValue = hashProvider.hashKey(key, array.length);
        LinkedList<Pair<K, V>> lList = array[hashValue];
        K curKey = null;
        Pair<K, V> pair = null;
        for (Pair<K, V> p : lList) {
            curKey = p.getKey();
            if (curKey.equals(key)) {
                pair = p;
                break;
            }
        }
        lList.remove(pair);
    }

}

