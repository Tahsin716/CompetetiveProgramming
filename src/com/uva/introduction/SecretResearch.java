package com.uva.introduction;

//Uva- 621

import java.io.*;
import java.util.StringTokenizer;

public class SecretResearch {

    static BufferedReader bufferedReader;
    static PrintWriter printWriter;
    static StringTokenizer stringTokenizer;

    static void solve() throws Exception {

        int testCase;
        String code;


        testCase = nextInt();

        for(int i = 0; i < testCase; i++) {

            code = nextLine();
            check(code);
        }

    }

    static void check(String code) {

        String ans;
        if(code.equals("1") || code.equals("4") || code.equals("78"))
            ans = "+";
        else if(code.endsWith("35"))
            ans = "-";
        else if(code.startsWith("190"))
            ans = "?";
        else
            ans = "*";

        printWriter.println(ans);
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

    static String nextLine() throws IOException {
        String str;
        str = bufferedReader.readLine();
        return str;
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
