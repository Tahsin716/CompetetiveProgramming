package com.uva.datastructures;

//Uva- 11321

/*
    o is the object which is being compared
    if this.value > o.value return -1
    else if this.value < o.value return 1
 */

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class SortSortAndSort {

    static BufferedReader bufferedReader;
    static PrintWriter printWriter;
    static StringTokenizer stringTokenizer;
    static int M;

    static void solve() throws Exception {


        while(true) {

            String[] temp = bufferedReader.readLine().split(" ");
            int N = Integer.parseInt(temp[0]);
            M = Integer.parseInt(temp[1]);

            printWriter.println(N + " " + M);
            if(N == 0 && M == 0)
                break;

            ArrayList<Mod> mods = new ArrayList<Mod>();

            for(int i = 0; i < N; i++)
                mods.add(new Mod(nextInt()));

            Collections.sort(mods);

            for(int i = 0; i < N; i++)
                printWriter.println(mods.get(i).num);

        }
        printWriter.flush();
    }

    static class Mod implements Comparable<Mod> {

        int num;
        public Mod(int num) {
            this.num = num;
        }

        @Override
        public int compareTo(Mod o) {

            int mod1 = (Math.abs(this.num) % M) * (this.num < 0 ? -1 : 1);
            int mod2 = (Math.abs(o.num) % M) * (o.num < 0 ? -1 : 1);

            if (mod1 != mod2)
                return mod1 - mod2;


            int mod11 = Math.abs(this.num)%2;
            int mod22 = Math.abs(o.num)%2;

            if (mod11 == 0 && mod22 == 1)
                return 1;
            if (mod11 == 1 && mod22 == 0)
                return -1;
            if (mod11 == 1 && mod22 == 1 && o.num <= this.num)
                return -1;
            if (mod11 == 1 && mod22 == 1 && o.num > this.num)
                return 1;
            if (mod11 == 0 && mod22 == 0 && o.num <= this.num)
                return 1;
            if (mod11 == 0 && mod22 == 0 && o.num > this.num)
                return -1;
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
}
