package com.uva.datastructures;

//UVa- 10935

import java.io.*;
import java.util.*;

public class Throwing_cards_away_I {

    static BufferedReader bufferedReader;
    static PrintWriter printWriter;
    static StringTokenizer stringTokenizer;

    static void solve() throws Exception {

        int testCase;
        while( !((testCase = nextInt()) == 0)) {

            ArrayList<Integer> cards = new ArrayList<Integer>();
            Queue<Integer> discarded = new LinkedList<Integer>();

            for(int i = 1; i <= testCase; i++)
                cards.add(i);

            while(cards.size() > 1) {

                int top = cards.get(0);
                discarded.add(top);
                cards.remove(0);

                top = cards.get(0);
                cards.remove(0);
                cards.add(top);
            }

            printWriter.print("Discarded cards:");
            while (discarded.size() != 0){
                if(discarded.size() > 1)
                    printWriter.printf(" %d,", discarded.remove());
                else
                    printWriter.printf(" %d", discarded.remove());
            }
            printWriter.printf("%nRemaining card: %d%n", cards.get(0));
        }
        printWriter.flush();
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
