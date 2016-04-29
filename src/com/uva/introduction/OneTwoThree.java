package com.uva.introduction;

//Uva- 12289

import java.io.*;
import java.util.StringTokenizer;

public class OneTwoThree {

    static BufferedReader bufferedReader;
    static PrintWriter printWriter;
    static StringTokenizer stringTokenizer;

    static void solve() throws Exception {

        int testCase = nextInt();
        String word;

        for(int i = 0; i < testCase; i++) {
            word = next();
            int ans = check(word);

            printWriter.println(ans);
            printWriter.flush();
        }
    }

    static int check(String word) {
        int ans = 0;

        if(word.length() == 5)
            ans = 3;
        else {

            if( (word.startsWith("o")) && (word.endsWith("e")) ||
                (word.startsWith("o")) && ((word.charAt(1)) == 'n') ||
                ((word.charAt(1)) == 'n') && word.endsWith("e") )
                ans = 1;
            else
                ans = 2;
        }
        return ans;
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
