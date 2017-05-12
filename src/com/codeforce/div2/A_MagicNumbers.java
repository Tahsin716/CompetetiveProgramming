package com.codeforce.div2;

import java.io.*;
import java.util.StringTokenizer;

public class A_MagicNumbers {

    static BufferedReader bufferedReader;
    static PrintWriter printWriter;
    static StringTokenizer stringTokenizer;

    static void solve() throws Exception {

        boolean flag = isMagicNumber(next());

        if(flag)
            printWriter.println("YES");
        else
            printWriter.println("NO");

        printWriter.flush();

    }

    static boolean isMagicNumber(String input) {
        if(input.charAt(0) != '1')
            return false;

        for(int i = 0; i < input.length(); i++)
            if(input.charAt(i) != '1' && input.charAt(i) != '4')
                return false;

        if(input.contains("444"))
            return false;

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

    static long nextLong() throws Exception {
        return Long.parseLong( next() );
    }
}
