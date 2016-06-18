package com.hackerrank.algorithms;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Dynamic_Knapsack {

    static BufferedReader bufferedReader;
    static PrintWriter printWriter;
    static StringTokenizer stringTokenizer;


    static void solve() throws Exception {

        int testCase = nextInt();

        while(testCase-- > 0) {

            String[] temp = bufferedReader.readLine().split(" ");
            int n = Integer.parseInt(temp[0]);
            int k = Integer.parseInt(temp[1]);

            temp = bufferedReader.readLine().split(" ");
            int[] array = new int[n];

            for(int i = 0; i < n; i++)
                array[i] = Integer.parseInt(temp[i]);

            int ans = unboundedKnapsack(array, k);
            printWriter.println(ans);
        }

        printWriter.flush();
    }

    static int unboundedKnapsack(int[] array, int capacity) {

        int[] K = new int[2001];
        Arrays.fill(K, 0);

        for(int i = 1; i <= capacity; i++) {
            for(int j = 0; j < array.length; j++) {

                if(array[j] <= i) {
                    K[i] = Math.max(K[i], array[j] + K[i- array[j]]);
                }
            }
        }

        return K[capacity];
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
