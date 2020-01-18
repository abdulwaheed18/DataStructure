package com.waheedtechblog.string;

/**
 * Reverse word in a given string
 *
 * Problem Statement
 * https://www.geeksforgeeks.org/reverse-words-in-a-given-string/
 */
public class ReverseWord {
    public static void main(String[] args) {

        String s = "getting good at coding needs a lot of practice";
        System.out.println("Input String: " + s);
        System.out.print("Reverse String: ");
        reverseWord(s);
    }

    static void reverseWord(String s){

        String[] words  = s.split(" ");
        for(int i = words.length - 1; i>=0;i--){
            System.out.print(words[i].trim() + " ");
        }
    }
}

/**
 * Output:
 * Input String: getting good at coding needs a lot of practice
 * Reverse String: practice of lot a needs coding at good getting
  */
