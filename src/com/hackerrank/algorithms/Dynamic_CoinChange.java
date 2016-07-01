package com.hackerrank.algorithms;

import java.io.*;
import java.util.StringTokenizer;

public class Dynamic_CoinChange {

    static BufferedReader bufferedReader;
    static PrintWriter printWriter;
    static StringTokenizer stringTokenizer;


    static void solve() throws Exception {

        String[] temp = bufferedReader.readLine().split(" ");
        int N = Integer.parseInt(temp[0]);
        int M = Integer.parseInt(temp[1]);

        temp = bufferedReader.readLine().split(" ");
        int[] coins = new int[M];

        for(int i = 0; i < M; i++)
            coins[i] = Integer.parseInt(temp[i]);

        long ans = coinChange(N, coins);

        printWriter.println(ans);
        printWriter.flush();
    }

    static long coinChange(int total, int[] coins) {

        long[][] temp = new long[coins.length+1][total+1];

        for(int i = 0; i <= coins.length; i++)
            temp[i][0] = 1;

        for(int i = 1; i <= coins.length; i++) {
            for(int j = 1; j <= total; j++) {

                if(coins[i-1] > j) {
                    temp[i][j] = temp[i-1][j];
                }
                else {
                    temp[i][j] = temp[i][j - coins[i-1]] + temp[i-1][j];
                }
            }
        }

        return temp[coins.length][total];
    }

    public static void main(String[] args) {

        try {

            //bufferedReader = new BufferedReader(new FileReader("input.txt"));
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
