package com.hackerearth.graph;

import java.io.*;
import java.util.StringTokenizer;

public class GraphRepresentation_Tutorial {

    static BufferedReader bufferedReader;
    static PrintWriter printWriter;
    static StringTokenizer stringTokenizer;

    static void solve() throws Exception {

        int N = nextInt();
        int M = nextInt();
        boolean[][] adjacencyMatrix = new boolean[N+1][N+1];

        for(int i = 0; i < M; i++) {

            String[] temp = bufferedReader.readLine().split(" ");
            int A = Integer.parseInt(temp[0]);
            int B = Integer.parseInt(temp[1]);

            adjacencyMatrix[A][B] = true;
            adjacencyMatrix[B][A] = true;

        }

        int Q = nextInt();

        for(int i = 0; i < Q; i++) {

            String[] temp = bufferedReader.readLine().split(" ");
            int A = Integer.parseInt(temp[0]);
            int B = Integer.parseInt(temp[1]);

            if(adjacencyMatrix[A][B] || adjacencyMatrix[B][A])
                printWriter.println("YES");
            else
                printWriter.println("NO");
        }

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
