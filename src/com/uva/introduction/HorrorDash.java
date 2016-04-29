package com.uva.introduction;

//Uva- 11799

import java.io.*;
import java.util.StringTokenizer;

public class HorrorDash {

    static BufferedReader bufferedReader;
    static PrintWriter printWriter;
    static StringTokenizer stringTokenizer;

    static void solve() throws Exception {

        int testCase, number, temp, speed, count = 1;

        testCase = nextInt();

        for(int i = 0; i < testCase; i++) {

            number = nextInt();
            temp = 0;

            for(int j = 0; j < number; j++) {

                speed = nextInt();

                if(j == 0)
                    temp = speed;
                else {
                    if(speed > temp)
                        temp = speed;
                }
            }

            printWriter.println("Case " + count + ": " + temp);
            printWriter.flush();
            count++;
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
        while (stringTokenizer == null || !stringTokenizer.hasMoreTokens()) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        }
        return stringTokenizer.nextToken();
    }
}
