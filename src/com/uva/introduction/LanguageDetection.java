package com.uva.introduction;

//Uva- 12250

import java.io.*;
import java.util.StringTokenizer;

public class LanguageDetection {

    static BufferedReader bufferedReader;
    static PrintWriter printWriter;
    static StringTokenizer stringTokenizer;

    static void solve() throws  Exception {

        String word;
        int count = 1;
        boolean flag = true;

        while(flag) {
            word = next();

            if( word.equals("#") ) // using == will refer to memory block
                flag = false;
            else {

                String ans = check(word);
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

    static String check(String word) {
        String ans = "UNKNOWN";

        if (word.equals("HELLO")) {
            ans = "ENGLISH";

        } else if (word.equals("HOLA")) {
            ans = "SPANISH";

        } else if (word.equals("HALLO")) {
            ans = "GERMAN";

        } else if (word.equals("BONJOUR")) {
            ans = "FRENCH";

        } else if (word.equals("CIAO")) {
            ans = "ITALIAN";

        } else if (word.equals("ZDRAVSTVUJTE")) {
            ans = "RUSSIAN";

        } else {
            ans = "UNKNOWN";
        }
        return ans;
    }
}
