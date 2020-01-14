package com.waheedtechblog.string;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem Statement
 * https://www.hackerrank.com/challenges/ctci-making-anagrams/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=strings
 */
public class MakingAnagrams {

    static int makeAnagram(String a, String b, boolean debug) {

        int[] lettercounts = new int[26];

        //count each char repetitions
        for(char c : a.toCharArray()){
            lettercounts[c-'a']++;
        }

        if(debug){
            for(int num : lettercounts){
                System.out.print(num + " ");
            }
        }



        for(char c : b.toCharArray()){
            lettercounts[c-'a']--;
        }

        if(debug){
            System.out.println("");
            for(int num : lettercounts){
                System.out.print(num + " ");
            }
        }
        int result = 0;
        for(int i : lettercounts){
            result += Math.abs(i);
        }
        return result;

    }

    public static void main(String[] args) {

        String a = "fcrxzwscanmligyxyvym";

        String b = "jxwtrhvujlmrpdoqbisbwhmgpmeoke";
        boolean debug = true;

        int res = makeAnagram(a, b, true);
        System.out.println("\nMinimum items to be deleted: " + res);

    }
}
