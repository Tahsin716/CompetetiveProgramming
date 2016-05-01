package com.uva.introduction;

//Uva- 12157

import java.io.*;
import java.util.StringTokenizer;

public class TariffPlanning {

    static BufferedReader bufferedReader;
    static PrintWriter printWriter;
    static StringTokenizer stringTokenizer;


    static void solve() throws Exception {

        int testCase, number, miles, juice, callDuration;

        testCase = nextInt();

        for(int i = 1; i <= testCase; i++) {

            number = nextInt();
            miles = 0;
            juice = 0;

            for(int j = 0; j < number; j++) {
                callDuration = nextInt();

                miles += ((callDuration/30) +1)*10;  //(callDuration/30)*10 +10 also works
                juice += ((callDuration/60) +1)*15; //((callDuration/60))*15 +15 also works
            }

            if(miles < juice) {
                printWriter.println("Case "+ i +": Mile " + miles);
                printWriter.flush();
            }
            else if(miles > juice) {
                printWriter.println("Case "+ i +": Juice " + juice);
                printWriter.flush();
            }
            else {
                printWriter.println("Case "+ i +": Mile Juice " + miles);
                printWriter.flush();
            }

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
}
