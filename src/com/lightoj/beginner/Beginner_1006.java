package com.lightoj.beginner;

import java.io.*;
import java.util.StringTokenizer;

/**
 *  For optimization bottom-up dp of fibonacci number is used
 *  further more you need to mod two times
 *  while printing the result and while calculating the value in the loop
 */

public class Beginner_1006 {

    static BufferedReader bufferedReader;
    static PrintWriter printWriter;
    static StringTokenizer stringTokenizer;

    static void solve() throws Exception {

        int testCase, n, cases = 1;
        long[] hexArray = new long[10005];
        String[] input;

        testCase = nextInt();
        while (testCase-- > 0) {

            input = bufferedReader.readLine().split(" ");
            for(int i = 0; i < 6; i++)
                hexArray[i] = Long.parseLong(input[i]);

            n = Integer.parseInt(input[6]);
            for(int i = 6; i <= n; i++)
                hexArray[i] = (hexArray[i-6] + hexArray[i-5] + hexArray[i-4] + hexArray[i-3] + hexArray[i-2] + hexArray[i-1])% 10000007;

            printWriter.printf("Case %d: %d%n", cases++, hexArray[n] % 10000007);
        }
        printWriter.close();
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
