package com.uva.problemsolvingparadigm;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ExactChange {

    static BufferedReader bufferedReader;
    static PrintWriter printWriter;
    static StringTokenizer stringTokenizer;


    static int target, n;
    static int[] coins;
    static int[][] dp, steps;

    static void solve() throws Exception {

        int testCase = nextInt();

        coins = new int[105];

        dp = new int[104][10004];
        steps = new int[104][10004];

        while (testCase-- > 0) {

            target = nextInt();
            n = nextInt();

            for (int[] temp : dp) {
                Arrays.fill(temp, -1);
            }

            for (int[] temp : steps) {
                Arrays.fill(temp, -1);
            }

            for (int i = 0; i < n; i++) {
                coins[i] = nextInt();
            }

            int sum = rec(0, 0);
            int ans = step(0, sum);

            printWriter.println(sum + " " + ans);
        }

        printWriter.flush();
    }


    static int rec(int i, int sum) {

        if (sum >= target) return sum;
        if (i == n) return Integer.MAX_VALUE;

        if (dp[i][sum] != -1) return dp[i][sum];

        int ret = Integer.MAX_VALUE;

        ret = Math.min(ret, rec(i + 1, sum + coins[i]));
        ret = Math.min(ret, rec(i + 1, sum));

        return dp[i][sum] = ret;
    }

    static int step(int i, int sum) {

        if (sum == 0) return 0;
        if (sum < 0) return Integer.MAX_VALUE - 1000;

        if (i == n) return Integer.MAX_VALUE - 1000;

        if (steps[i][sum] != -1) return steps[i][sum];

        int ret = Integer.MAX_VALUE - 1000;

        ret = Math.min(ret, step(i + 1, sum - coins[i]) + 1);
        ret = Math.min(ret, step(i + 1, sum));

        return steps[i][sum] = ret;
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
