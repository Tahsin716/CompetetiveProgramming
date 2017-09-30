package com.uva.mathematics;

// UVA - 847

import java.io.*;
import java.util.StringTokenizer;

public class AMultiplicationGame {

    static BufferedReader bufferedReader;
    static PrintWriter printWriter;
    static StringTokenizer stringTokenizer;

    static void solve() throws Exception {

        String str;
        String[] input;
        long n, p;
        boolean stanTurn;

        while ( (str = bufferedReader.readLine()) != null ) {
            input = str.split(" ");
            n = Long.parseLong(input[0]);

            p = 1;
            stanTurn = true;

            while (p < n) {
                if(stanTurn)
                    p *= 9;
                else
                    p *= 2;

                stanTurn = !stanTurn;
            }

            if(!stanTurn)
                printWriter.println("Stan wins.");
            else
                printWriter.println("Ollie wins.");
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
