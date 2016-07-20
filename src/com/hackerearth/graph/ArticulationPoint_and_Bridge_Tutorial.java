package com.hackerearth.graph;

import java.io.*;
import java.util.*;

public class ArticulationPoint_and_Bridge_Tutorial {

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

        graph.AP();
        System.out.println();
        graph.Bridge();
    }

    static class Graph {

        int vertices;
        LinkedList<Integer>[] adjacentlist;
        int time;
        int apCount = 0;
        int bridgeCount = 0;

        public Graph(int v) {
            vertices = v;
            adjacentlist = new LinkedList[v];

            for(int i = 0; i < v; i++)
                adjacentlist[i] = new LinkedList();
        }

        void addEdge(int u, int v) {
            adjacentlist[u].add(v);
            adjacentlist[v].add(u);
        }

        void AP() {

            boolean[] visited = new boolean[vertices];
            int[] discovered = new int[vertices];
            int[] low = new int[vertices];
            int[] parent = new int[vertices];
            boolean[] ap = new boolean[vertices];
            time = 0;

            Arrays.fill(parent, -1);
            Arrays.fill(visited, false);
            Arrays.fill(ap, false);

            for(int i = 0; i < vertices; i++) {
                if(!visited[i])
                    AP_Util(i, visited, discovered, low, parent,ap);
            }

            System.out.println(apCount);
            for(int i = 0; i < vertices; i++) {
                if(ap[i])
                    System.out.print(i + " ");
            }
        }

        void AP_Util(int u, boolean[] visited, int[] discovered, int[] low, int[] parent, boolean[] ap) {

            int children = 0;
            visited[u] = true;

            discovered[u] = low[u] = ++time;
            Iterator<Integer> iterator = adjacentlist[u].iterator();

            while(iterator.hasNext()) {

                int v = iterator.next();
                if(!visited[v]) {

                    children++;
                    parent[v] = u;
                    AP_Util(v, visited, discovered, low, parent, ap);

                    low[u] = Math.min(low[u], low[v]);

                    if(parent[u] == -1 && children > 1)
                        { ap[u] = true; apCount++; }

                    if(parent[u] != -1 && low[v] >= discovered[u])
                        { ap[u] = true; apCount++; }

                }
                else if(v != parent[u])
                    low[u] = Math.min(low[u], discovered[v]);
            }
        }

        void Bridge() {

            boolean[] visited = new boolean[vertices];
            int[] discovered = new int[vertices];
            int[] low = new int[vertices];
            int[] parent = new int[vertices];
            TreeSet<String> bridges = new TreeSet<String>();
            time = 0;

            Arrays.fill(parent, -1);
            Arrays.fill(visited, false);

            for(int i = 0; i < vertices; i++) {
                if(!visited[i])
                    Bridge_Util(i, visited,discovered,low,parent, bridges);
            }

            System.out.println(bridgeCount);
            for(String ans: bridges)
                System.out.println(ans);
        }

        void Bridge_Util(int u, boolean[] visited, int[] discovered, int[] low, int[] parent, TreeSet<String> bridges) {

            visited[u] = true;

            discovered[u] = low[u] = ++time;
            Iterator<Integer> iterator = adjacentlist[u].iterator();

            while(iterator.hasNext()) {

                int v = iterator.next();
                if(!visited[v]) {

                    parent[v] = u;
                    Bridge_Util(v,visited,discovered,low,parent,bridges);

                    low[u] = Math.min(low[u],low[v]);

                    if(low[v] > discovered[u]){
                        bridges.add(u +" "+ v);
                        bridgeCount++;
                    }

                }
                else if(v != parent[u])
                    low[u] = Math.min(low[u], discovered[v]);
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
