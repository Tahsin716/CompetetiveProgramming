package com.acm;

import java.io.*;
import java.util.StringTokenizer;

public class Owllen {

    static BufferedReader bufferedReader;
    static PrintWriter printWriter;
    static StringTokenizer stringTokenizer;

    static void solve() throws Exception {

        int testCase, count = 1;
        testCase = nextInt();

        while(testCase-- > 0) {

            String str = bufferedReader.readLine();
            int[] frequency = new int[30];

            for(int i = 0; i < str.length(); i++)
                frequency[str.charAt(i) - 'a']++;

            int minLCS = Integer.MAX_VALUE;

            for(int i = 0; i < 26; i++)
                minLCS = Math.min(minLCS, frequency[i]);

            printWriter.printf("Case %d: %d%n", count, minLCS);
            count++;
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
