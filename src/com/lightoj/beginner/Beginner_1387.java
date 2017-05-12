package com.lightoj.beginner;

import java.io.*;
import java.util.StringTokenizer;

public class Beginner_1387 {

    static BufferedReader bufferedReader;
    static PrintWriter printWriter;
    static StringTokenizer stringTokenizer;

    static void solve() throws Exception {

        int testCase, innerCase, cases = 1;
        long money;
        String[] input;

        testCase = nextInt();
        while(testCase-- > 0) {

            innerCase = nextInt();
            printWriter.printf("Case %d:%n", cases++);
            money = 0L;
            while (innerCase-- > 0) {

                input = bufferedReader.readLine().split(" ");
                if(input.length > 1){
                    money += Long.parseLong(input[1]);
                }
                else {
                    printWriter.println(money);
                }
            }
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

    static long nextLong() throws Exception {
        return Long.parseLong( next() );
    }
}
