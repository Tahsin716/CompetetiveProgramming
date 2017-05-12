package com.lightoj.beginner;

import java.io.*;
import java.util.StringTokenizer;

public class Beginner_1008 {

    static BufferedReader bufferedReader;
    static PrintWriter printWriter;
    static StringTokenizer stringTokenizer;

    static void solve() throws Exception {

        int testCase, cases = 1;
        long number, intersection, x, y, root, maxNum, minNum;

        testCase = nextInt();
        while(testCase-- > 0) {
            number = nextLong();

            root = (long) Math.ceil(Math.sqrt(number));
            maxNum = root*root;
            minNum = maxNum - (2*root) + 2;
            intersection = maxNum - root + 1;

            if(maxNum %2 == 1) {

                if(number == intersection){
                    x = y = root;
                }
                else if(number > intersection) {
                    x = root;
                    y = maxNum - number + 1;
                }
                else {
                    y = root;
                    x = number - minNum + 1;
                }
            }
            else {

                if(number == intersection) {
                    x = y = root;
                }
                else if(number > intersection) {
                    y = root;
                    x = maxNum - number + 1;
                }
                else {
                    x = root;
                    y = number - minNum + 1;
                }
            }
            printWriter.printf("Case %d: %d %d%n", cases++, y, x);
        }
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
