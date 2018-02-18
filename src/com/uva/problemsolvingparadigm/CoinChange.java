package com.uva.problemsolvingparadigm;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CoinChange {

    static BufferedReader bufferedReader;
    static PrintWriter printWriter;
    static StringTokenizer stringTokenizer;

    static int n, ans;
    static int[][] dp;
    static int[] coins;

    static void solve() throws Exception {
        coins = new int[]{1, 5, 10, 25, 50};
        dp = new int[5][7500];
        n = 5;

        for (int[] temp : dp) {
            Arrays.fill(temp, -1);
        }

        String s;

        while ((s = bufferedReader.readLine()) != null) {
            int amount = Integer.parseInt(s);

            ans = rec(0, amount);

            printWriter.println(ans);
        }

        printWriter.flush();
    }

    public static int rec(int i, int amount) {

        if (i == n || amount < 0) return 0;
        if (amount == 0) return 1;

        if (dp[i][amount] != -1) return dp[i][amount];

        int ret = 0;
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
