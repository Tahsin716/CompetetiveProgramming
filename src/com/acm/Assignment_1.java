package com.acm;

import java.io.*;
import java.util.StringTokenizer;

public class Assignment_1 {

    static BufferedReader bufferedReader;
    static PrintWriter printWriter;
    static StringTokenizer stringTokenizer;

    static void solve() throws Exception {

        String str = bufferedReader.readLine();
        int commaCount = 0, semicolonCount = 0;

        for(int i = 0; i < str.length(); i++) {

            if(str.charAt(i) == ',')
                commaCount++;
            else if(str.charAt(i) == ';')
                semicolonCount++;

        }

        printWriter.printf("Number of Comma: %d%nNumber of Semi-colon: %d%n",commaCount,semicolonCount);
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
