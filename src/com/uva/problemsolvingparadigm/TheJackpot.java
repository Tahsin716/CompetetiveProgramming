package com.uva.problemsolvingparadigm;

//UVa- 10684

import java.io.*;
import java.util.StringTokenizer;

public class TheJackpot {

    static BufferedReader bufferedReader;
    static PrintWriter printWriter;
    static StringTokenizer stringTokenizer;

    static void solve() throws Exception {

        int testCase;
        while((testCase = nextInt()) != 0) {

            int max = 0, maxSubSum = -1;

            int[] num = new int[testCase+1];

            for(int i = 0; i < testCase; i++) {

                num[i] = nextInt();

                if(maxSubSum >= 0)
                    maxSubSum += num[i];
                else {
                    maxSubSum = num[i];
                }

                if(max < maxSubSum)
                    max = maxSubSum;
            }

            if(max > 0)
                printWriter.printf("The maximum winning streak is %d.%n", max);
            else
                printWriter.println("Losing streak.");
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
