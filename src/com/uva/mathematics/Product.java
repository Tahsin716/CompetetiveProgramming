package com.uva.mathematics;


import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Product {

    static BufferedReader bufferedReader;
    static PrintWriter printWriter;
    static StringTokenizer stringTokenizer;

    public static void solve() throws Exception {
        String input;
        BigInteger firstNumber;
        BigInteger secondNumber;

        while ((input = bufferedReader.readLine()) != null) {

            firstNumber = new BigInteger(input);
            secondNumber = new BigInteger(bufferedReader.readLine());

            printWriter.println(secondNumber.multiply(firstNumber));
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
