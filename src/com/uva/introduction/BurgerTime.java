package com.uva.introduction;

//Uva- 11661


import java.io.*;
import java.util.StringTokenizer;

public class BurgerTime {

    static BufferedReader bufferedReader;
    static PrintWriter printWriter;
    static StringTokenizer stringTokenizer;

    static void solve() throws Exception {

        int testCase;
        String str;

        while(true) {

            testCase = nextInt();
            if(testCase == 0)
                break;

            int minDistance = 200000000;
            int lastR = -minDistance, lastD = - minDistance;

            str = nextLine();
            char[] strChar = str.toCharArray();

            for(int i = 0; i < testCase; i++) {

                if(strChar[i] == 'Z') {
                    minDistance = 0;
                    break;
                }
                else if(strChar[i] == 'R') {
                    minDistance = Math.min(minDistance, i - lastD);
                    lastR = i;
                }
                else if(strChar[i] == 'D') {
                    minDistance = Math.min(minDistance, i - lastR);
                    lastD = i;
                }
            }

            printWriter.println(minDistance);
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
