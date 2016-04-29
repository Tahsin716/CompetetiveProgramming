package com.uva.introduction;

//Uva- 11044

import java.io.*;
import java.util.StringTokenizer;


public class SearchingForNessy {

    static BufferedReader bufferedReader;
    static PrintWriter printWriter;
    static StringTokenizer stringTokenizer;

    static void solve() throws Exception {
        int testCase = nextInt();

        for(int i = 0; i < testCase; testCase--) {
            int rows = nextInt();
            int columns = nextInt();

            int ans = (rows/3) * (columns/3); //main formula
            printWriter.println(ans);
            printWriter.flush();
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

}

//To find number of sonars to cover all the grids
//use the method ceil to round it up