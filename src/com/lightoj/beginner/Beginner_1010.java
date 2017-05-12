package com.lightoj.beginner;


import java.io.*;
import java.util.StringTokenizer;

public class Beginner_1010 {

    static BufferedReader bufferedReader;
    static PrintWriter printWriter;
    static StringTokenizer stringTokenizer;

    static void solve() throws Exception {

        int testCase, ans, cases = 1;
        double row, column;

        testCase = nextInt();
        while(testCase-- > 0) {
            row = nextDouble();
            column = nextDouble();

            ans = (int)Math.ceil((row*column)/2);
            printWriter.printf("Case %d: %d%n", cases++, ans);
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

    static long nextLong() throws Exception {
        return Long.parseLong( next() );
    }

    static double nextDouble() throws Exception {
        return Double.parseDouble( next() );
    }
}
