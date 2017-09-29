package com.uva.mathematics;

import java.io.*;
import java.util.StringTokenizer;

public class AboveAverage {

    static BufferedReader bufferedReader;
    static PrintWriter printWriter;
    static StringTokenizer stringTokenizer;

    static void solve() throws Exception {
        int testCases = nextInt();
        int N, aboveCount, sum;

        int[] marks = new int[1005];
        double average;

        while (testCases-- > 0) {
            N = nextInt();
            sum = 0;
            aboveCount = 0;

            for (int i = 0; i < N; i++) {
                marks[i] = nextInt();
                sum += marks[i];
            }
            average = (double)sum / (double)N;

            for (int i = 0; i < N; i++) {
                if (marks[i] > average)
                    aboveCount++;
            }

            printWriter.printf("%.3f%%%n", (double)aboveCount / (double)N * 100.000);
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
