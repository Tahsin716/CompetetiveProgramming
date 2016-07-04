package com.hackerrank.algorithms;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Dynamic_LongestIncreasingSubsequence {

    static BufferedReader bufferedReader;
    static PrintWriter printWriter;
    static StringTokenizer stringTokenizer;

    static void solve() throws Exception {

        int testCase = nextInt();
        int[] arr = new int[testCase];

        for(int i = 0; i < testCase; i++)
            arr[i] = nextInt();

        int ans = LongestIncreasingSubsequence(arr, arr.length);

        printWriter.println(ans);
        printWriter.flush();
    }

    static int LongestIncreasingSubsequence(int[] arr, int len) {

        int[] parent = new int[len];
        int[] increasingSub = new int[len +1];
        int length = 0;


        for(int i = 0; i < len; i++) {

            int low = 1;
            int high = length;

            while(low <= high) {

                int mid = (int)Math.ceil( (low+high)/2 );

                if(arr[increasingSub[mid]] < arr[i])
                    low = mid + 1;
                else
                    high = mid - 1;
            }

            int position = low;
            parent[i] = increasingSub[position-1];
            increasingSub[position] = i;

            if(position > length)
                length = position;
        }

        return length;
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
