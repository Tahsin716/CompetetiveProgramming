package com.uva.introduction;

//Uva- 11942

import java.io.*;
import java.util.StringTokenizer;

public class LumberjackSequencing {

    static BufferedReader bufferedReader;
    static PrintWriter printWriter;
    static StringTokenizer stringTokenizer;


    static void solve() throws  Exception{

        int testCase = nextInt();
        int[] arr = new int[10];

        printWriter.println("Lumberjacks:");
        printWriter.flush();

        for(int i = 0; i < testCase; i++) {

            for(int j = 0; j < 10; j++) {
                arr[j] = nextInt();
            }

            boolean ans = isSorted(arr);
            String result = (ans) ? "Ordered" : "Unordered";

            printWriter.println(result);
            printWriter.flush();
        }

    }

    static boolean isSorted(int[] arr) {

        if(isAscending(arr) || isDescending(arr))
            return true;

        return false;
    }

    static boolean isAscending(int[] arr) {

        for(int i = 0; i < arr.length -1; i++)
        {
            if(arr[i] > arr[i+1])
                return false;
        }

        return true;
    }

    static boolean isDescending(int[] arr) {

        for(int i = 0; i < arr.length -1; i++) {

            if(arr[i] < arr[i+1])
                return false;

        }
        return true;
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
