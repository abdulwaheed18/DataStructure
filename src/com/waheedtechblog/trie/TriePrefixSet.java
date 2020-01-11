package com.waheedtechblog.trie;

/**
 * Problem Statment can be read over here
 */
public class TriePrefixSet {

    public static void main(String[] args) {
        TriePrefixSet triePrefixSet = new TriePrefixSet();
      //  triePrefixSet.add("aab");
      //  triePrefixSet.add("defgab");
      //  triePrefixSet.add("abcde");
      //  triePrefixSet.add("aabcde");

        triePrefixSet.add("waheed");
        triePrefixSet.add("wah");
      //  triePrefixSet.add("aacghgh");
       // triePrefixSet.add("aabghgh");
    }


    private TrieNode root;

    TriePrefixSet() {
        root = new TrieNode();
    }

    public boolean add(String key) {
        //start from the root trie
        TrieNode curr = root;
        boolean isAddRequired = false;
        for (char ch : key.toCharArray()) {
            //add if not exist
           TrieNode temp =  curr.trieNodeMap.putIfAbsent(ch, new TrieNode());
            if(isAddRequired == false && temp == null){
                isAddRequired = true;
            }
            curr = curr.trieNodeMap.get(ch);
            if(curr.isLeaf == true){
                System.out.println("BAD SET");
                System.out.println(key);
             return false;
            }
        }
        curr.isLeaf = true;
        if(!isAddRequired){
            System.out.println("BAD SET");
            System.out.println(key);
            return false;
        }
        return true;
    }
}
