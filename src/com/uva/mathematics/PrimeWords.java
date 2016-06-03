package com.uva.mathematics;

//UVa- 10924

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class PrimeWords {

    static Scanner scanner;
    static PrintWriter printWriter;

    static void solve() throws Exception {

        boolean[] prime = sieveOfEratosthenes(1100);
        String word;

        while(scanner.hasNext()) {

            word = scanner.next();

            if (prime[wordValue(word)])
                printWriter.println("It is a prime word.");
            else
                printWriter.println("It is not a prime word.");
        }
    }

    public static void main(String[] args) {

        try {

            scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
            printWriter = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
            solve();
            scanner.close();
            printWriter.close();
        }
        catch (Throwable e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    static boolean[] sieveOfEratosthenes(int upperBound) {

        boolean[] prime = new boolean[upperBound + 1];
        Arrays.fill(prime, true);
        int upperBoundSquareRoot = (int)Math.sqrt(upperBound);

        for(int i = 2; i <= upperBoundSquareRoot; i++) {
            if (prime[i])
                for(int j = i*i; j <= upperBound; j += i)
                    prime[j] = false;
        }

        return prime;
    }

    static int wordValue(String word) {

        int sum = 0;

        for(char c: word.toCharArray()) {
            if (Character.isUpperCase(c))
                sum += c - 'A' + 27;
            else
                sum += c - 'a' + 1;
        }

        return sum;
    }
}
