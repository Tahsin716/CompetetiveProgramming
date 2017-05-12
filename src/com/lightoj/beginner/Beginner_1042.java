package com.lightoj.beginner;


import java.io.*;
import java.util.StringTokenizer;

public class Beginner_1042 {

    static BufferedReader bufferedReader;
    static PrintWriter printWriter;
    static StringTokenizer stringTokenizer;

    static void solve() throws Exception {

        int testCase, number, cardinality, temp, cases = 1, tempCardinality;
        boolean flag;

        testCase = nextInt();
        while (testCase-- > 0) {

            number = nextInt();
            temp = number + 1;
            tempCardinality = 0;
            cardinality = 0;
            flag = true;

            while(number > 0) {

                if(number % 2 == 1)
                    cardinality++;

                number = number / 2;
            }

            //System.out.println(cardinality);


            while (flag) {

                number = ++temp;
                tempCardinality= 0;

                while (number > 0) {

                    if (number %2 == 1)
                        tempCardinality++;

                    number = number / 2;
                }

                if(cardinality == tempCardinality) {
                    printWriter.printf("Case %d: %d%n", cases++, temp);
                    flag = false;
                }
            }
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
