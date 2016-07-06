package com.hackerearth.graph;

import java.io.*;
import java.util.StringTokenizer;

public class GraphRepresentation_MonkAtTheGraphFactory {

    static BufferedReader bufferedReader;
    static PrintWriter printWriter;
    static StringTokenizer stringTokenizer;


    static void solve() throws Exception {

        int N = nextInt();
        int[] degrees = new int[N];
        int sum = 0;

        for(int i = 0; i < N; i++) {
            degrees[i] = nextInt();
            sum += degrees[i];
        }

        if(sum/2 == N-1)
            printWriter.println("Yes");
        else
            printWriter.println("No");

        printWriter.flush();

    }

    public static void main(String[] args) {

        try {

            //bufferedReader = new BufferedReader(new FileReader("input.txt"));
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
