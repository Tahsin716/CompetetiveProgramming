package com.uva.introduction;

//Uva- 12279

import java.io.*;
import java.util.StringTokenizer;

public class EmoogleBalance {

    static BufferedReader bufferedReader;
    static PrintWriter printWriter;
    static StringTokenizer stringTokenizer;

    static void solve() throws Exception {

        int testCase, count = 1, temp, zeroCount, numberCount, ans;
        boolean flag = true;

        while( flag ) {
            testCase = nextInt();

            if (testCase == 0)
                flag = false;
            else {
                zeroCount = 0;
                numberCount = 0;

                for(int i = 0; i < testCase; i++) {
                    temp = nextInt();

                    if( temp != 0)
                        numberCount++;
                    else
                        zeroCount++;
                }
                ans = numberCount - zeroCount;

                printWriter.println("Case " + count + ": " + ans);
                printWriter.flush();
                count++;
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
}
