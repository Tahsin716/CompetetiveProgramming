package com.codeforce.div2;

import java.io.*;
import java.util.StringTokenizer;

/**
 *  Total combination always repeats after six moves
 *
 *      0 1 2
 *   -----------
 *      1 0 2
 *      1 2 0
 *      2 1 0
 *      2 0 1
 *      0 2 1
 *      0 1 2
 *              (6x3)
 */

public class A_ShellGame {

    static BufferedReader bufferedReader;
    static PrintWriter printWriter;
    static StringTokenizer stringTokenizer;

    static void solve() throws Exception {

        int[][] combination = new int[][]{{0, 1, 2}, {1, 0, 2}, {1,2,0}, {2,1,0}, {2,0,1}, {0,2,1}};

        int moves = nextInt();
        int position = nextInt();

        printWriter.println(combination[moves%6][position]);
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
