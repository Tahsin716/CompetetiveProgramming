package com.hackerearth.graph;

import java.io.*;
import java.util.*;

public class BreadthFirstSearch_AgitatedChandan {

    static BufferedReader bufferedReader;
    static PrintWriter printWriter;
    static StringTokenizer stringTokenizer;

    static int[] distance, parent;
    static boolean[] visited;
    static int max;

    static void solve() throws Exception {

        int testCase = nextInt();
        while (testCase-- > 0) {

            int vertices = nextInt();
            int u, v, d;
            String[] temp;

            Graph graph = new Graph(vertices);

            for(int i = 0; i < vertices-1; i++) {
                temp = bufferedReader.readLine().split(" ");
                u = Integer.parseInt(temp[0]);
                v = Integer.parseInt(temp[1]);
                d = Integer.parseInt(temp[2]);

                graph.adjacentList[u].add(new int[]{v,d});
                graph.adjacentList[v].add(new int[]{u,d});
            }

            int start = graph.BFS(1);
            int node = graph.BFS(start);

            if(max > 10000) printWriter.println(10000 +" " + max);
            else if(max > 1000) printWriter.println(1000 +" "+ max);
            else if(max > 100) printWriter.println(100 +" " + max);
            else printWriter.println(0 +" "+ max);
        }
        printWriter.flush();
    }

    static class Graph {

        int vertices;
        ArrayList<int []> adjacentList[];

        public Graph(int v) {
            vertices = v;
            adjacentList = new ArrayList[v+1];

            for(int i = 0; i <= v; i++)
                adjacentList[i] = new ArrayList();
        }

        int BFS(int source) {

            distance = new int[vertices+1];
            parent = new int[vertices+1];
            visited = new boolean[vertices+1];

            ArrayList<Integer> queue = new ArrayList<Integer>();
            max = 0;
            int maxNode = source;

            queue.add(source);
            visited[source] = true;
            int current;

            while(!queue.isEmpty()) {

                current = queue.remove(0);
                for(int[] array: adjacentList[current]) {

                    if(!visited[array[0]]) {

                        visited[array[0]] = true;
                        queue.add(array[0]);
                        parent[array[0]] = current;
                        distance[array[0]] = distance[current] + array[1];

                        if(max < distance[array[0]]) {
                            max = distance[array[0]];
                            maxNode = array[0];
                        }
                    }
                }
            }
            return maxNode;
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
