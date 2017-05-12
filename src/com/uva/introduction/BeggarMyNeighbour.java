package com.uva.introduction;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BeggarMyNeighbour {

    static BufferedReader bufferedReader;
    static PrintWriter printWriter;
    static StringTokenizer stringTokenizer;

    static void solve() throws Exception {

        String temp;
        String[] tmp;
        String[] cards = new String[52];
        int counter = 0, index = 0;

        while(true) {
            temp = bufferedReader.readLine();
            if(temp.equals("#"))
                break;
            tmp = temp.split(" ");

            for(int i = 0; i < 13; i++)
                cards[index++] = tmp[i];

            ++counter;

            if(counter == 4) {

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

    static long nextLong() throws Exception {
        return Long.parseLong( next() );
    }
}
