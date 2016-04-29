package com.uva.introduction;

//Uva- 11547

import java.io.*;
import java.util.StringTokenizer;

public class AutomaticAnswer {

    static BufferedReader bufferedReader;
    static PrintWriter printWriter;
    static StringTokenizer stringTokenizer;

    static void solve() throws Exception {

        int testCase = nextInt();

        for(int i = 0; i < testCase; i++) {

            int number = nextInt();
            int ans = Math.abs( (((((((number*567)/9)+7492)*235)/47)-498)/10)%10 );

            printWriter.println(ans);
            printWriter.flush();
        }
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
        while(stringTokenizer == null || !stringTokenizer.hasMoreTokens()){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        }
        return stringTokenizer.nextToken();
    }
}
