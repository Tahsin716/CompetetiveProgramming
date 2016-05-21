package com.uva.introduction;

//Uva- 573

import java.io.*;
import java.util.StringTokenizer;

public class TheSnail {

    static BufferedReader bufferedReader;
    static PrintWriter printWriter;
    static StringTokenizer stringTokenizer;


    static void solve() throws Exception {

        int h, u ,d, f;
        String str;
        String[] temp;

        while (true) {

            str = nextLine();
            if(str.startsWith("0"))
                break;

            temp = str.split(" ");
            h = Integer.parseInt(temp[0]);
            u = Integer.parseInt(temp[1]);
            d = Integer.parseInt(temp[2]);
            f = Integer.parseInt(temp[3]);

            double currentU = u;
            double distFatigue = u*(f/100.0);
            double currentH = 0;
            int currentDay = 0;
            String ans;

            while(true) {

                currentDay++;

                currentH += currentU;
                if(currentH > h) {
                    ans = "success on day ";
                    break;
                }

                currentH -= d;
                if(currentH < 0) {
                    ans = "failure on day ";
                    break;
                }

                currentU -= distFatigue;
                if(currentU < 0)
                    currentU = 0;
            }

            printWriter.println(ans + currentDay);
            printWriter.flush();
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

    static String nextLine() throws IOException {
        String str;
        str = bufferedReader.readLine();
        return str;
    }
}
