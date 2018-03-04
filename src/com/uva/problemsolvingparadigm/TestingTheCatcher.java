package com.uva.problemsolvingparadigm;

import java.io.*;
import java.util.StringTokenizer;

public class TestingTheCatcher {

    static BufferedReader bufferedReader;
    static PrintWriter printWriter;
    static StringTokenizer stringTokenizer;

    static void solve() throws Exception {

        int n, i, j, test = 0;
        int[] arr = new int[1000];

        String s;

        while (true) {

            s = bufferedReader.readLine();

            if (s == null)
                break;

            arr[0] = Integer.parseInt(s);

            if (arr[0] < 0)
                break;

            n = 1;

            while ((s = bufferedReader.readLine()) != null) {
                if (s.equals("-1"))
                    break;

                arr[n++] = Integer.parseInt(s);
            }

            int[] dp = new int[1000];

            for (i = 0; i < n; i++) {
                for (j = i + 1; j < n; j++) {
                    if (arr[i] > arr[j] && dp[j] < dp[i] + 1) {
                        dp[j] = dp[i] + 1;
                    }
                }
            }

            int max = 0;
            for (i = 0; i < n; i++)
                if (max < dp[i])
                    max = dp[i];

            max++;

            if (test > 0)
                printWriter.println();

            printWriter.printf("Test #%d:\n", ++test);
            printWriter.printf("  maximum possible interceptions: %d\n", max);
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
