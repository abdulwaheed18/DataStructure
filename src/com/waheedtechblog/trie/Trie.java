package com.waheedtechblog.trie;

public class Trie {

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.add("abdul");
        trie.add("waheed");
        trie.add("hack");
        trie.add("hackerrank");
        System.out.println("Is Abs present: " + trie.search("abs"));
        System.out.println("Is Abdul present: " + trie.search("abdul"));
        System.out.println("Num of times subString present: " + trie.startsWith("zab"));
        System.out.println("Num of times subString present: " + trie.startsWith("hac"));
    }

    private TrieNode root;

    Trie() {
        root = new TrieNode();
    }

    public void add(String key) {
        //start from the root trie
        TrieNode curr = root;
        for (char ch : key.toCharArray()) {
            //add if not exist
            curr.trieNodeMap.putIfAbsent(ch, new TrieNode());
            curr = curr.trieNodeMap.get(ch);
            curr.size++;
        }
        //Once done with all char, mark last node leaf as true;
        curr.isLeaf = true;
    }

    public boolean search(String key) {
        TrieNode curr = root;
        for (char ch : key.toCharArray()) {
            curr = curr.trieNodeMap.get(ch);
            if (curr == null) {
                return false;
            }
        }
        return curr.isLeaf;
    }

    /**
     * returns num of times key present in String
     * Problem Statement: https://www.hackerrank.com/challenges/contacts/problem
     *
     * @param key Partial String to be Searched
     * @return number of times key present in total String
     */
    public int startsWith(String key) {
        int count = 0;
        TrieNode curr = root;
        for (char ch : key.toCharArray()) {
            curr = curr.trieNodeMap.get(ch);
            if (curr == null) {
                return 0;
            }
        }
        return curr.size;
    }
}

/***
 * Output:
 Is Abs present: false
 Is Abdul present: true
 Num of times subString present: 0
 Num of times subString present: 2
 */
