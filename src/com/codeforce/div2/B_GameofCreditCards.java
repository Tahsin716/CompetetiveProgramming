package com.codeforce.div2;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_GameofCreditCards {

    static BufferedReader bufferedReader;
    static PrintWriter printWriter;
    static StringTokenizer stringTokenizer;

    static void solve() throws Exception {

        int testCase = nextInt();
        char[] sherlock = bufferedReader.readLine().toCharArray();
        char[] moriarity = bufferedReader.readLine().toCharArray();
        int counter;

        Arrays.sort(sherlock);
        Arrays.sort(moriarity);

        counter = testCase - 1;
        for(int i = testCase - 1; i >= 0; i--) {
            if(moriarity[counter] >= sherlock[i])
                counter--;
        }

        printWriter.println(counter + 1);

        counter = 0;
        for(int i = 0; i < testCase; i++){
            if(moriarity[i] > sherlock[counter])
                counter++;
        }

        printWriter.println(counter);
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
