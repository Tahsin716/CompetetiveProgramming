package com.hackerrank.algorithms;

import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Dynamic_FibonacciModified {

    static BufferedReader bufferedReader;
    static PrintWriter printWriter;
    static StringTokenizer stringTokenizer;

    static void solve() throws Exception {

        String[] temp = bufferedReader.readLine().split(" ");
        int A = Integer.parseInt(temp[0]);
        int B = Integer.parseInt(temp[1]);
        int N = Integer.parseInt(temp[2]);

        printWriter.println( fibonacciNumber(A, B, N) );
        printWriter.flush();
    }

    static BigInteger fibonacciNumber(int A, int B, int N) {

        BigInteger[] array = new BigInteger[N+1];
        array[1] = BigInteger.valueOf(A);
        array[2] = BigInteger.valueOf(B);

        for(int i = 3; i <= N; i++) {
            array[i] = (array[i-1].multiply(array[i-1])).add(array[i-2]);
        }

        return array[N];
    }

    public static void main(String[] args) {

        try {

            //bufferedReader = new BufferedReader(new FileReader("input.txt"));
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
