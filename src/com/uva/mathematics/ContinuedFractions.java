package com.uva.mathematics;

// Uva - 834

import java.io.*;
import java.util.StringTokenizer;

public class ContinuedFractions {

    static BufferedReader bufferedReader;
    static PrintWriter printWriter;
    static StringTokenizer stringTokenizer;

    static void solve() throws Exception {

        String str;
        StringBuilder output;
        String[] input;
        int numerator, denominator, quotient, remainder, index;

        while ( (str = bufferedReader.readLine()) != null) {

            input = str.split(" ");
            numerator = Integer.parseInt(input[0]);
            denominator = Integer.parseInt(input[1]);

            output = new StringBuilder("");

            index = 0;
            remainder = 1;

            while (remainder != 0) {

                quotient = numerator / denominator;
                remainder = numerator % denominator;

                numerator = denominator;
                denominator = remainder;

                if (index == 0 && remainder != 0) {
                    output.append(String.format("[%d", quotient));
                }
                else if (index == 0 && remainder == 0) {
                    output.append(String.format("[%d]", quotient));
                }
                else if (index == 1 && remainder == 0) {
                    output.append(String.format(";%d]", quotient));
                }
                else if (index == 1 && remainder != 0) {
                    output.append(String.format(";%d", quotient));
                }
                else if (index > 1 && remainder != 0) {
                    output.append(String.format(",%d", quotient));
                }
                else if (index > 1 && remainder == 0) {
                    output.append(String.format(",%d]", quotient));
                }

                index++;
            }
            printWriter.println(output);
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
