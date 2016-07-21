package com.hackerearth.graph;

import java.io.*;
import java.util.*;

public class BiconnectedComponents_Tutorial {

    static BufferedReader bufferedReader;
    static PrintWriter printWriter;
    static StringTokenizer stringTokenizer;

    static void solve() throws Exception {

        int N = nextInt();
        int M = nextInt();

        Graph graph = new Graph(N);

        for(int i = 0; i < M; i++) {

            int x = nextInt();
            int y = nextInt();

            graph.addEdge(x,y);
        }

        graph.BCC();
        printWriter.println(graph.getOddVertice() +" "+ graph.getEvenVertice());
    }

    static class Graph {

        int vertices, edgeCount, count ,time, sum, evenEdge, oddEdge, oddVertice, evenVertice;
        LinkedList<Integer>[] adjacentList;
        HashSet<Integer> verticeCount = new HashSet<Integer>();

        public Graph(int vertices) {
            this.vertices = vertices;
            edgeCount = evenEdge = oddEdge = 0;
            sum = 0;
            oddVertice = evenVertice = 0;
            count = 0;
            time = 0;
            adjacentList = new LinkedList[vertices];

            for(int i = 0; i < vertices; i++)
                adjacentList[i] = new LinkedList<Integer>();
        }

        void addEdge(int u, int v) {
            adjacentList[u].add(v);
            adjacentList[v].add(u);
            edgeCount++;
        }

        int getEdgeCount() { return edgeCount; }
        int getEvenEdge() { return evenEdge; }
        int getOddEdge() { return oddEdge; }
        int getBCCCount() { return count; }
        int getOddVertice() { return oddVertice; }
        int getEvenVertice() { return evenVertice; }


        void BCC() {

            int[] discovered = new int[vertices];
            int[] low = new int[vertices];
            int[] parent = new int[vertices];
            LinkedList<Edge> edges = new LinkedList<Edge>();

            Arrays.fill(discovered, -1);
            Arrays.fill(low, -1);
            Arrays.fill(parent, -1);

            for(int i = 0; i < vertices; i++) {

                if(discovered[i] == -1)
                    BCC_Util(i, discovered,low,edges,parent);

                int flag = 0;
                sum = 0;
                verticeCount.clear();

                while(edges.size() > 0) {
                    flag = 1;
                   // System.out.print(edges.getLast().u + "--" + edges.getLast().v +" ");
                    sum++;
                    verticeCount.add(edges.getLast().u);
                    verticeCount.add(edges.getLast().v);
                    edges.removeLast();
                }
                if(flag == 1) {
                   // System.out.println();
                    count++;

                    if(sum%2 == 0) evenEdge += sum;
                    else oddEdge += sum;
                    sum = 0;

                    if(verticeCount.size()%2 == 0) evenVertice++;
                    else oddVertice++;
                    verticeCount.clear();
                }
            }
        }

        void BCC_Util(int u, int[] discovered, int[] low, LinkedList<Edge> edges, int[] parent) {

            discovered[u] = low[u] = ++time;
            int children = 0;

            Iterator<Integer> iterator = adjacentList[u].iterator();

            while(iterator.hasNext()) {

                int v = iterator.next();
                if(discovered[v] == -1) {

                    children++;
                    parent[v] = u;

                    edges.add(new Edge(u,v));
                    BCC_Util(v,discovered,low,edges,parent);

                    if(low[u] > low[v])
                        low[u] = low[v];

                    if( (discovered[u] == 1 && children > 1) || (discovered[u] > 1 && low[v] >= discovered[u])) {

                        while(edges.getLast().u != u || edges.getLast().v != v) {
                           // System.out.print(edges.getLast().u +"--" + edges.getLast().v +" ");
                            verticeCount.add(edges.getLast().u);
                            verticeCount.add(edges.getLast().v);
                            edges.removeLast();
                            sum++;
                        }
                       // System.out.println(edges.getLast().u +"--" + edges.getLast().v +" ");
                        verticeCount.add(edges.getLast().u);
                        verticeCount.add(edges.getLast().v);
                        sum++;
                        edges.removeLast();
                        count++;

                        if(sum%2 == 0) evenEdge += sum;
                        else oddEdge += sum;
                        sum = 0;

                        if(verticeCount.size()%2 == 0) evenVertice++;
                        else oddVertice++;
                        verticeCount.clear();
                    }
                }
                else if(v != parent[u] && discovered[v] < low[u]) {

                    if(low[u] > discovered[v])
                        low[u] = discovered[v];
                    edges.add(new Edge(u,v));
                }
            }
        }
    }

    static class Edge {
        int u, v;

        public Edge(int u,int v) {
            this.u = u;
            this.v = v;
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
