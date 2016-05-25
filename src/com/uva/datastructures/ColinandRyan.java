package com.uva.datastructures;

//Uva- 10880

import java.io.*;
import java.util.*;

public class ColinandRyan {

    static BufferedReader bufferedReader;
    static PrintWriter printWriter;
    static StringTokenizer stringTokenizer;


    static void solve() throws Exception{

        int testCase = nextInt();

        for(int i = 1; i <= testCase; i++) {

            int C = nextInt();
            int R = nextInt();

            printWriter.printf("Case #%d:",i);

            int cookiesAte = C - R;

            if(cookiesAte == 0) {
                printWriter.printf(" 0%n");
                continue;
            }
            else {

                //TreeSet keeps the elements in ascending order
                Set<Integer> divisors = new TreeSet<Integer>();

                //either divide by /j  or squareRoot; else it'll require a lot of time to compute
                for (int j = 1; j <=  cookiesAte/j; j++) {

                    if (cookiesAte % j == 0) {
                        if (j > R)
                            divisors.add(j);
                        if (cookiesAte / j > R)
                            divisors.add(cookiesAte / j);
                    }
                }

                for(Integer x : divisors)
                    printWriter.print(" " + x);

            }

            printWriter.println();
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
