package com.hackerearth.graph;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class ShortestPath_Tutorial {

    static BufferedReader bufferedReader;
    static PrintWriter printWriter;
    static StringTokenizer stringTokenizer;

    static void solve() throws Exception {



    }

    static class Graph {

        int vertices;
        LinkedList<WeightedEdge>[] adjacentList;

        public Graph(int vertices) {
            this.vertices = vertices;
            adjacentList = new LinkedList[vertices];

            for(int i = 1; i <= vertices; i++)
                adjacentList[i] = new LinkedList<WeightedEdge>();
        }

        void addEdge(int u, int v, int w) {
            adjacentList[u].add(new WeightedEdge(v,w));
            adjacentList[v].add(new WeightedEdge(u,w));
        }



    }

    static class WeightedEdge {
        int v, w;

        public WeightedEdge(int v, int w) {
            this.v = v;
            this.w = w;
        }
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
