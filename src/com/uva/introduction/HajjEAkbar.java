package com.uva.introduction;

//Uva- 12577

import java.io.*;
import java.util.StringTokenizer;

public class HajjEAkbar {

    static BufferedReader bufferedReader;
    static PrintWriter printWriter;
    static StringTokenizer stringTokenizer;

    static void solve() throws Exception {

        String word;
        int count = 1;

        while ( true ) {

            word = next();

            if(word.equals("*"))
                return;
            else {
                String ans = (word.equals("Hajj")) ? "Hajj-e-Akbar" : "Hajj-e-Asghar";

                printWriter.println("Case " + count + ": " + ans);
                printWriter.flush();
                count++;
            }
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

    static String next() throws IOException {
        while (stringTokenizer == null || !stringTokenizer.hasMoreTokens()) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        }
        return stringTokenizer.nextToken();
    }
}
