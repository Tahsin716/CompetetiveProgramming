package com.codeforce.div2;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class A_RankList {

    static BufferedReader bufferedReader;
    static PrintWriter printWriter;
    static StringTokenizer stringTokenizer;

    static void solve() throws Exception {

        int n = nextInt();
        int k = nextInt() - 1;
        int ans = 0;

        ArrayList<Pairs> pairses = new ArrayList<Pairs>();

        for(int i = 0; i < n; i++) {
            pairses.add(new Pairs(nextInt(), nextInt()));
        }

        Collections.sort(pairses);
        int solved = pairses.get(k).solve;
        int penalty = pairses.get(k).penalty;


        for(int i = k; i >= 0; i--){
            if(pairses.get(i).solve == solved && pairses.get(i).penalty == penalty)
                ans++;
            else
                break;
        }

        for(int i = k + 1; i < n; i++) {
            if(pairses.get(i).solve == solved && pairses.get(i).penalty == penalty)
                ans++;
            else
                break;
        }

        printWriter.println(ans);
        printWriter.flush();

    }

    static class Pairs implements Comparable<Pairs> {

        int solve, penalty;

        public Pairs(int solve, int penalty) {
            this.solve = solve;
            this.penalty = penalty;
        }

        @Override
        public int compareTo(Pairs o) {
            if(this.solve > o.solve)
                return -1;
            else if(this.solve == o.solve && this.penalty == o.penalty)
                return 0;
            else if(this.solve == o.solve && this.penalty < o.penalty)
                return -1;
            else
                return 1;
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

    static long nextLong() throws Exception {
        return Long.parseLong( next() );
    }
}
