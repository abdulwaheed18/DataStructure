package com.waheedtechblog.string;

public class EncodeString {

    public static void main(String[] args) {
        String message = "aaaaabbbbbbbbccccaaa";
        String encoded = getEncodedString(message);
        System.out.println("Encoded String: " + encoded);

    }

    public static String getEncodedString(String message) {
        StringBuilder builder = new StringBuilder();
        int count = 0;
        char prev = 0;
        for (char ch : message.toCharArray()) {
            // Initialization
            if (count == 0) {
                prev = ch;
                builder.append(ch);
                count++;

            } else if (prev == ch) {
                count++;
            } else {
                builder.append(count);
                builder.append(ch);
                prev = ch;
                count = 1;
            }
        }
        if (count != 0) {
            builder.append(count);
        }
        return builder.toString();
    }
}

/**
 * Encoded String: a5b8c4a3
 */
