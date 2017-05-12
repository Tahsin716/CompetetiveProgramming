package com.codeforce.div2;

import java.io.*;
import java.util.StringTokenizer;

public class A_NeverendingCompetition {

    static BufferedReader bufferedReader;
    static PrintWriter printWriter;
    static StringTokenizer stringTokenizer;

    static void solve() throws Exception {

        int travelNumber = nextInt();
        int temp = travelNumber;
        String hometown = bufferedReader.readLine();

        while (travelNumber-- > 0) {
            bufferedReader.readLine();
        }

        if(temp %2 == 0) {
            printWriter.println("home");
        }
        else {
            printWriter.println("contest");
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
}
