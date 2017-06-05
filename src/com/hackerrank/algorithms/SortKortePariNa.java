package com.hackerrank.algorithms;

import java.io.*;
import java.util.StringTokenizer;

public class SortKortePariNa {


    static BufferedReader bufferedReader;
    static PrintWriter printWriter;
    static StringTokenizer stringTokenizer;

    static void solve() throws Exception {

        int n = nextInt();
        int temp, count = 0;
        int[] elements = new int[n];

        for(int i = 0; i < n; i++) {
            elements[i] = nextInt();
        }

        for(int i = 0; i < n; i++) {
            for(int j = 1; j < n - i; j++) {
                if(elements[j-1] > elements[j]){
                    temp = elements[j-1];
                    elements[j-1] = elements[j];
                    elements[j] = temp;
                    count++;
                }
            }
        }


        printWriter.println(count);
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
