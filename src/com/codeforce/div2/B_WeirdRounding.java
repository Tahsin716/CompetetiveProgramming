package com.codeforce.div2;

import java.io.*;
import java.util.StringTokenizer;

public class B_WeirdRounding {

    static BufferedReader bufferedReader;
    static PrintWriter printWriter;
    static StringTokenizer stringTokenizer;

    static void solve() throws Exception {

        String[] temp = bufferedReader.readLine().split(" ");
        char[] number = temp[0].toCharArray();
        int k = Integer.parseInt(temp[1]);
        int count = 0, zeroes = 0;

        for(int i = number.length - 1; i >= 0; i--) {
            if(number[i] != '0')
                count++;
            else {
                zeroes++;
            }

            if(zeroes == k)
                break;
        }

        if(number.length - count > k)
            printWriter.println(count);
        else
            printWriter.println(number.length - 1);

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
