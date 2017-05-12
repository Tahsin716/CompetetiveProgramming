package com.codeforce.div2;

import java.io.*;
import java.util.StringTokenizer;

public class A_PupilRedistribution {

    static BufferedReader bufferedReader;
    static PrintWriter printWriter;
    static StringTokenizer stringTokenizer;

    static void solve() throws Exception {

        int testCase = nextInt();
        int[] frequency = new int[6];
        int sum = 0;
        boolean flag = true;

        for(int i = 0; i < testCase; i++) {
            frequency[nextInt()]++;
        }

        for(int i = 0; i < testCase; i++){
            frequency[nextInt()]--;
        }

        for(int i = 0; i < 6; i++) {
            if(Math.abs(frequency[i]) % 2 == 1) {
                flag = false;
                break;
            }

            sum += Math.abs(frequency[i]);
        }

        sum /= 2;

        if(flag)
            printWriter.println( sum/2 );
        else
            printWriter.println(-1);

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

    static long nextLong() throws Exception {
        return Long.parseLong( next() );
    }
}
