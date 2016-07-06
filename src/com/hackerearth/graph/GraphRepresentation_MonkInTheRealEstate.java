package com.hackerearth.graph;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class GraphRepresentation_MonkInTheRealEstate {

    static BufferedReader bufferedReader;
    static PrintWriter printWriter;
    static StringTokenizer stringTokenizer;

    static void solve() throws Exception {

        int T = nextInt();
        int E;
        Set<Integer> city = new HashSet<Integer>();

        while(T-- > 0) {

            E = nextInt();
            for(int i = 0; i < E; i++) {
                String[] temp = bufferedReader.readLine().split(" ");
                city.add(Integer.parseInt(temp[0]));
                city.add(Integer.parseInt(temp[1]));
            }
            printWriter.println(city.size());
            city.clear();
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
