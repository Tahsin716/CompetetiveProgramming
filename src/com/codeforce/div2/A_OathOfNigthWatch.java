package com.codeforce.div2;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class A_OathOfNigthWatch {

    static BufferedReader bufferedReader;
    static PrintWriter printWriter;
    static StringTokenizer stringTokenizer;

    static void solve() throws Exception {

        int testCase = nextInt();
        int[] input = new int[testCase];
        int count = 0;
        boolean lowerFlag, higherFlag;
        for(int i = 0; i < testCase; i++)
            input[i] = nextInt();

        Arrays.sort(input);

        if(input.length <= 2) {
            printWriter.println(count);
            printWriter.flush();
            return;
        }

        for(int i = 1; i < testCase - 1; i++) {
            lowerFlag = false;
            higherFlag = false;

            if(input[i] > input[0])
                lowerFlag = true;

            if(input[i] < input[testCase - 1])
                higherFlag = true;

            if(lowerFlag && higherFlag)
                count++;
        }

        printWriter.println(count);
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
