package com.waheedtechblog.dynamicprogramming;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * Java Program to get Fibonacci Series using DivideAndConquer, Top Down and
 * Bottom up approach.
 *
 * @author AbdulWaheed18@gmail.com
 */
public class FibonacciSeries {

    public static void main(String[] args) {
        FibonacciSeries fibonacciSeries = new FibonacciSeries();
        LocalDateTime startTime = null;
        LocalDateTime endTime = null;
        long duration = 0;

        int fib1 = 10;
        int fib3 = 49;
        int fib4 = 500;

        startTime = LocalDateTime.now();
        System.out.println("Sum of " + fib3 + " is : " + fibonacciSeries.usingDivideAndConquer(fib3));
        endTime = LocalDateTime.now();
        duration = ChronoUnit.MILLIS.between(startTime, endTime);
        System.out.println("Time taken to compute using Divide and Conquer Algorithm is (ms) : " + duration);

		startTime = LocalDateTime.now();
		System.out.println("Sum of " + fib4 + " is : " + fibonacciSeries.usingLoop(fib4));
		endTime = LocalDateTime.now();
		duration = ChronoUnit.MILLIS.between(startTime, endTime);
		System.out.println("Time taken to compute using Loop/Iterator Algorithm is (ms) : " + duration);

        long[] ar1 = new long[fib4 + 1];
        fibonacciSeries.initializeMemonize(ar1, fib4);

        startTime = LocalDateTime.now();
        System.out.println("\nSum of " + fib4 + " is : " + fibonacciSeries.usingTopDownApproch(fib4, ar1));
        endTime = LocalDateTime.now();
        duration = ChronoUnit.MILLIS.between(startTime, endTime);
        System.out.println("Time taken to compute using Top Down Approch Algorithm is : " + duration);

        System.out
                .println("===========================================================================================");
        System.out.println(
                "\nClearly, Top down Approch is winner as 1st one is taking more time because of exponential growth");
        System.out
                .println("===========================================================================================");

        long[] ar4 = new long[fib4 + 1];
        fibonacciSeries.initializeMemonize(ar4, fib4);

        startTime = LocalDateTime.now();
        System.out.println("\nSum of " + fib4 + " is : " + fibonacciSeries.usingTopDownApproch(fib4, ar4));
        endTime = LocalDateTime.now();
        duration = ChronoUnit.MILLIS.between(startTime, endTime);
        System.out.println("Time taken to compute using Top Down Approch Algorithm is : " + duration);

        startTime = LocalDateTime.now();
        System.out.println("\nSum of " + fib4 + " is : " + fibonacciSeries.usingBottomUpApproch(fib4));
        endTime = LocalDateTime.now();
        duration = ChronoUnit.MILLIS.between(startTime, endTime);
        System.out.println("Time taken to compute using Bottom Up Approch Algorithm is : " + duration);

    }

    /**
     * Using recursion
     *
     * @param n
     * @return
     */
    public long usingDivideAndConquer(int n) {
        long result = 0;
        if (n == 1 || n == 2)
            return 1;
        result = usingDivideAndConquer(n - 1) + usingDivideAndConquer(n - 2);
        return result;

    }

    public long usingLoop(int n) {
        if (n == 1 || n == 2)
            return 1;
        long sum = 1;
        long fib1 = 1, fib2 = 1;
        for (int i = 3; i <= n; i++) {
			sum =  fib1 + fib2;
			fib1=fib2;
			fib2=sum;
        }
        return sum;
    }

    public long usingTopDownApproch(int n, long[] memonize) {
        if (memonize[n] != 0)
            return memonize[n];
        if (n == 1 || n == 2)
            return 1;
        memonize[n] = usingTopDownApproch(n - 1, memonize) + usingTopDownApproch(n - 2, memonize);
        return memonize[n];
    }

    public long usingBottomUpApproch(int n) {
        // handle error message in case of n <1
        long[] memonize = new long[n + 1];
        memonize[1] = 1;
        memonize[2] = 1;

        for (int i = 3; i <= n; i++) {
            memonize[i] = memonize[i - 1] + memonize[i - 2];
        }
        return memonize[n];
    }

    private void initializeMemonize(long[] memonize, int length) {
        for (int i = 0; i <= length; i++) {
            memonize[i] = 0;
        }
    }

}

/**
 Sum of 49 is : 7778742049
 Time taken to compute using Divide and Conquer Algorithm is (ms) : 19591
 Sum of 500 is : 2171430676560690477
 Time taken to compute using Loop/Iterator Algorithm is (ms) : 0

 Sum of 500 is : 2171430676560690477
 Time taken to compute using Top Down Approch Algorithm is : 0
 ===========================================================================================

 Clearly, Top down Approch is winner as 1st one is taking more time because of exponential growth
 ===========================================================================================

 Sum of 500 is : 2171430676560690477
 Time taken to compute using Top Down Approch Algorithm is : 0

 Sum of 500 is : 2171430676560690477
 Time taken to compute using Bottom Up Approch Algorithm is : 0

 Process finished with exit code 0

 */
