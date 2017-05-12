package com.codeforce.div2;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B_BigSegment {

    static BufferedReader bufferedReader;
    static PrintWriter printWriter;
    static StringTokenizer stringTokenizer;

    static void solve() throws Exception {

        int testCase = nextInt();
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE, counter = -1;
        ArrayList<Pairs> pairses = new ArrayList<Pairs>();

        for(int i = 0; i < testCase; i++) {
            pairses.add(new Pairs(nextInt(), nextInt()));

            max = (max < pairses.get(i).y) ? pairses.get(i).y : max;
            min = (min > pairses.get(i).x) ? pairses.get(i).x : min;
        }

        for(int i = 0; i < testCase; i++) {
            if(pairses.get(i).x <= min && pairses.get(i).y >= max)
                counter = i;
        }

        if(counter == -1)
            printWriter.println(-1);
        else
            printWriter.println(counter + 1);

        printWriter.flush();
    }

     static class Pairs {
        int x, y;

        public Pairs(int x, int y) {
            this.x = x;
            this.y = y;
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

    static long nextLong() throws Exception {
        return Long.parseLong( next() );
    }
}
