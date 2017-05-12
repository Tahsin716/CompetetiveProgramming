package com.codeforce.div2;

import java.io.*;
import java.util.StringTokenizer;

public class A_AndryushaAndSocks {

    static BufferedReader bufferedReader;
    static PrintWriter printWriter;
    static StringTokenizer stringTokenizer;

    static void solve() throws Exception {

        int pairs = nextInt();
        int max = 0, temp = 0, sock;
        int[] frequency = new int[100005];

        for(int i = 0; i < 2*pairs; i++) {
            sock = nextInt();

            if(frequency[sock] == 0) {
                temp++;
                frequency[sock]++;
                max = (temp > max) ? temp : max;
            }
            else
                temp--;
        }

        printWriter.println(max);
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
