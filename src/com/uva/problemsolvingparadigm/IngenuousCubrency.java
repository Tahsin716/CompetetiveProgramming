package com.uva.problemsolvingparadigm;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class IngenuousCubrency {

    static BufferedReader bufferedReader;
    static PrintWriter printWriter;
    static StringTokenizer stringTokenizer;

    static int n;
    static long ans;
    static long[][] dp;
    static int[] coins;

    static void solve() throws Exception {
        coins = new int[]{1, 8, 27, 64, 125, 216, 343, 512, 729, 1000, 1331, 1728, 2197, 2744, 3375, 4096, 4913, 5832, 6859, 8000, 9261};
        dp = new long[22][10005];
        n = 21;

        for (long[] temp : dp) {
            Arrays.fill(temp, -1);
        }

        String s, result;

        while ((s = bufferedReader.readLine()) != null) {
            int amount = Integer.parseInt(s.trim());

            ans = rec(0, amount);

            printWriter.println(ans);
        }

        printWriter.flush();
    }

    public static long rec(int i, int amount) {

        if (i == n || amount < 0) return 0;
        if (amount == 0) return 1;

        if (dp[i][amount] != -1) return dp[i][amount];

        long ret = 0;
        ret += rec(i, amount - coins[i]) + rec(i + 1, amount);

        return dp[i][amount] = ret;
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
