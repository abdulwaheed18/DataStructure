package com.waheedtechblog.algorithm;

/**
 * the super digit of  will be calculated as:
 * <p>
 * super_digit(9875)   	9+8+7+5 = 29
 * super_digit(29) 	2 + 9 = 11
 * super_digit(11)		1 + 1 = 2
 * super_digit(2)		= 2
 */
public class SuperDigit {

    public static void main(String[] args) {
        String n = "9875";
        int k = 4;
        System.out.println(superDigit(n, k));
    }

    static int superDigit(String n, int k) {
        String superString = "";
        for (int i = 0; i < k; i++) {
            superString = superString + n;
        }
        int superDigit = 0;
        while (superString.length() > 1) {
            int sum = 0;
            for (char ch : superString.toCharArray()) {
                sum = sum + Character.getNumericValue(ch);
            }
            superString = String.valueOf(sum);
        }
        return Integer.parseInt(superString);
    }

    /**
     * Get super digit in more effective way
     *
     * @param n
     * @param k
     * @return
     */
    static int superDigitUtil2(String n, int k) {
        boolean isMul = false;
        while (n.length() > 1) {
            int superDigit = 0;
            for (char ch : n.toCharArray()) {
                superDigit = superDigit + Character.getNumericValue(ch);
            }
            n = String.valueOf(superDigit);
            if (n.length() == 1 && !isMul) {
                superDigit = superDigit * k;
                isMul = true;
            }
            n = String.valueOf(superDigit);
        }
        return Integer.parseInt(n);
    }
}

/**
 * 8
 */
