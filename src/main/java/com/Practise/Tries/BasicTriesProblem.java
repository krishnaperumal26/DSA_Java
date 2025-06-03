package com.Practise.Tries;

import java.util.HashMap;

/**
 * A class to demonstrate basic operations on a Trie data structure.
 * The Trie is used to store and search words efficiently.
 */
public class BasicTriesProblem {
    public static void main(String[] args) {
        // List of words to insert into the Trie
        String[] words = {"hello", "world", "hi", "her", "hero", "data", "dat", "database"};
        Node root = new Node(); // Root node of the Trie

        // Insert each word into the Trie
        for (String word : words) {
            Node s = root;
            insert(word, s);
        }

        // Search for words in the Trie and print the results
        System.out.println("Data : " + search("data", root)); // Should return true
        System.out.println("Dat : " + search("dat", root)); // Should return true
        System.out.println("Da : " + search("da", root)); // Should return false
        System.out.println("Database : " + search("database", root)); // Should return true
    }

    /**
     * Inserts a word into the Trie.
     *
     * @param word The word to insert.
     * @param s The current node in the Trie.
     */
    static void insert(String word, Node s) {
        // Iterate through each character in the word
        for (char c : word.toCharArray()) {
            // If the character is not present, create a new node
            if (!s.hm.containsKey(c)) {
                Node newNode = new Node();
                s.hm.put(c, newNode);
            }
            // Move to the next node
            s = s.hm.get(c);
        }
        s.isEnd = true; // Mark the end of the word
    }

    /**
     * Searches for a word in the Trie.
     *
     * @param word The word to search for.
     * @param s The current node in the Trie.
     * @return True if the word exists in the Trie, false otherwise.
     */
    static boolean search(String word, Node s) {
        // Iterate through each character in the word
        for (char c : word.toCharArray()) {
            // If the character is not found, return false
            if (!s.hm.containsKey(c)) {
                return false;
            }
            // Move to the next node
            s = s.hm.get(c);
        }
        return s.isEnd; // Return true if we reached the end of the word
    }

    /**
     * A class representing a node in the Trie.
     * Each node contains a flag to indicate the end of a word and a map of child nodes.
     */
    static class Node {
        boolean isEnd; // Flag to indicate the end of a word
        HashMap<Character, Node> hm; // Map to store child nodes

        /**
         * Constructor to initialize a Trie node.
         */
        Node() {
            this.isEnd = false; // Default value for the end flag
            this.hm = new HashMap<>(); // Initialize the map of child nodes
        }
    }
}