package com.hackerearth.graph;

import java.io.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
    Note: In HackerEarth they are considering root level as 1 instead of 0.
    So use return node[level -1] to get AC answer.
 */

public class BreadthFirstSearch_Tutorial {

    static BufferedReader bufferedReader;
    static PrintWriter printWriter;
    static StringTokenizer stringTokenizer;

    static void solve() throws Exception {

        int V = nextInt();
        Graph graph = new Graph(V);

        for(int i = 0; i < V-1; i++) {

            String[] temp = bufferedReader.readLine().split(" ");
            int A = Integer.parseInt(temp[0]);
            int B = Integer.parseInt(temp[1]);
            graph.addEdge(A,B);
        }

        int nodes = graph.BFS(1, nextInt());

        printWriter.println(nodes);
        printWriter.flush();
    }

    static class Graph {

        private int vertices;
        private LinkedList[] adjacentList;

        public Graph(int v) {

            vertices = v;
            adjacentList = new LinkedList[v+1];
            for(int i = 0; i <= v; i++)
                adjacentList[i] = new LinkedList();
        }

        void addEdge(int v, int w) {
            adjacentList[v].add(w);
            adjacentList[w].add(v);
        }

        int BFS(int source, int level) {

            boolean[] visited = new boolean[vertices+1];
            int[] nodes = new int[vertices+1];
            Queue<Integer> queue = new LinkedList<Integer>();

            visited[source] = true;
            nodes[0] = 1;
            queue.add(source);
            int count = 1, dequeCount = 0;

            while(queue.size() != 0) {

                source = queue.poll();
                dequeCount++;
               // printWriter.print(source + " ");
                Iterator<Integer> iterator = adjacentList[source].listIterator();

                while(iterator.hasNext()) {

                    int n = iterator.next();
                    if(!visited[n]) {
                        visited[n] = true;
                        queue.add(n);
                        nodes[count]++;
                    }
                }

                if(dequeCount == nodes[count-1]) {
                    dequeCount = 0;
                    count++;
                }
            }
            return nodes[level];
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
