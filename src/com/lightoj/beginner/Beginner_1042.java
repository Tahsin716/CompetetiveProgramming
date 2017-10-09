package com.lightoj.beginner;


import java.io.*;
import java.util.StringTokenizer;

public class Beginner_1042 {

    static BufferedReader bufferedReader;
    static PrintWriter printWriter;
    static StringTokenizer stringTokenizer;

    static void solve() throws Exception {

        int testCase, number, rightOne, nextHigherOneBit, rightOnesPattern, next = 0, index;

        StringBuilder stringBuilder = new StringBuilder();
        index = 0;
        testCase = nextInt();
        while (testCase-- > 0) {
            number = nextInt();

            if (number != 0) {
                rightOne = number & -number;

                nextHigherOneBit = number + rightOne;

                rightOnesPattern = number ^ nextHigherOneBit;

                rightOnesPattern = (rightOnesPattern)/ rightOne;

                rightOnesPattern = rightOnesPattern >> 2;

                next = nextHigherOneBit | rightOnesPattern;

                ++index;
            }
            stringBuilder.append(String.format("Case %d: %d%n", index, next));
        }

        printWriter.print(stringBuilder);
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

    static long nextLong() throws Exception {
        return Long.parseLong( next() );
    }
}
