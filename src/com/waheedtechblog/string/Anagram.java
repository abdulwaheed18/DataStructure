package com.waheedtechblog.string;

import java.util.Arrays;

/**
 * Check if two String are Anagram
 */
public class Anagram {
    public static void main(String[] args) {

        Anagram anagram = new Anagram();

        // String is never not empty
        String first = "aabbccdd";
        String second = "abcdabcd";

        System.out.println("===========Using first Method==========");
        if(anagram.isAnagram1(first,second))
            System.out.println("String is Anagram");
        else
            System.out.println("String is not Anagram");

        System.out.println("\n===========Using Second Method==========");
        if(anagram.isAnagram2(first.toCharArray(),second.toCharArray()))
            System.out.println("String is Anagram");
        else
            System.out.println("String is not Anagram");

        System.out.println("\n===========Using third Method==========");
        if(anagram.isAnagram3(first.toCharArray(),second.toCharArray()))
            System.out.println("String is Anagram");
        else
            System.out.println("String is not Anagram");

    }

    /**
     * Time Complexity O(nLogn)
     * @param first
     * @param second
     * @return
     */
    public boolean isAnagram1(String first, String second){
        if(first.length() != second.length())
            return false;
        char[] fir = first.toCharArray();
        char[] sec = second.toCharArray();
        Arrays.sort(fir);
        Arrays.sort(sec);
        //Arrays.equals(fir,sec);
        for (int i = 0; i < fir.length; i++) {
            if(fir[i] != sec[i])
                return false;
        }
        return true;
    }

    public boolean isAnagram2(char[] first, char[] second){
        if(first.length != second.length)
            return false;
        int[] fir = new int[256];
        int[] sec = new int[256];
        Arrays.fill(fir, 0);
        Arrays.fill(sec, 0);

        for (int i = 0; i < first.length;i++) {
            fir[first[i]]++;
            sec[second[i]]++;
        }
        for(int i = 0; i < first.length;i++ ){
            if(fir[i] != sec[i])
                return false;
        }
        return true;
    }

    public boolean isAnagram3(char[] first, char[] second){
        if(first.length != second.length)
            return false;
        int[] arr = new int[256];
        Arrays.fill(arr, 0);

        for (int i = 0; i < first.length;i++) {
            arr[first[i]]++;
            arr[second[i]]--;
        }
        for(int i = 0; i < first.length;i++ ){
            if(arr[i] !=0)
                return false;
        }
        return true;
    }

}

/*
===========Using first Method==========
String is Anagram

===========Using Second Method==========
String is Anagram

===========Using third Method==========
String is Anagram

 */
