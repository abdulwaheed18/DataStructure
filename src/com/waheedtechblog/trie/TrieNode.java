package com.waheedtechblog.trie;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
    Map<Character,TrieNode> trieNodeMap = new HashMap<>();
    boolean isLeaf = false;
    //using this for special case// TrieNode problem
    int size = 0;
}
