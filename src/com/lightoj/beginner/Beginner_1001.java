package com.lightoj.beginner;

import java.io.*;
import java.util.StringTokenizer;

/**
 *  Just divide the input/2
 *  and then you have the result: input, input - (input/2)
 */


public class Beginner_1001 {

    static BufferedReader bufferedReader;
    static PrintWriter printWriter;
    static StringTokenizer stringTokenizer;

    static void solve() throws Exception {

        int testCase, number, other;
        testCase = nextInt();

        while (testCase-- > 0) {
            number = nextInt();
            other = number/2;
            number -= other;
            printWriter.println(other + " " + number);
        }
        printWriter.close();
    }


    public static void main(String[] args) {

        try {
            bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            printWriter = new PrintWriter(new BufferedOutputStream(System.out));
            solve();
            bufferedReader.close();
            printWriter.close();
        }
        catch (Throwable e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    static int nextInt() throws IOException {
        return Integer.parseInt( next() );
    }

    static String next() throws IOException {
        while (stringTokenizer == null || !stringTokenizer.hasMoreTokens()) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        }
        return stringTokenizer.nextToken();
    }

    static long nextLong() throws Exception {
        return Long.parseLong( next() );
    }
}
