package com.uva.introduction;

//Uva- 12372

import java.io.*;
import java.util.StringTokenizer;

public class PackingForHoliday {

    static BufferedReader bufferedReader;
    static PrintWriter printWriter;
    static StringTokenizer stringTokenizer;

    static void solve() throws Exception {

        int testCase = nextInt();
        int length, width, height, count = 1;

        for(int i = 0; i < testCase; i++) {
            length = nextInt();
            width = nextInt();
            height = nextInt();

            String ans = check(length,width,height);

            printWriter.println("Case " + count + ": " + ans);
            printWriter.flush();
            count++;
        }
    }

    static String check(int l, int w, int h) {

        if( (l <= 20) && (w <= 20) && (h <= 20))
            return "good";
        else
            return "bad";
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
