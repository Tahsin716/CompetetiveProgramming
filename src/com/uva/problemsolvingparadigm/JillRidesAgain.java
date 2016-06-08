package com.uva.problemsolvingparadigm;

//Uva- 507

import java.io.*;
import java.util.StringTokenizer;

public class JillRidesAgain {

    static BufferedReader bufferedReader;
    static PrintWriter printWriter;
    static StringTokenizer stringTokenizer;

    static void solve() throws Exception {

        int testCase = nextInt();

        for(int j = 1; j <= testCase; j++) {

            int maxSubSum = -1, start = -1;
            int max = 0, maxStart = 0, maxEnd = 0;

            int[] num = new int[200001];
            int routes = nextInt();

            for(int i = 1; i < routes; i++) {

                num[i] = nextInt();

                if (maxSubSum >= 0)
                    maxSubSum += num[i];
                else {
                    maxSubSum = num[i];
                    start = i;
                }

                if(maxSubSum > max || (maxSubSum == max && i+1 - start > maxEnd - maxStart)) {

                    max = maxSubSum;
                    maxStart = start;
                    maxEnd = i + 1;
                }
            }

            if (max == 0)
                printWriter.printf("Route %d has no nice parts%n", j);
            else
                printWriter.printf("The nicest part of route %d is between stops %d and %d%n",j, maxStart, maxEnd);

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
}
