package com.waheedtechblog.string;

/**
 * Problem Statement:
 * https://www.hackerrank.com/challenges/alternating-characters/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=strings
 */
public class AlternatingCharacters {

    static int alternatingCharacters(String s) {
        int count = 0;
        for(int i=1; i<s.length();){
            int j=i;
            while( j<s.length() && i<s.length() && s.charAt(i-1)==s.charAt(j)){
                count++;
                j++;
            }
            if(j!=i){
                i=j+1;
            } else {
                i++;
            }
        }
        return count;


    }


    public static void main(String[] args) {

        int result = alternatingCharacters("AAABBB");
        System.out.println("minimum : " + result);

    }
}
