package com.hackerearth.graph;

import java.io.*;
import java.util.*;

public class DepthFirstSearch_Tutorial {

    static BufferedReader bufferedReader;
    static PrintWriter printWriter;
    static StringTokenizer stringTokenizer;

    static void solve() throws Exception {

        String[] temp = bufferedReader.readLine().split(" ");
        int N = Integer.parseInt(temp[0]);
        int M = Integer.parseInt(temp[1]);
        Set<Integer> nodes = new HashSet<Integer>();

        Graph graph = new Graph(N);

        for(int i = 0; i < M; i++) {
            temp = bufferedReader.readLine().split(" ");
            int a = Integer.parseInt(temp[0]);
            int b = Integer.parseInt(temp[1]);

            nodes.add(a);
            nodes.add(b);
            graph.addEdge(a,b);
        }

        graph.DFS(nextInt());

        int ans = (graph.adjacentlist.length -1) - graph.count;
        printWriter.println(ans);
        printWriter.flush();
    }

    static class Graph {

        int vertices;
        LinkedList[] adjacentlist;
        int count;

        public Graph(int v) {
            vertices = v;
            count = 0;
            adjacentlist = new LinkedList[v+1];

            for(int i = 0; i <= v; i++)
                adjacentlist[i] = new LinkedList();
        }

        void addEdge(int u, int v) {
            adjacentlist[u].add(v);
            adjacentlist[v].add(u);
        }

        void DFS(int source) {

            boolean[] visited = new boolean[vertices+1];
            DFS_Util(source,visited);

        }

        void DFS_Util(int v, boolean[] visited) {

            visited[v] = true;
           // System.out.print(v +" ");
            count++;

            Iterator<Integer> iterator = adjacentlist[v].listIterator();
            while(iterator.hasNext()) {

                int n = iterator.next();
                if(!visited[n])
                    DFS_Util(n, visited);
            }
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
