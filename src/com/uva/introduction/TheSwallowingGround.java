package com.uva.introduction;

//Uva- 10963
//check to see if all y1-y2 = same for all values

import java.io.*;
import java.util.StringTokenizer;

public class TheSwallowingGround {

    static BufferedReader bufferedReader;
    static PrintWriter printWriter;
    static StringTokenizer stringTokenizer;

    static void solve() throws Exception {

        int testCase, columns, y1, y2, diff;

        testCase = nextInt();

        for(int i = 0; i < testCase; i++) {

            columns = nextInt();
            y1 = nextInt();
            y2 = nextInt();
            diff = Math.abs(y1 - y2);
            boolean flag = true;

            for(int j = 0; j < columns -1; j++) {

                y1 = nextInt();
                y2 = nextInt();

                if(Math.abs(y1 - y2) != diff)
                    flag = false;

            }
            String ans = (flag) ? "yes" : "no";

            printWriter.println(ans);
            printWriter.flush();

            if(i < testCase-1) {
                printWriter.println();
                printWriter.flush();
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
