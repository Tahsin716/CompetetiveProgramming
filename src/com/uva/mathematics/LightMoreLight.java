package com.uva.mathematics;

// Uva - 10110

import java.io.*;
import java.util.StringTokenizer;

public class LightMoreLight {

    static BufferedReader bufferedReader;
    static PrintWriter printWriter;
    static StringTokenizer stringTokenizer;

    static void solve() throws Exception {

        long lastBulb, bulbSqrt;
        String output;

        while ( (lastBulb = nextLong()) != 0) {
            bulbSqrt = (long) Math.sqrt(lastBulb);

            output = (bulbSqrt*bulbSqrt == lastBulb) ? "yes": "no";
            printWriter.println(output);

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

    static long nextLong() throws IOException {
        return  Long.parseLong( next() );
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
