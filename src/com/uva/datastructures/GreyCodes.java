package com.uva.datastructures;

//UVa- 11173

//Formula for grey-codes, g = n ^(n >> 1)

import java.io.*;
import java.util.StringTokenizer;

public class GreyCodes {

    static BufferedReader bufferedReader;
    static PrintWriter printWriter;
    static StringTokenizer stringTokenizer;

    static void solve() throws Exception {

        int testCase = nextInt();

        while(testCase-- > 0) {

            String[] temp = bufferedReader.readLine().split(" ");
            // int n = Integer.parseInt(temp[0]); not needed
            int k = Integer.parseInt(temp[1]);

            printWriter.printf("%d%n", k^(k >> 1));

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
