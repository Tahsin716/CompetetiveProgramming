package com.uva.mathematics;

// Uva - 344

import java.io.*;
import java.util.StringTokenizer;

public class RomanDigititis {

    static BufferedReader bufferedReader;
    static PrintWriter printWriter;
    static StringTokenizer stringTokenizer;

    static int[] frequency;

    static void solve() throws Exception {


        int input, remainder, number;

        while ( (input = nextInt()) != 0) {
            frequency = new int[5];

            for(int i = input ; i > 0; i--) {
                if(i/10 == 10) {
                    frequency[4]++;
                }
                else if(i/10 != 0) {
                    remainder = i % 10;
                    number =  i /10;

                    checkDividend(number);
                    checkRemainder(remainder);
                }
                else {
                    checkRemainder(i);
                }
            }


            printWriter.println( String.format("%d: %d i, %d v, %d x, %d l, %d c", input,frequency[0], frequency[1], frequency[2]
                                , frequency[3], frequency[4]));

        }
        printWriter.flush();
    }

    static void checkDividend(int n) {
        switch (n) {
            case 1:
                frequency[2] += 1;
                break;
            case 2:
                frequency[2] += 2;
                break;
            case 3:
                frequency[2] += 3;
                break;
            case 4:
                frequency[2] += 1;
                frequency[3] += 1;
                break;
            case 5:
                frequency[3] += 1;
                break;
            case 6:
                frequency[3] += 1;
                frequency[2] += 1;
                break;
            case 7:
                frequency[3] += 1;
                frequency[2] += 2;
                break;
            case 8:
                frequency[3] += 1;
                frequency[2] += 3;
                break;
            case 9:
                frequency[2] += 1;
                frequency[4] += 1;

        }
    }

    static void checkRemainder(int n) {
        switch (n) {
            case 1 :
                frequency[0] += 1;
                break;
            case 2:
                frequency[0] += 2;
                break;
            case 3:
                frequency[0] += 3;
                break;
            case 4:
                frequency[0] += 1;
                frequency[1] += 1;
                break;
            case 5:
                frequency[1] += 1;
                break;
            case 6:
                frequency[0] += 1;
                frequency[1] += 1;
                break;
            case 7:
                frequency[0] += 2;
                frequency[1] += 1;
                break;
            case 8:
                frequency[0] += 3;
                frequency[1] += 1;
                break;
            case 9:
                frequency[0] += 1;
                frequency[2] += 1;
                break;
        }
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
