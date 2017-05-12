package com.codeforce.div2;

import java.io.*;
import java.util.StringTokenizer;

public class B_CodeObfuscation {

    static BufferedReader bufferedReader;
    static PrintWriter printWriter;
    static StringTokenizer stringTokenizer;

    static void solve() throws Exception {

        String input = bufferedReader.readLine();
        int counter = 0;
        String ans = "YES";

        for(int i = 0; i < input.length(); i++) {
            if(input.charAt(i) - 'a' > counter) {
                ans = "NO";
                break;
            }
            else if(input.charAt(i) - 'a' == counter) {
                counter++;
            }
        }

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
