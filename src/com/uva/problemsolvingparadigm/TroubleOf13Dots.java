package com.uva.problemsolvingparadigm;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TroubleOf13Dots {

    static BufferedReader bufferedReader;
    static PrintWriter printWriter;
    static StringTokenizer stringTokenizer;

    static int N, M;
    static int[][] dp;
    static int[] price, rating;

    static void solve() throws Exception {
        price = new int[101];
        rating = new int[101];
        dp = new int[101][15001];

        String s;

        while ((s = bufferedReader.readLine()) != null) {
            StringTokenizer tokenizer = new StringTokenizer(s);

            M = Integer.parseInt(tokenizer.nextToken());
            N = Integer.parseInt(tokenizer.nextToken());

            for (int i = 0; i < N; i++) {
                price[i] = nextInt();
                rating[i] = nextInt();
            }

            for (int[] temp : dp) {
                Arrays.fill(temp, -1);
            }

            int ans = knapsack(0, 0);

            printWriter.println(ans);
        }

        printWriter.flush();
    }

    public static int knapsack(int item, int money) {

        if (item == N) {

            if (money <= M || (money > 2000 && money <= M + 200))
                return 0;

            return Integer.MIN_VALUE;
        }

        if (dp[item][money] != -1) {
            return dp[item][money];
        }

        int best = -1;
        int other = -1;

        if (price[item] + money <= M + 200) {
            other = knapsack(item + 1, money + price[item]) + rating[item];
        }

        best = knapsack(item + 1, money);

        if (best >= 0 || other >= 0) {
            best = Math.max(best, other);
        }

        return dp[item][money] = best;
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
