package com.uva.datastructures;

//UVa- 594

import java.io.*;
import java.util.StringTokenizer;

public class OneLittleTwoLittleThreeLittleEndians {

    static BufferedReader bufferedReader;
    static PrintWriter printWriter;
    static StringTokenizer stringTokenizer;


    static void solve() throws Exception {

        String str;
        int number;

        while( (str = bufferedReader.readLine()) != null && !(str.trim().isEmpty())) {

            number = Integer.parseInt(str);
            printWriter.printf("%d converts to %d%n", number, Integer.reverseBytes(number));
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
