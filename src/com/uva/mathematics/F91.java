package com.uva.mathematics;

// Uva - 10696

import java.io.*;
import java.util.StringTokenizer;

public class F91 {

    static BufferedReader bufferedReader;
    static PrintWriter printWriter;
    static StringTokenizer stringTokenizer;

    static void solve() throws Exception {
        long N, ans;

        while ( (N = nextLong()) != 0) {

            ans = f91(N);
            printWriter.printf("f91(%d) = %d%n", N, ans);
        }
        printWriter.flush();
    }

    static long f91(long N) {

        if (N >= 101) {
            return N - 10;
        }

        return f91(f91(N+11));
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

    static long nextLong() throws IOException {
        return Long.parseLong( next() );
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
