package com.uva.mathematics;

// Uva - 10494

import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class IfWeWereAChildAgain {

    static BufferedReader bufferedReader;
    static PrintWriter printWriter;
    static StringTokenizer stringTokenizer;

    static void solve() throws Exception {

        String str;
        String[] inputs;

        BigInteger firstNumber, secondNumber;

        while ( (str = bufferedReader.readLine()) != null ) {

            inputs = str.split("\\s+");
            firstNumber = new BigInteger(inputs[0]);
            secondNumber = new BigInteger(inputs[2]);

            if (inputs[1].equals("/")) {
                printWriter.println(firstNumber.divide(secondNumber));
            }
            else {
                printWriter.println(firstNumber.mod(secondNumber));
            }
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
