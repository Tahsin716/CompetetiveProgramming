package com.uva.introduction;

//Uva- 11364

import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Parking {

    static BufferedReader bufferedReader;
    static PrintWriter printWriter;
    static StringTokenizer stringTokenizer;

    static void solve() throws  Exception {
        int testCase = nextInt();

        for(int i = 0; i < testCase; i++) {
            int number = nextInt();
            int[] arr = new int[number];

            for(int j = 0; j < number; j++) {
                arr[j] = nextInt();
            }
            Arrays.sort(arr);

            //distance between the furthest and nearest store times 2, since he has to go and come back
            int ans = ( arr[number-1] - arr[0] )*2;

            printWriter.println(ans);
            printWriter.flush();
        }
    }

    public static void main(String[] args) {

        try {
            bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            printWriter = new PrintWriter(new BufferedOutputStream(System.out));
            solve();
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
        while(stringTokenizer == null || !stringTokenizer.hasMoreTokens()){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        }
        return stringTokenizer.nextToken();
    }
}
