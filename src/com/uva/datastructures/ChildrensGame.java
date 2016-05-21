package com.uva.datastructures;

//Uva- 10905

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class ChildrensGame {

    static BufferedReader bufferedReader;
    static PrintWriter printWriter;
    static StringTokenizer stringTokenizer;


    static class Num implements Comparable<Num> {

        char[] n;
        public Num(char[] n) {
            this.n = n;
        }

        @Override
        public int compareTo(Num o) {

            char[] N1 = this.n;
            char[] N2 = o.n;

            String s1 = String.valueOf(N1) + String.valueOf(N2);
            String s2 = String.valueOf(N2) + String.valueOf(N1);

            if(s1.compareTo(s2) >0) return -1;
            if(s1.compareTo(s2) <0) return 1;
            return 0;
        }
    }


    static void solve() throws Exception {

        int testCase;
        while( (testCase = nextInt()) > 0) {

            ArrayList<Num> nums = new ArrayList<Num>();
            for(int i = 0; i < testCase; i++)
                nums.add(new Num( next().toCharArray()));

            Collections.sort(nums);
            for(int i = 0; i < testCase; i++) {
                printWriter.print(nums.get(i).n);
            }
            printWriter.println();
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
