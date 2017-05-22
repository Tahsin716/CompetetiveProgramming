package com.acm;

import java.io.*;
import java.util.StringTokenizer;

public class FibonacciNumber {

    static BufferedReader bufferedReader;
    static PrintWriter printWriter;
    static StringTokenizer stringTokenizer;


    static void solve() throws Exception {


        int[] fibonacci = new int[100];
        int LIMIT = 500;
        fibonacci[0] = 0; fibonacci[1] = 1;

        printWriter.printf("%d%n%d%n", fibonacci[0], fibonacci[1]);

        for(int i = 2; fibonacci[i] <= LIMIT; i++) {

            fibonacci[i] = fibonacci[i-1] + fibonacci[i-2];

            if(fibonacci[i] <= LIMIT)
                printWriter.println(fibonacci[i]);
            else
                break;

        }

        printWriter.flush();
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
}
