package com.hackerearth.graph;

import java.io.*;
import java.util.*;

public class StronglyConnectedComponent_Tutorial {

    static BufferedReader bufferedReader;
    static PrintWriter printWriter;
    static StringTokenizer stringTokenizer;

    static void solve() throws Exception {

        String[] temp = bufferedReader.readLine().split(" ");
        int N = Integer.parseInt(temp[0]);
        int M = Integer.parseInt(temp[1]);
        int C = 0, D = 0;

        Graph graph = new Graph(N);

        for(int i = 0; i < M; i++) {

            temp = bufferedReader.readLine().split(" ");
            int a = Integer.parseInt(temp[0]);
            int b = Integer.parseInt(temp[1]);

            graph.adjacentList[a].add(b);
        }

        ArrayList<ArrayList<Integer>> SCC_Components = graph.Kosaraju_SCC();

       /* for(ArrayList<Integer> index: SCC_Components) {
            for(int scc: index)
                printWriter.print(scc + " ");
            printWriter.println();
        } */

        for(ArrayList<Integer> index: SCC_Components) {

            int sum = 0, count = 0;

            for(int scc : index) {
                sum += scc;
                count++;
            }

            if(count%2 == 0) C += sum;
            else D += sum;
        }

        int ans = C - D;
        printWriter.println(ans);
        printWriter.flush();
    }

    static class Graph {

        int vertices;
        ArrayList<Integer>[] adjacentList;

        public Graph(int v) {
            vertices = v;
            adjacentList = new ArrayList[v+1];

            for(int i = 0; i <= v; i++)
                adjacentList[i] = new ArrayList<Integer>();
        }

        void DFS(ArrayList<Integer>[] graph, int v, boolean[] visited, ArrayList<Integer> complete) {

            visited[v] = true;
            for(int i = 0; i < graph[v].size(); i++)
                if(!visited[graph[v].get(i)])
                    DFS(graph, graph[v].get(i), visited, complete);

            complete.add(v);
        }

        ArrayList<Integer> fillOrder(ArrayList<Integer>[] graph, boolean[] visited) {

            int V = graph.length;
            ArrayList<Integer> order = new ArrayList<Integer>();

            for(int i = 0; i < V; i++)
                if(!visited[i])
                    DFS(graph, i, visited, order);

            return order;
        }

        ArrayList<Integer>[] getTranspose(ArrayList<Integer>[] graph) {

            int V = graph.length;
            ArrayList<Integer>[] g = new ArrayList[V];

            for(int i = 0; i < V; i++)
                g[i] = new ArrayList<Integer>();

            for(int v = 0; v < V; v++)
                for(int i = 0; i < graph[v].size(); i++)
                    g[graph[v].get(i)].add(v);

            return g;
        }

        ArrayList<ArrayList<Integer>> Kosaraju_SCC() {

            int V = adjacentList.length;
            boolean[] visited = new boolean[V];
            ArrayList<Integer> order = fillOrder(adjacentList, visited);

            ArrayList<Integer>[] reverseGraph = getTranspose(adjacentList);
            visited = new boolean[V];
            Collections.reverse(order);

            ArrayList<ArrayList<Integer>> SCC_complete = new ArrayList<ArrayList<Integer>>();

            for(int i = 0; i < order.size(); i++) {

                int v = order.get(i);
                if(!visited[v]) {

                    ArrayList<Integer> complete = new ArrayList<Integer>();
                    DFS(reverseGraph, v, visited, complete);
                    SCC_complete.add(complete);
                }
            }

            return SCC_complete;
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
