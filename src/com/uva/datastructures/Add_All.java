package com.uva.datastructures;

//UVa- 10954

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Add_All {

    static BufferedReader bufferedReader;
    static PrintWriter printWriter;
    static StringTokenizer stringTokenizer;

    static void solve() throws Exception {

        int testCase, cost, total;
        PriorityQueue<Integer>  priorityQueue;

        while( (testCase = nextInt()) != 0) {

            total = 0;
            priorityQueue = new PriorityQueue<Integer>();

            for(int i = 0; i < testCase; i++)
                priorityQueue.add( nextInt() );

            while ( priorityQueue.size() != 1) {

                cost = priorityQueue.poll() + priorityQueue.poll();
                total += cost;
                priorityQueue.add(cost);
            }
            printWriter.println(total);
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
}
