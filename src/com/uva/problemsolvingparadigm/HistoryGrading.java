package com.uva.problemsolvingparadigm;

import java.io.*;
import java.util.StringTokenizer;

public class HistoryGrading {

    static BufferedReader bufferedReader;
    static PrintWriter printWriter;
    static StringTokenizer stringTokenizer;

    static void solve() throws Exception {

        int n = nextInt();

        int[] order = new int[20];
        int[] arr = new int[20];

        for (int i = 0; i < n; i++) {
            order[nextInt() - 1] = i;
        }

        while (true) {

            boolean flag = false;
            String s = bufferedReader.readLine();

            if (s != null) {
                String[] temp = s.split(" ");

                for (int i = 0; i < n; i++) {
                    arr[Integer.parseInt(temp[i]) - 1] = i;
                }

                flag = true;
            }

            if (!flag)  break;

            int[][] dp = new int[25][25];

            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {

                    if (order[i -1] == arr[j - 1]) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    }
                    else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }
                }
            }

            printWriter.println(dp[n][n]);
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
